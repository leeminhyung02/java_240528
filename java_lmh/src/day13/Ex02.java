package day13;

import java.text.MessageFormat;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/*
		 *  두 정수와 산술 연산자를 입력받아 산술연산 결과를 알려주는 메소드를 정의 및 구현하고
		 *  main 메소드에서 실행하는 코드를 작성하세요.
		 *  단, 예외 발생 시 예외 처리하는 코드를 추가하세요.
		 */
		
		int num1 = 1, num2 = 2;
		char op = '=';
		try {
			double res = calculate(num1, op, num2);
			String format = "{0} {1} {2} = {3}";
			System.out.println(MessageFormat.format(format, num1,op,num2,res));
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 *  두 정수와 산술 연산자가 주어지면 산술 연산 결과를 알려주는 메소드
	 *  @param num1
	 *  @param operator
	 *  @param num2
	 *  @return 산술 연산 결과 
	 *  @throws ArithmeticException 0으로 나눌수 없다.
	 *  @throws IllegalArgumentException 잘못된 연산자
	 */
	public static void name(int num1, String op, int num2) {
		switch (op) {
		case "+": {
			System.out.println(""+num1+op+num2 +" = "+(num1+num2));
			break;
		}
		case "-":{
			System.out.println(""+num1+op+num2 +" = "+(num1-num2));
			break;
		}
		case "*":{
			System.out.println(""+num1+op+num2 +" = "+(num1*num2));
			break;
		}
		case "/":{
			try {
				System.out.println(""+num1+op+num2 +" = "+(num1/num2));
				
			}catch (ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
			}
			break;
		}
		case "%":{
			try {
				System.out.println(""+num1+op+num2 +" = "+(num1%num2));
				
			}catch (ArithmeticException e) {
				System.out.println("0으로 나눌 수 없습니다.");
			}
			break;
		}
		default:
			System.out.println("잘못 입력하셨습니다.");
		}
	}
	public static double calculate(int num1, char op, int num2) {
		double res;
		switch (op) {
		case '+': {
			res = num1 + num2;
			break;
		}
		case '-': {
			res = num1 - num2;
			break;
		}
		case '*': {
			res = num1 * num2;
			break;
		}
		case '/': {
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			res = num1 / (double)num2;
			break;
		}
		case '%': {
			if(num2 == 0) {
				throw new ArithmeticException("0으로 나눌 수 없습니다.");
			}
			res = num1 % (double)num2; 
			break;
		}
		default:
			throw new IllegalArgumentException("잘못된 연산자 :" + op);
		}
		
		return res;
	}
}
