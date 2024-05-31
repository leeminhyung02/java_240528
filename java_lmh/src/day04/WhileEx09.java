package day04;

public class WhileEx09 {

	public static void main(String[] args) {
		//a부터 z가지 출력하는 코드를 작성하세요.
		char ch = 'a';
		int i = 0;
		int num = 26;
		while ( i <num) {
			char Ch = (char)(ch + i);
			System.out.print(Ch+ " ");
			i++;
			/*
			 * int i = 0;
			 * while (i <= 25) {
			 * 	System.out.print((char)('a' + i));
			 * 	i++;
			 * }
			 * ----------------------
			 * char ch = 'a';
			 * while (ch <= 'z') {
			 * 	System.out.println(ch);
			 * 	ch++;
			 * }
			 */
		}
	}
}