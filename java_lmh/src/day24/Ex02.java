package day24;

public class Ex02 {

	public static void main(String[] args) {
		
		int num1 = 1, num2 = 2;
		
		double res = num1/num2;
		/*1/2 = 0.5가 출력되지 않음
		 * 원인 : num1/num2에서 나눠졌을때 정수형이라 소수점이 없어짐
		 * 해결 방법 : num1이나 num2앞에 (double)
		 * 
		 */
		res = (double)num1/num2;
		System.out.println(num1+" / "+ num2 + " = " + res);

	}

}
