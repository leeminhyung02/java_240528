package day03;

import java.util.Scanner;

public class IfExam06 {
	public static void main(String[] args) {
		//성적을 입력받아 성적에 맞는학접을 출력
		Scanner scan = new Scanner(System.in);
		System.out.print("성적을 입력하세요 : ");
		int score = scan.nextInt();
		if (score <=100 && score >=90) {
			System.out.print(score+"점은 A입니다.");
		}
		else if (score <90 &&score >=80) {
			System.out.print(score+"점은 B입니다.");
		}
		else if (score <80 &&score >=70) {
			System.out.print(score+"점은 C입니다.");
		}
		else if (score <70 &&score >=60) {
			System.out.print(score+"점은 D입니다.");
		}
		else if (score <60) {
			System.out.print(score+"점은 F입니다.");
		}		
		else {
			System.out.println("잘못된 성적 입력 입니다.");
		}
	}
}
