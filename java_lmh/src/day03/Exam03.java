package day03;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		// 2개의 과목 성적을 입력받아 평균60이 넘고 과락이 없으면 합격(<40), 아니면 불합격
		Scanner scan = new Scanner(System.in);
		System.out.print("과목 1 성적 입력 : ");
		int score1 = scan.nextInt();
		
		System.out.print("과목 2 성적 입력 : ");
		int score2 = scan.nextInt();
		
		int sum = score1+score2;
		String str = (sum >=120 && score1>=40 && score2>=40)? "합격": "불합격";
		System.out.println("결과 : " + str);
	}

}
