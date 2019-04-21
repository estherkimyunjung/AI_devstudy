package ch04;

import java.util.Scanner;

public class ScoreGrade {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		int score = keyboard.nextInt();
//		System.out.println(score);
		
		if(score >= 90) {
			System.out.println("A1");
		}
		
		if(score < 90 && score >= 80) {
			System.out.println("B1");
		}
		
		if(score < 80 && score >= 70) {
			System.out.println("C1");
		}
		
		if(score < 70 && score >= 60) {
			System.out.println("D1");
		}
		
		if(score < 70 && score >= 0) {
			System.out.println("F1");
		}
		
		if (score >= 90) {
			System.out.println("A2");
		} else {
			if (score >= 80) {
				System.out.println("B2");
			} else {
				if (score >= 70) {
					System.out.println("C2");
				} else {
					if (score >= 60) {
						System.out.println("D2");
					} else {
						System.out.println("F2");
					}
				}
			}
		}
		
		if (score >= 90) {
			System.out.println("A3");
		} else if(score >= 80) {
			System.out.println("B3");
		} else if(score >= 70) {
			System.out.println("C3");
		} else if(score >= 60) {
			System.out.println("D3");
		} else if(score >= 0) {
			System.out.println("F3");
		}
		
//		0~100 사이의 정수를 입력 받아
//		90 <= num <= 100 => "A"
//		80 <= num < 90 => "B"
//		70 <= num < 80 => "C"
//		60 <= num < 70 => "D"
//		0 <= num < 60 => "F"
//		만약, 0~100 사이의 정수가 아니면 입력이 잘못되었다는 메세지 출력
		
		if (score <=100 && score >= 90) {
			System.out.println("A3");
		} else if(score >= 80) {
			System.out.println("B3");
		} else if(score >= 70) {
			System.out.println("C3");
		} else if(score >= 60) {
			System.out.println("D3");
		} else if(score >= 0) {
			System.out.println("F3");
		} else {
			System.out.println("입력이 잘못됨.");
		}
	
		if (score < 0 || score > 100) {
			System.out.println("입력이 잘못됨.");
		} else if(score >= 90) {
			System.out.println("B3");
		} else if(score >= 80) {
			System.out.println("B3");
		} else if(score >= 70) {
			System.out.println("C3");
		} else if(score >= 60) {
			System.out.println("D3");
		} else {
			System.out.println("F3");
		}
		
		if (score < 0 || score > 100) {
			System.out.println("입력이 잘못됨.");
		} else { //0 ~ 100
			if(score >= 90) { // 90 <= score <= 100
				System.out.println("B3");
			} else if(score >= 80) {
				System.out.println("B3");
			} else if(score >= 70) {
				System.out.println("C3");
			} else if(score >= 60) {
				System.out.println("D3");
			} else {
				System.out.println("F3");
			}
		}
		
		
	}

}
