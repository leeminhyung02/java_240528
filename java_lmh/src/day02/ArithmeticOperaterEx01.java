package day02;

public class ArithmeticOperaterEx01 {

	public static void main(String[] args) {
		//산술 연산자 예제
		int num1 = 5, num2 = 3;
		System.out.println("" + num1 + '+' + num2 + '='+ (num1+num2));
		System.out.println("" + num1 + '-' + num2 + '='+ (num1-num2));
		System.out.println("" + num1 + '*' + num2 + '='+ (num1*num2));
		System.out.println("" + num1 + '/' + num2 + '='+ (num1/num2));   //형변환X
		System.out.println("" + num1 + '/' + num2 + '='+ (num1/(double)num2));  //형변환O
		System.out.println("" + num1 + '%' + num2 + '='+ (num1%num2));

	}

}
