/**
 * Initializes an array of 15-minute intervals for a given date.
 * Each interval starts with 0 hours worked and is marked as complete (false).
 *
 * @param {string} dateString - The date in 'YYYY-MM-DD' format (e.g., '2025-07-29').
 * @returns {Array<Object>} An array of 96 interval objects for the day.
 */
function initializeIntervals(dateString) {
    const intervals = [];
    const date = new Date(dateString); // Base date for the intervals

    // Generate 96 intervals (24 hours * 4 intervals/hour)
    for (let i = 0; i < 96; i++) {
        const startTimeLocal = new Date(date);
        startTimeLocal.setHours(0, 0, 0, 0); // Reset to the beginning of the day
        startTimeLocal.setMinutes(i * 15); // Set minutes for each 15-minute interval

        // Calculate UTC time from local time
        const startTimeUtc = new Date(startTimeLocal.getTime() - (startTimeLocal.getTimezoneOffset() * 60000));

        intervals.push({
            start_time_local: startTimeLocal,
            start_time_utc: startTimeUtc,
            minutes_duration: 15,
            hours_worked: 0,
            incomplete: false
        });
    }
    return intervals;
}

/**
 * Fills a range of intervals within the array with specified hours worked and incomplete status.
 *
 * @param {Array<Object>} intervalsArray - The array of 15-minute interval objects to modify.
 * @param {Date} startDt - The start Date object for the range (inclusive).
 * @param {Date} endDt - The end Date object for the range (exclusive).
 * @param {number} hoursVal - The hours_worked value to set (e.g., 0.25 for 15 minutes).
 * @param {boolean} incompleteVal - The incomplete status to set.
 */
function fillIntervals(intervalsArray, startDt, endDt, hoursVal, incompleteVal) {
    for (const interval of intervalsArray) {
        // Check if the interval's start time falls within the specified range
        if (interval.start_time_local.getTime() >= startDt.getTime() && interval.start_time_local.getTime() < endDt.getTime()) {
            interval.hours_worked = hoursVal;
            interval.incomplete = incompleteVal;
        }
    }
}

/**
 * Processes incoming punch-in/punch-out events and updates the existing daily intervals.
 *
 * @param {Array<Object>} incomingPunches - An array of punch objects (e.g., [{ in: '8:00 AM' }]).
 * @param {Array<Object>} existingIntervals - The initial array of 15-minute interval objects for the day.
 * @param {string} currentTimeStr - The current time in 'HH:MM' format (e.g., '10:00'). This is used to mark future incomplete periods.
 * @returns {Array<Object>} The updated array of 15-minute interval objects.
 */
function processPunchData(incomingPunches, existingIntervals, currentTimeStr) {
    // Create a deep copy to avoid modifying the original existingIntervals array
    const updatedIntervals = JSON.parse(JSON.stringify(existingIntervals));

    // Convert string dates back to Date objects for the copied intervals
    updatedIntervals.forEach(interval => {
        interval.start_time_local = new Date(interval.start_time_local);
        interval.start_time_utc = new Date(interval.start_time_utc);
    });

    // Extract the date part from the first interval's local time (assuming all intervals are for the same day)
    const dateStr = updatedIntervals[0].start_time_local.toISOString().split('T')[0];

    // Create a Date object for the current time on the specified date
    const currentDt = new Date(`${dateStr}T${currentTimeStr}:00`);

    // Normalize and sort incoming punches by time
    const sortedPunches = incomingPunches.map(p => {
        const type = Object.keys(p)[0]; // 'in' or 'out'
        const timeStr = Object.values(p)[0]; // '8:00 AM' or '12:PM' (handle potential typo)

        // Parse time string (e.g., "8:00 AM", "12:PM") to HH:MM format
        let [hour, minute, ampm] = timeStr.match(/(\d+):(\d+)\s*(AM|PM)?/i).slice(1);
        hour = parseInt(hour, 10);
        minute = parseInt(minute, 10);

        if (ampm) {
            ampm = ampm.toUpperCase();
            if (ampm === 'PM' && hour !== 12) {
                hour += 12;
            } else if (ampm === 'AM' && hour === 12) { // 12 AM is 00 hour
                hour = 0;
            }
        }
        const formattedTime = `${String(hour).padStart(2, '0')}:${String(minute).padStart(2, '0')}`;
        const punchTime = new Date(`${dateStr}T${formattedTime}:00`);
        return { type, time: punchTime };
    }).sort((a, b) => a.time.getTime() - b.time.getTime()); // Sort punches chronologically

    let isPunchedIn = false; // Tracks if the user is currently punched in
    // lastEffectivePunchTime marks the start of the current active period (worked or incomplete)
    let lastEffectivePunchTime = new Date(`${dateStr}T00:00:00`); // Initialize to beginning of the day

    // Iterate through each sorted punch event
    for (const punch of sortedPunches) {
        if (punch.type === 'in') {
            if (isPunchedIn) {
                // Scenario: "in, in" (e.g., punched in at 8:00, then again at 12:00 without an out)
                // This means the previous open shift is now considered complete up to the new 'in' time.
                fillIntervals(updatedIntervals, lastEffectivePunchTime, punch.time, 0.25, false);
            }
            isPunchedIn = true; // User is now punched in
            lastEffectivePunchTime = punch.time; // Start of the new active period
        } else if (punch.type === 'out') {
            if (isPunchedIn) {
                // Scenario: Valid "in, out" pair
                // Mark intervals from the last 'in' time to this 'out' time as worked (0.25) and complete (false).
                fillIntervals(updatedIntervals, lastEffectivePunchTime, punch.time, 0.25, false);
                isPunchedIn = false; // User is now punched out
                lastEffectivePunchTime = punch.time; // Start of the new inactive period
            } else {
                // Scenario: "out" without a prior 'in' or "out, out" (e.g., first punch is 'out', or 'out' after another 'out')
                // This implies that the period from the last effective punch time (or 00:00) up to this 'out' was incomplete work.
                fillIntervals(updatedIntervals, lastEffectivePunchTime, punch.time, 0.25, true);
                isPunchedIn = false; // Ensure state is 'out'
                lastEffectivePunchTime = punch.time; // Start of the new inactive period
            }
        }
    }

    // After processing all incoming punches, handle the remaining state of the day
    if (isPunchedIn) {
        // If still punched in, it means there's an open shift.
        // Mark intervals from the last 'in' time up to the current time as worked (0.25) and incomplete (true).
        fillIntervals(updatedIntervals, lastEffectivePunchTime, currentDt, 0.25, true);
        // Mark intervals from the current time to the end of the day as also incomplete (true),
        // as the associate is presumed to be still working.
        fillIntervals(updatedIntervals, currentDt, new Date(`${dateStr}T23:59:59`), 0.25, true);
    } else {
        // If currently punched out, ensure all intervals from the last effective punch time
        // to the end of the day are marked as 0 hours worked and complete (false).
        fillIntervals(updatedIntervals, lastEffectivePunchTime, new Date(`${dateStr}T23:59:59`), 0, false);
    }

    return updatedIntervals;
}

