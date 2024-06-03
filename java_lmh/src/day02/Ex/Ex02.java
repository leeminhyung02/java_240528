package day02.Ex;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		// Scanner 클래스를 이용하여 2자리의 정수(10~99)를 입력받고, 
		//십의 자리와 1의 자리가 같은지 판별하여 출력하는 프로그램을 작성하라.
		Scanner scan = new Scanner(System.in);
		System.out.print("2자리 정수를 입력하세요 : ");
		int num = scan.nextInt();
		String str = (num/10 == num%10) ? "같다":"다르다";
		System.out.println(num+"은 십의 자리와 1의 자리가"+ str);
	}

}
