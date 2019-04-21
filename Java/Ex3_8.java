package ch03;

public class Ex3_8 {

	public static void main(String[] args) {
		
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a + b);
		char ch = 'A';
		ch = (char)(ch + 2);
		float f = 3 / 2f;
		long l = 3000L * 3000 * 3000;
		float f2 = 0.1f;
		double d = 0.1;
		boolean result = (float)d==f2; //double를 같은 자료형인 float를 써서 같은 값을 뽑아낸다
		// 실수 형일 경우는 형변환할때 근사값으로 바뀌면서 data가 변형 될수 있다 그래서 유효숫자가 적은것으로 
		//형변환하는 것이 유리하다. 물론 리터럴 값에 따라 달라질수 있을 것 같다
		
		System.out.println("c="+c);
		System.out.println("ch="+ch);
		System.out.println("f="+f);
		System.out.println("l="+l);
		System.out.println("result="+result);

	}

}
