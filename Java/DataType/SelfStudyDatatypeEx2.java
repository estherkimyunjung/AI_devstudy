class SelfStudyDatatypeEx2 {
	public static void main(String[] args) {
//		int a = 2.2;   error: datatype is mismatched. int express integer but 2.2 is real number
//		float a = 2.2; error: datatype is mismatched. 2.2 is double datatype
		float a = 2.2f;		// 2.2 converted to float datatype
		double b = 2.2;		// real number is double datatype

		System.out.println(a + "\n" + b);

//		long c = 2147483648;	error: datatype is mismatched. Defult datatype is int
		long c = 2147483648l;	// default int datatype converted to long datatype
		byte d = 100;			//byte and short allow use int datatype value
		short e = 200;

		System.out.println(c + "\n" + d + " " + e);

	}
}
