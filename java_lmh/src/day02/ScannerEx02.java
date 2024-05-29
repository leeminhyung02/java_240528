package day02;

import java.util.Scanner;

public class ScannerEx02 {

	public static void main(String[] args) {
		// 두 정수와 연산자를 입력받고, 입력받은 결과를 콘솔에 출력
		/*
		 *			정수1을 입력하세요 : 1 
		 *			정수2를 입력하세요 :2
		 *			연산자를 입력하세요 : +
		 *			입력 결과 : 1 + 2
		 */
		int num1, num2;
		char ch1;
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 정수를 입력하세요 : ");
		num1 = scan.nextInt();
		System.out.print("두번째 정수를 입력하세요 : ");
		num2 = scan.nextInt();
		System.out.print("연산자를 입력하세요 : ");
		ch1 = scan.next().charAt(0);
		System.out.println("입력 결과 : " + num1 + ch1 + num2);
	}

}
