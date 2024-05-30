package day03;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		// 학생 3명의 성적을 입력받아 총점과 평균구하기
		Scanner scan = new Scanner(System.in);
		
		int  score_1,score_2,score_3;
		System.out.print("학생 1 성적 입력 :");
		score_1 = scan.nextInt();
		System.out.print("학생 2 성적 입력 :");
		score_2 = scan.nextInt();
		System.out.print("학생 3 성적 입력 :");
		score_3 = scan.nextInt();
		
		int sum = score_1+score_2+score_3;
		double average = (double)sum/3;
		System.out.println("총점 : "+ sum + "점.   평균 : "+ average);
	}

}
