package ch03;

public class Ex3_7 {

	public static void main(String[] args) {
		int fahrenheit = 100;
		float celcius = (int)((5/9f * (fahrenheit - 32)) * 100 + 0.5) / 100f;
		// �ڸ����� �ݿø��� ���� �ϱ� ���ؼ� int������ ��ȯ�ؼ� ����ѵ� �ٽ� floatŸ������ �ǵ�����
		System.out.println("Fahrenheit" + fahrenheit);
		System.out.println("Celcius" + celcius);
	}

}
