/** 
* Why use a variable?
* 1) deduplication, 
* 2) easy maintain, 
* 3) readability increase
*/


class SelfStudyVariableEx {
	public static void main(String[] args) {
		System.out.println(100 + 10);
		System.out.println((100 + 10) / 10);
		System.out.println(((100 + 10) / 10) - 10);
		System.out.println((((100 + 10) / 10) - 10) * 10);

		int a = 100;						// assigment & increment statement
											
		System.out.println(a + 10);
		System.out.println((a + 10) / 10);
		System.out.println(((a + 10) / 10) - 10);
		System.out.println((((a + 10) / 10) - 10) * 10);
	}
}
