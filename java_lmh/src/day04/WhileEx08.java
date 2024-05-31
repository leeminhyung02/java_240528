package day04;

public class WhileEx08 {

	public static void main(String[] args) {
		// 두 정수 8과 12의 최대 공약수를 구하는 코드 
		int num1 = 8;
		int num2 = 12;
		int i = 1;
		int gcd= 1;
		while (i <= num1) {
			if (num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
			i++;
		}
		System.out.println(num1+"과 "+num2+"의 최대 공약수는 "+gcd +"입니다.");
	}
}
