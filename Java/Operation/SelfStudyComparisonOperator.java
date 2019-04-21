/**
*
*Priority		Operator									combination direction
*	1			[ ]											¡æ
*				()
*				.
*	2			++											¡ç
*				--
*				+(positive number) -(negative number)
*				~
*				!
*				(type)
*				new
*	3			* / %										¡æ
*	4			+(add) -(subtraction)						¡æ
*				+(combine strings)
*	5			<<											¡æ
*				>>
*				>>>
*	6			< <=										¡æ
*				> >=
*				instanceof
*	7			==											¡æ
*				!=
*	8			&											¡æ
*	9			^											¡æ
*	10			|											¡æ
*	11			&&											¡æ
*	12			||											¡æ
*	13			? :											¡ç
*	14			=											¡ç
*				*= /= += -= %=
*				<<= >>= >>>=
*				&= ^= |=
*/

class SelfStudyComparisonOperator {
	public static void main(String[] args) {
	System.out.println(1 == 2);				// false
	System.out.println(1 == 1);				// true
	System.out.println("one" == "two");		// false (equal operator can compare strings)
	System.out.println("one" == "one");		// true
	System.out.println();

	
	System.out.println(1 != 2);				// true
	System.out.println(1 != 1);				// false
	System.out.println("one" != "two");		// true
	System.out.println("one" != "one");		// false
	System.out.println();

	System.out.println(10 > 20);			// false
	System.out.println(10 > 2);				// true
	System.out.println(10 > 10);			// false
	System.out.println();


	System.out.println(10 >= 20);			// false
	System.out.println(10 >= 2);			// true
	System.out.println(10 >= 10);			// true
	System.out.println();

	String a = "Hello Java";
	String b = new String("Hello Java");
	System.out.println(a == b);				// false (== operator can not use in string's comparison)
	System.out.println(a.equals(b));		// true (.equals operator use to string's comparison)
	System.out.println();
	}
}
