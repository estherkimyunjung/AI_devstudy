package ch03;

public class Ex3_10 {

	public static void main(String[] args) {
		char ch = 'A';
//		char lowerCase = (char) (( 65 <= ch && 90 >= ch ) ? ( ch+32 ) : ch);
		char lowerCase = ( 'A' <= ch && 'Z' >= ch ) ? (char)( ch+32 ) : ch;
		
		System.out.println("ch:"+ch);
		System.out.println("ch to lowerCase:"+lowerCase);
	}

}
