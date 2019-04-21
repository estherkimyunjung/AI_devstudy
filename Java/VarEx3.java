
public class VarEx3
{
	public static void main(String[]args) 
	{
		
		final int score = 100;
//		score = 200;
		boolean power = false;
		byte a = 127;
		int hex = 0x10;
		int oct = 010;
		
		float f = 3.14f;
		double d = 3.14f;
		
		long l = 10_000_000_000L;
		
		String str = "";
		String str2 = "ABCD";
		String str3 = "123";
		String str4 = str2 + str3;
		String str5 = "a" + 7 + 7;
		String str6 = 7 + 7 + "a";

		System.out.println(oct);
		System.out.println(hex);
		System.out.println(score);
		System.out.println(str4);
		System.out.println(l);
		
	}

}
