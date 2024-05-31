package day04;

import java.util.Scanner;

public class ForEx03 {

	public static void main(String[] args) {
		// 문자를 입력받고 입력받은 문자가y이면 종료
		Scanner scan = new Scanner(System.in);
		char c;
		for (c = ' '; c !='y'; c = scan.next().charAt(0)) {
			System.out.print("문자 입력 :");
		}
	}

}
