package day02_Ex;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		//원화를 입력받아 달러로 바꾸어 출력하는 프로그램
		//1달러 = 1366원
		double krw, usd;
		Scanner scan = new Scanner(System.in);
		System.out.print("원화를 입력하세요 : ");
		krw = scan.nextDouble();
		System.out.print(krw+"원은 ");
		System.out.printf("%.2f", krw/1366);
		System.out.println("달러 입니다.");
	}

}
