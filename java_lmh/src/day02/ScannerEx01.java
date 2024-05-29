package day02;

import java.util.Scanner;

public class ScannerEx01 {

	public static void main(String[] args) {
		// 콘솔창에서 원하는 값을 읽어와서 변수에 저장하는 예제
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num= scan.nextInt();
		System.out.println(num);
		
		System.out.print("실수를 입력하세요 : ");
		double num2 = scan.nextDouble();
		System.out.println(num2);
		
		System.out.print("문자열(단어)를 입력하세요 : ");
		String str1  = scan.next();
		System.out.println(str1);
		scan.nextLine();
		System.out.print("문자열(문장)을 입력하세요 :");
		String str2 = scan.nextLine();
		System.out.println(str2);
		
		System.out.println("문자를 입력하세요: ");
		char ch = scan.next().charAt(0);
		System.out.println(ch);	
	}
}
