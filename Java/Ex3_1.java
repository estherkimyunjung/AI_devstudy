package ch03; 

public class Ex3_1 { //ch03 package안에 모든 접근이 가능한 public 접근제한형식의 Ex3_1 class를 만듦   

	public static void main(String[] args) //변수타입이 문자배열인 변수 args를 사용하는 접근제한 방식이 public이고 
	// stack에 변수의 리터럴을 저장해서 리턴값을 전달할수 있는  main 메소드를 생성 
	{
		
		int x = 2;	// 기본형인 정수형 변수 x에 리터럴을 2를 대입해준다.
		int y = 5;	// 기본형인 정수형 변수 y에 리터럴을 5를 대입해준다.
		char c = 'A'; // 'A'의 문자코드는 65	 	// 변수의 기본 타입 문자형 변수 c에 문자A를 대입
		
		System.out.println(1 + x << 33);	// 우선순위 연산자가 +가 먼저 이기 때문에 1+2가 먼저 계산되고 그것을 shift operator가 33칸을 
											// 왼쪽으로 이동 시키는데 int type은 32bite이기 때문에 한바뀌를 돌아 한칸만 왼쪽으로 shift 하면 된다.
											// 그래서 결과값은 3이 6으로 바뀌게 된다
		System.out.println(y >= 5 || x < 0 && x > 2);	// 먼저 논리형 연산자 보다 비교 연산자가 우선순위를 갖는다. 그래서 비교 연산의 결과 값을 먼저 내고
														// 다음은 논리형 연산자의 우선순위인 && 그다음은 ||을 계산하면 된다.
														// true|| false && false -> true || false 그래서 true가 된다
		System.out.println(y += 10 - x++);	//	y=y+10  y=5+10이여서 y=15 그리고 x는 값을 주고 이 라인을 실행하고 난후 후증가를 한다
											// 그래서 현재는 x = 2 그래서 결과 값은 15-2=13 13이 된다
		System.out.println(x+=2);	// 우에서 후 증가한  x = 3에 x = x(3)+2를 하면 5가 된다
		System.out.println( !('A' <= c && c <='Z') );	//  ASCII값으로 비교연산을 하게 되는데 A = 65 c='A'(65) Z=90
														// !(65 <= 65 && 65 <= 90) -> !(true && true) -> ! true -> false가 된다
		System.out.println('C'-c);		// 역시 연산이라 ASCII값으로 계산 C=67 67-65 = 2
		System.out.println('5'-'0');	// 문자 5 - 문자 0 -> 53-48 = 5
		System.out.println(c+1);	// 문자에 정수를 더하기 때문에 ASCII로 65 + 1 -> 66
		System.out.println(++c);	//이항연산자기 때문에 형변환이 없다 그래서 선증가한 문자 'A'를 하면 B 출력
		System.out.println(c++);	//위에서 증가된 B를 출력하고 후증가
		System.out.println(c);	//위에서 증가된 리터럴이 넘어와서 C출력
		
	}

}
