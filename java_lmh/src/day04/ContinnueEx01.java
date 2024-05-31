package day04;

public class ContinnueEx01 {

	public static void main(String[] args) {
		// TODO 1~10짝수 출력 예제
		int i = 0;
		while ( i < 10) {
			i++;
			if (i % 2 != 0) {
				continue; //while문 에서는 조건식으로 건너 뜀
			}
			System.out.println(i);
		}

	}

}
