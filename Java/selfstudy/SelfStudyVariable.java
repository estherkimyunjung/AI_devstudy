class SelfStudyVariable {
	public static void main(String[] args) {
		int a;									// integer variable's name(a) declaration
		a = 1;									// variable a's value is 1 
		System.out.println(a + 1);				// print of var a add 1 (result is 2)

		a = 5;									// variable a's value changed to 5
		System.out.println(a + 1);				// print of var a add 1	(result is 6)

//		a = 1.1;								// error: because data type not matched
												// (a is int type but value is double type)
//		System.out.println(a + 1.1);

		double b = 0;							// variable's name(b) declaration and data type is double
		b = 1.1;								
		System.out.println(b + 1.1);

		String c, d;							// variable's name(c,d) declaration and data type is string
		c = "JAVA coding";
		d = "by Esther";
		System.out.println(c +" "+ d);
	}
}
