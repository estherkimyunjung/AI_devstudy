package ch03;

public class EX3_3 {

	public static void main(String[] args) {

		int num = 10;
		System.out.println(num < 0 ? "����" : (num == 0 ? "0" : "���"));

		if (num == 0) 
		{
			System.out.println("0");

		} else {
			if(num < 0) {
				System.out.println("����");
			} else {	
				System.out.println("���");
			}
		}

		if (num == 0) 
		{
			System.out.println("0");

		} else if(num < 0) {

			System.out.println("����");
		} else {	
			System.out.println("���");
		}


	}

}