// --- Example Usage and Test Cases ---

// Define the date for the intervals
const activityDate = '2025-07-29';

// Initialize the base 15-minute intervals for the day
const baseIntervals = initializeIntervals(activityDate);

// Helper function to print relevant intervals for testing
function printResults(title, results) {
    console.log(`\n--- ${title} ---`);
    const relevantIntervals = results.filter(i => i.hours_worked > 0 || i.incomplete);
    if (relevantIntervals.length === 0) {
        console.log("No hours worked or incomplete intervals.");
    } else {
        relevantIntervals.forEach(i => {
            console.log(
                `${i.start_time_local.toLocaleTimeString('en-US', { hour: '2-digit', minute: '2-digit', hour12: true })} ` +
                `- HW: ${i.hours_worked}, Inc: ${i.incomplete}`
            );
        });
    }
}

// Test Case 1: Incoming punch 'in' (without 'out')
// Expected: Intervals from 8:00 AM onwards are 0.25 hours, incomplete: True
let incomingPunches1 = [{ in: '8:00 AM' }];
let currentTime1 = '10:00'; // Current time is 10:00 AM
let result1 = processPunchData(incomingPunches1, baseIntervals, currentTime1);
printResults("Test Case 1: In (without Out)", result1);

// Test Case 2: Incoming punches 'in', 'out'
// Expected: Intervals from 8:00 AM to 11:45 AM are 0.25 hours, incomplete: False.
// Intervals from 12:00 PM onwards are 0 hours, incomplete: False.
let incomingPunches2 = [{ in: '8:00 AM' }, { out: '12:00 PM' }];
let currentTime2 = '13:00'; // Current time is 1:00 PM
let result2 = processPunchData(incomingPunches2, baseIntervals, currentTime2);
printResults("Test Case 2: In, Out", result2);

// Test Case 3: Incoming punch 'out' (without prior 'in')
// Expected: Intervals from 00:00 to 11:45 AM are 0.25 hours, incomplete: True.
// Intervals from 12:00 PM onwards are 0 hours, incomplete: False.
let incomingPunches3 = [{ out: '12:00 PM' }];
let currentTime3 = '14:00'; // Current time is 2:00 PM
let result3 = processPunchData(incomingPunches3, baseIntervals, currentTime3);
printResults("Test Case 3: Out (alone)", result3);

// Test Case 4: Incoming punches 'in', 'out', 'out'
// Expected: 8:00 AM - 11:45 AM worked, complete.
// 12:00 PM - 3:45 PM worked, incomplete (due to the second 'out' acting as an 'in' for the prior period).
// 4:00 PM onwards 0 hours, complete.
let incomingPunches4 = [{ in: '8:00 AM' }, { out: '12:00 PM' }, { out: '04:00 PM' }];
let currentTime4 = '17:00'; // Current time is 5:00 PM
let result4 = processPunchData(incomingPunches4, baseIntervals, currentTime4);
printResults("Test Case 4: In, Out, Out", result4);

// Test Case 5: Incoming punches 'in', 'in', 'out'
// Expected: 8:00 AM - 11:45 AM worked, complete (first 'in' closed by second 'in').
// 12:00 PM - 3:45 PM worked, complete.
// 4:00 PM onwards 0 hours, complete.
let incomingPunches5 = [{ in: '8:00 AM' }, { in: '12:00 PM' }, { out: '04:00 PM' }];
let currentTime5 = '17:00'; // Current time is 5:00 PM
let result5 = processPunchData(incomingPunches5, baseIntervals, currentTime5);
printResults("Test Case 5: In, In, Out", result5);

// Test Case 6: Incoming punches 'in', 'out', 'in', 'in' (second 'in' at same time)
// Expected: 8:00 AM - 11:45 AM worked, complete.
// 12:00 PM onwards 0 hours, complete (due to 'out' at 12:00 PM).
// Then from 12:30 PM onwards, worked, incomplete (due to the last 'in' at 12:30 PM).
let incomingPunches6 = [{ in: '8:00 AM' }, { out: '12:00 PM' }, { in: '12:30 PM' }, { in: '12:30 PM' }];
let currentTime6 = '14:00'; // Current time is 2:00 PM
let result6 = processPunchData(incomingPunches6, baseIntervals, currentTime6);
printResults("Test Case 6: In, Out, In, In", result6);

module.exports = { initializeIntervals, fillIntervals, processPunchData };