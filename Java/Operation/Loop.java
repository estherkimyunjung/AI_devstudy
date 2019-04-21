package ch04;

import java.util.Scanner;

public class Loop {

	public static void main(String[] args) {
		
		
		/*
//		국어, 영어, 수학 등 3과목의 점수(0~100 사이의 정수)를 입력 받아, 국어, 영어, 수학 등을 출력하라.
		Scanner keyboard = new Scanner(System.in);
		
		int kor = 0, eng = 0, mat = 0;
		
		System.out.print("kor : ");
		kor = keyboard.nextInt();
		
		System.out.print("eng : ");
		eng = keyboard.nextInt();
		
		System.out.print("mat : ");
		mat = keyboard.nextInt();
		
		System.out.printf("국어\t영어\t수학\n");
		System.out.println(kor + "\t" + eng + "\t" + mat);
*/
		
		/*
//		국어, 영어, 수학 등 3과목의 점수(0~100 사이의 정수)를 입력 받아, 국어, 영어, 수학 등을 출력하라.
//		다만, 3명에 대해 동일하게 수행하라.
		Scanner keyboard = new Scanner(System.in);
		
		int kor1 = 0, eng1 = 0, mat1 = 0;
		int kor2 = 0, eng2 = 0, mat2 = 0;
		int kor3 = 0, eng3 = 0, mat3 = 0;
		
		System.out.print("kor : ");
		kor1 = keyboard.nextInt();
		
		System.out.print("eng : ");
		eng1 = keyboard.nextInt();
		
		System.out.print("mat : ");
		mat1 = keyboard.nextInt();
	                               
		System.out.print("kor : ");
		kor2 = keyboard.nextInt();     
		
		System.out.print("eng : ");
		eng2 = keyboard.nextInt();
		
		System.out.print("mat : ");
		mat2 = keyboard.nextInt();
		
		System.out.print("kor : ");
		kor3 = keyboard.nextInt();
		
		System.out.print("eng : ");
		eng3 = keyboard.nextInt();
		
		System.out.print("mat : ");
		mat3 = keyboard.nextInt();
		
		System.out.printf("국어\t영어\t수학\n");
		System.out.println(kor1 + "\t" + eng1 + "\t" + mat1);
		System.out.println(kor2 + "\t" + eng2 + "\t" + mat2);
		System.out.println(kor3 + "\t" + eng3 + "\t" + mat3);
		
		*/
		/*
//		위와 같은 코드를 100명에게 적용한다면?
		Scanner keyboard = new Scanner(System.in);
		final int STDCNT = 5;
		int kors[] = new int[STDCNT], engs[] = new int[STDCNT], mats[] = new int[STDCNT];

		for(int i = 0; i < STDCNT; i++) {
			System.out.print("kor : ");
			kors[i] = keyboard.nextInt();
			
			System.out.print("eng : ");
			engs[i] = keyboard.nextInt();
			
			System.out.print("mat : ");
			mats[i] = keyboard.nextInt();
		}
	     
		System.out.printf("국어\t영어\t수학\n");
		for(int i = 0; i < STDCNT; i++) {
			System.out.println(kors[i] + "\t" + engs[i] + "\t" + mats[i]);
		}
		*/
		
		/*
		Scanner keyboard = new Scanner(System.in);
		final int STDCNT = 5;
		final String subjects[] = {"kor", "mat", "eng"};
		int scores[][] = new int[STDCNT][subjects.length];

		for(int i = 0; i < STDCNT; i++) {
			for(int j = 0; j < subjects.length; j++) {
				System.out.print(subjects[j]);
				scores[i][j] = keyboard.nextInt();
			}
		}
		System.out.println();
	     
		for(int i = 0; i < subjects.length; i++) {
			System.out.print(subjects[i] + "\t");
		}
		
		System.out.println();
		
		for(int i = 0; i < STDCNT; i++) {
			for(int j = 0; j < subjects.length; j++) {
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println();
		}	
		
		keyboard.close();
		
		*/		
		
		/*
//		국어, 영어, 수학 등 3과목의 점수(0~100 사이의 정수)를 입력 받아, 국어, 영어, 수학 , 총점, 평균 등을 출력하라.
//		다만, 5명에 대해 동일하게 수행하라.
		
		Scanner keyboard = new Scanner(System.in);
		final int STDCNT = 5;
		final int SUBCNT = 3;
		final String title[] = {"kor", "mat", "eng", "total", "average"};
		int scores[][] = new int[STDCNT][title.length - 1];
		double avgs[] = new double[STDCNT];
		
		for(int i = 0; i < STDCNT; i++) {
			int total = 0;
			int j = 0;
			for(; j < SUBCNT; j++) {
				System.out.print(title[j]);
				scores[i][j] = keyboard.nextInt();
				total = total + scores[i][j];
			}
			scores[i][j] = total;
			avgs[i] = (double)total / SUBCNT;
		}
		System.out.println();
		
		for(int i = 0; i < title.length; i++) {
			System.out.print(title[i] + "\t");
		}
		
		System.out.println();
		
		for(int i = 0; i < STDCNT; i++) {
			for(int j = 0; j < title.length - 1; j++) {
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println(avgs[i]);
			System.out.println();
		}	
		
		keyboard.close();
		*/
		
//		위의 코드는 과목 점수가 0~100 사이가 아니여도 연산이 되는 문제점이 있다.
		
		Scanner keyboard = new Scanner(System.in);
		final int STDCNT = 5;
		final int SUBCNT = 3;
		final String title[] = {"kor", "mat", "eng", "total", "average"};
		int scores[][] = new int[STDCNT][title.length - 1];
		double avgs[] = new double[STDCNT];
		
		for(int i = 0; i < STDCNT; i++) {
			int total = 0;
			int j = 0;
			for(; j < SUBCNT; j++) {
				System.out.print(title[j] + ": ");
				
				while(true) {
					int score = keyboard.nextInt();
					if(score >= 0 && score <= 100) {
						scores[i][j] = score;
						break;
					} else {
						System.out.println("다시 입력하세요.(유효값 : 0~100)");
					}
				}
				
				total = total + scores[i][j];
			}
			scores[i][j] = total;
			avgs[i] = (double)total / SUBCNT;
		}
		
		System.out.println();
		
		for(int i = 0; i < title.length; i++) {
			System.out.print(title[i] + "\t");
		}
		
		System.out.println();
		
		for(int i = 0; i < STDCNT; i++) {
			for(int j = 0; j < title.length - 1; j++) {
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println(avgs[i]);
			System.out.println();
		}	
		
		keyboard.close();
		
	}

}
