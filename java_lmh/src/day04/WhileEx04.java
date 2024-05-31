package day04;

public class WhileEx04 {

	public static void main(String[] args) {
		// 1부터 10까지 합을 구하기
		int i = 1;
		int max = 10;
		int sum = 0;
		System.out.print( i + "부터 " + max + "까지의 합은 ");
		while(i <= max) {
			sum += i;
			i++;
		}
		System.out.println( sum + "입니다.");
	}

}
