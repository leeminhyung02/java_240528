package day04;

public class WhileEx07 {

	public static void main(String[] args) {
		// 4가 소수인지 아닌지 판별하는 코드를 작성
		int i = 1;
		int count = 0;
		int num = 31;
		
		while ( i <=num ) {
			if (num % i == 0) {
				count++;
			}
			i++;
		}
		if (count == 2) {
			System.out.println(num+ "(은)는 소수 입니다.");
		}
		else {
			System.out.println(num+ "(은)는 소수가 아닙니다.");
		}
	}

}
