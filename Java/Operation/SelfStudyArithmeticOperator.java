class SelfStudyArithmeticOperator {
	public static void main(String[] args) {
		
		int result = 3;

		System.out.println(result + 2);				//add integer
		System.out.println(result - 1);				//subtraction
		System.out.println(result + 1.3);			//add real number
		System.out.println(result * 5);				//multiplication
		System.out.println(result / 2);				//division
		System.out.println(result % 2);				//remainder

		int a = 10;
		int b = 3;

		float c = 10.0f;
		float d = 3.0f;

		System.out.println(a / b);
		System.out.println(c / d);
		System.out.println(a / d);			// implicit conversion

		System.out.println();				

		int i = 0;
		System.out.println(i % result);				// A cycle created by remainder
		System.out.println(i+1 % result);
		System.out.println(i+2 % result);
		System.out.println(i+3 % result);
		System.out.println(i+4 % result);
		System.out.println(i+5 % result);
		System.out.println(i+6 % result);


	}
}
