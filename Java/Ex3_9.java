package ch03;

public class Ex3_9 {

	public static void main(String[] args) {

		char ch = 'a';
		boolean b = ((65 <= ch && 90 >= ch)||(97 <= ch && 122 >= ch) ||(48 <= ch && 57 >= ch)
				? true : false);
		boolean c = (('A' <= ch && 'Z' >= ch)||('a' <= ch && 122 >= 'z') ||('0' <= ch && '9' >= ch)
				? true : false);	// ���ڴ� �񱳿����� �����ؼ� ASCII�� �ٲ㼭 �� �ʿ䰡 ����
		System.out.println(b);
		System.out.println(c);
		
	}

}
