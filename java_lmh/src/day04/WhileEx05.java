package day04;

public class WhileEx05 {

	public static void main(String[] args) {
		// 1부터 10까지 짝수 합을 구하기
		int i = 2;
		int max = 10;
		int sum = 0;
		System.out.print( i + "부터 " + max + "까지의 짝수 합은 ");
			/*while(i <= max) {
				if (i % 2 == 0) {
					sum += i;
				}
				i++;
			}*/
		//System.out.println( sum + "입니다.");
		
		while(i <= max) {
			sum += i;
			i += 2;
		}
		System.out.println( sum + "입니다.");
	}

}
