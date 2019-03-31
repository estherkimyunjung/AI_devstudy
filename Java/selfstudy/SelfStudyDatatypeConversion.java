/**
* Implicit conversion & Explicit conversion
*
* byte -> short,char -> int -> long -> float -> double
*/

class SelfStudyDatatypeConversion {
	public static void main(String[] args) {

		double a = 3.0f;		// implicit conversion : If assigment is bigger than value than the value will auto convert

		System.out.println(a);

		int b = 3;
		float c = 1.0f;
		double d = b + c;		//3.0f + 1.0f = 4.0f (int datype(A) converted to float and float(4.0f) datatype converted to double datatype)

		System.out.println(d);

//		float e = 100.0;		error: datatype is mimatched. A real number default datatype is double
//      int g = 100.0f;		error: incompatible type: possible lossy conversion from float to int
		float e = (float)100.0;
		int g = (int)100.0f;	// loss below the decimal data 
		System.out.println (e + "\t" + g);
	}
}
