package ch04;

public class Ex4_2 {
	
	public static void main(String[] args) {
		
		int last = 0;
		
		for (int i = 1; i < 21; i++) 
		{
			if (!((i%2 == 0) || (i%3 == 0))) 
			{
				last = i;
				
			}
		}

		int total = 0;
		
		for (int i = 1; i < 21; i++)
		{

			if (!((i%2 == 0) || (i%3 == 0))) 
			{
			
				total = total + i;
				if(i == last) 
				{
					System.out.print(i + "=");
				} else {
					
					System.out.print(i + "+" );
				}
				
			}
			
		} 
		
		System.out.println(total);

	}

}
