package ch03;

public class EX3_3 {

	public static void main(String[] args) {

		int num = 10;
		System.out.println(num < 0 ? "음수" : (num == 0 ? "0" : "양수"));

		if (num == 0) 
		{
			System.out.println("0");

		} else {
			if(num < 0) {
				System.out.println("음수");
			} else {	
				System.out.println("양수");
			}
		}

		if (num == 0) 
		{
			System.out.println("0");

		} else if(num < 0) {

			System.out.println("음수");
		} else {	
			System.out.println("양수");
		}


	}

}
