package day04;

public class BreakEx02 {

	public static void main(String[] args) {
		// 최대 공약수 예제를 break문을 이용해서 구현
		int num1 = 8, num2 = 12;
		int i = num1;

		while (i != 1) {
			if(num1 % i == 0 && num2 % i == 0) {
				System.out.print(num1+"과 "+num2+"의 최대 공약수 : "+i);
				break;
			}
			i--;
		}
	}
}
