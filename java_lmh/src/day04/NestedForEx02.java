package day04;

public class NestedForEx02 {

	public static void main(String[] args) {
		// num가 소수인지 아닌지 판별하는 코드를 이용하여 100이하의 소수 출력
		int num;
		int count2 = 1;
		for (num = 1; num <=  100; num++) {
			int i,count = 0;
			for (i = 1; i <= num; i++) {
				if(num % i == 0) {
					count ++;
				}
			}
			if( count == 2) {
				System.out.print(num + "    ");
				if (count2 == 5) {
					System.out.println(" ");
					count2 = 0;
				}
				count2++;
			}
			else {
			}
		}


	}

}
