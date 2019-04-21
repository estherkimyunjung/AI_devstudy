package ch03;

public class Ex3_7 {

	public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = (int)((5/9f * (fahrenheit - 32)) * 100 + 0.5) / 100f;
		// 자릿수와 반올림을 같이 하기 위해서 int형으로 변환해서 계산한뒤 다시 float타입으로 되돌려줌
		System.out.println("Fahrenheit" + fahrenheit);
		System.out.println("Celcius" + celcius);
	}

}
