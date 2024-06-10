package day09;

public class MethodOverloadingEx01 {
	/*메소드 오버로딩 조건
	1. 매개변수의 개수가 다름
	2. 매개변수의 타입이 다름
	*/
	public static void main(String[] args) {
		
	}
	//메소드 오버로딩 예제
	public static int sum(int num1, int num2) {
		return num1 + num2;	
		
	}
	//double sum(double num1, double num2) :o
	public static double sum(double num1, double num2) {
		return num1 + num2;
	}
	//double  sum(int num1, int num2) : x
	
	//int sum(int num1, int num2, int num3) :o
	public static int sum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	//int sum(int a, int b) :x
}
