/**
*	++	Increment:	Increases the value of a variable by 1	(++i, i++)
*	--	Decrement:	Decreases the value of a variable by 1	(--x, x--)
*/

class SelfStudyInfixOperator {
	public static void main(String[] args){
		int i = 3;
		i++;	// i = i + 1					
		System.out.println(i);
		++i;
		System.out.println(i);
		System.out.println(++i);
		System.out.println(i++);
		System.out.println(i);

		System.out.println();

		int j = 10;
		j--;	// i = i - 1					
		System.out.println(j);
		--j;
		System.out.println(j);
		System.out.println(--j);
		System.out.println(j--);
		System.out.println(j);

	}
}
