/** Data type
* integer: 
	** 1byte(8bite)
	** short - 2byte
	** int - 4byte
	** long - 8byte
* real number
	** float - 4bite
	** double - 8byte
* character & String
	** char - 2byte
	** string - 12byte
*/

class SelfStudyDatatypeEx1 {
	public static void main(String[] args) {
		
		byte a, b;
		a = 127; 
//		b = 128;	error: incompatible type byte only express between -128 to 127 (1byte)
		short c = 128;					// (short c; c = 128;) short(2byte) express between -32,768 to 32,767
		int d = 32768;					// int(4byte), long(8byte)
		
		System.out.println(a);
		System.out.println(c);
		System.out.println(d);
	}
}
