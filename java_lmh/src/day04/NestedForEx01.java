package day04;

public class NestedForEx01 {

	public static void main(String[] args) {
		//구구단 2~9단을 출력하는 코드를 작성
		for (int i = 2; i<=9; i++) {
			for (int j = 1; j<=9; j++) {
				System.out.print(i+" X "+ j + "= "+i*j+"   ");
				if (j == 9) {
					System.out.println(" ");
					System.out.println(" ");
				}
			}
		}
	}

}
