package day04;

import java.util.Scanner;

public class WhileEx10 {

	public static void main(String[] args) {
		//반복문을 이용하여 문자를 입력받고 입력받은 문자가 y이면 반복문을 종료
		Scanner scan = new Scanner(System.in);
		char c = 'a';
		while (c != 'y') {
			System.out.print("문자 입력 :");
			c = scan.next().charAt(0);
			}
		}
	}
