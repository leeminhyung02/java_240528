package day03;

import java.util.Scanner;

public class IfExma05 {

	public static void main(String[] args) {
		// 정수를 입력받아 2,3,6의 배수인지 아닌지 판별하는 코드를 작성하세요

			Scanner scan = new Scanner(System.in);
			System.out.print("정수 입력 :");
			int num = scan.nextInt();
			if (num % 6 == 0) {
				System.out.println(num+"는 6의 배수 입니다.");
			}	
			else if (num % 3 == 0) {
				System.out.println(num+"는 3의 배수 입니다.");
			}
			else if (num % 2 == 0) {
				System.out.println(num+"는 2의 배수 입니다.");
			}
			else {
				System.out.println(num+"는 2 ,3 ,6 의 배수가 아닙니다.");
			}
	}

}
