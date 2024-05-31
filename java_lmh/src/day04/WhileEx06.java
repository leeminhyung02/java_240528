package day04;

public class WhileEx06 {

	public static void main(String[] args) {
		// 12의 약수를 출력하는 코드를 작성
		int num = 255;
		int i = 1;
		System.out.print(num + "의 약수 : ");
		while (i <=num) {
			if (num % i == 0) {
				System.out.print(i);				//i + (i != num ? " , " : " "));
				if (i != num) {
					System.out.print(", ");
				}
			}
			i++;
		}
	}

}
