package day04;

public class WhileEx08_1 {

	public static void main(String[] args) {
		// 두 정수 8과 12의 최대 공약수를 구하는 코드 
		int num1 = 8, num2 = 12;
		int i = 1, j = 1;
		int n1 = 0, n2 = 0;
		int max=0;
		System.out.print(num1 +"과 "+num2+"의 최대 공약수 :");
		while (j <= num2) {
			if(num2 % j == 0 && num2 != j) {
				n2 = j;
			}
			j++;
			while (i <= num1) {
				if (num1 % i == 0 && num1 != i) {
					n1 = i;
				}
				i++;
			}
			if (n1 == n2) {
				max = n1;
			}
		}
		System.out.println(max);
		
	}

}
