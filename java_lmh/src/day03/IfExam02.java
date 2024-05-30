package day03;

import java.util.Scanner;

public class IfExam02 {

	public static void main(String[] args) {
		//월을 입력받아 입력받은 월 의 계절을 출력
			Scanner scan = new Scanner(System.in);
			System.out.print("월을 입력 : ");
			int m  = scan.nextInt();
			if (m == 3|| m == 4 ||m == 5) {
				System.out.println("봄");
			}
			else if (m == 6|| m == 7 ||m == 8) {
				System.out.println("여름");
			}
			else if (m == 9|| m == 10 ||m == 11) {
				System.out.println("가을");
			}
			else if (m == 12|| m >=1 &&  m >= 2) {
				System.out.println("겨울");
			}
			else {
				System.out.println("잘못된 월 입력함");
			}
	}

}
