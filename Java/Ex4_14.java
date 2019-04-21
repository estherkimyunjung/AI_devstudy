package ch04;

public class Ex4_14 
{

	public static void main(String[] args)
	{
		int answer = (int)(Math.random() * 100) + 1;
		int input = 0;
		int count = 0;
		
		java.util.Scanner s = new java.util.Scanner(System.in);
		do {
			
			count++;
			System.out.println("1과 100 사이의 값을 입력하세요 :");
			input = s.nextInt();
			
			if(answer > input) {
				System.out.println("더 큰 수를 입력하세요.");
			} else if(answer < input){
				System.out.println(" 작은 수를 입력하세요.");
			} else {
				System.out.println("맞췄습니다.");
				System.out.println("시도횟수는 "+count+"번입니다.");
				break; // do-while문을 벗어난다
			}
			
		} while(true);
		
		

	}

}

