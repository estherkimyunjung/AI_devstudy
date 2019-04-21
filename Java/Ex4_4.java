package ch04;

public class Ex4_4 {

	public static void main(String[] args) {

		int total = 0;
		int i = 0;

//		while(total < 100) {
//			i++;
//			if(i % 2 == 0) {
//				total = total + (-i);
//				System.out.print("(-" + i +")+");
//			} else {
//				total = total + i;
//				System.out.print(i +"+");
//			}
//		}
//
//		System.out.println(i);
		
//		for(;total < 100;) {
//			i++;
//			if(i % 2 == 0) {
//				total = total + (-i);
//				System.out.print("(-" + i +")+");
//			} else {
//				total = total + i;
//				System.out.print(i +"+");
//			}
//		}
//
//		System.out.println(i);
		
		do {
			i++;
			if(i % 2 == 0) {
				total = total + (-i);
				System.out.print("(-" + i +")+");
			} else {
				total = total + i;
				System.out.print(i +"+");
			}
		} while(total < 100);

		System.out.println(i);
	}

}
