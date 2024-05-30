package day03;

import java.util.Scanner;

public class IfExam04 {

	public static void main(String[] args) {
		// 정수를 입력 받아 3의 배수인지 아닌지 판별하는 코드 만들기
		//    %3
			Scanner scan = new Scanner(System.in);
			System.out.print("정수를 입력 : ");
			int num = scan.nextInt();
			if( num%3 == 0 ) {
				System.out.println(num+"은(는)  3의 배수입니다.");
			}
			else {
				System.out.println(num+"은(는) 3의 배수가 아닙니다.");
			}
	}

}
