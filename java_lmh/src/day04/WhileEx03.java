package day04;

public class WhileEx03 {

	public static void main(String[] args) {
		// 구구단 2단을 출력하는 코드를 작서앟세요
		int i  = 1;
		int num = 20;
		while(i <= 9) {
			int res = num * i;
			System.out.println( num +" X " + i + " = " + res);
			i++;
		}
	}
}
