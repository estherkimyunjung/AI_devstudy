package ch03;

public class ConvertBit {

	public static void main(String[] args) {
		
		int i = 10;
		
		System.out.println("i = " + i);
		System.out.println("~i = " + ~i);
		
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(~i));
		
		System.out.println(1/3);
		System.out.println((double)1/3);
		
		System.out.println(3%2);
		System.out.println(3.5%2.1);
		
		System.out.println('a' < 'b');
		//System.out.println("a" < 'b');

	}

}
