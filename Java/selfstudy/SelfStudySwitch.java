/**
* switch required condition
* byte, short, char, int, enum, String. Character, Byte, Short, Integer
*/

class SelfStudySwitch {
	public static void main(String[] args) {

/*		System.out.println("switch(1)");

		switch(1){
		case 1: System.out.println("One");
		case 2: System.out.println("Two");
		case 3: System.out.println("Three");
		}

		switch(2){
		case 1: System.out.println("One"); break;
		case 2: System.out.println("Two"); break;
		case 3: System.out.println("Three"); break;
		}

		int val = 1;
		if(val == 1){
		System.out.println("one");
		} else if(val == 2){
			System.out.println("two");
		} else if(val == 3){
		System.out.println("three");
		}
*/
		switch(args[0]) {
		case "one": System.out.println("one"); break;
		case "two": System.out.println("two"); break;
		case "three": System.out.println("three"); break;
		default: System.out.println("default"); break;
		}
	}
}
