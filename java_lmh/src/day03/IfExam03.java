package day03;

import java.util.Scanner;

public class IfExam03 {
	public static void main(String[] args) {
	//산술 연산자와 두 정수를 입력받아 산술연산자에 맞는 연산 결과를 출력하는 코드를 작성하세요 
	Scanner scan = new Scanner(System.in);
	System.out.print("두 정수와 산술 연산자를 입력하세요  : " );
	int num1 = scan.nextInt();
	char op = scan.next().charAt(0);
	int num2 = scan.nextInt();
	
	if (op == '+') {
		System.out.println(""+num1+op+num2 + "="+ (num1+num2));
	}
	else if (op == '-') {
		System.out.println(""+num1+op+num2 + "="+ (num1-num2));
	}
	else if (op == '*') {
		System.out.println(""+num1+op+num2 + "="+ (num1*num2));
	}
	else if (op == '/') {
		System.out.println(""+num1+op+num2 + "="+ (num1/num2));
	}
	else {
		System.out.println("잘못된 입력");
	}
	}
}
