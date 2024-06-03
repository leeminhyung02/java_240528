package day05;

import java.util.Scanner;

public class ArrayEx02 {

	public static void main(String[] args) {
		/* 학생 3명의 성적을 저장하는 배열을 생성하고,
		 * 학생 3명의 성적을 콘솔을 통해 입력받고,
		 * 출력하는 코드를 작성하세요.
		 * 입력받은 성적의 평균을 구하는 코드를 작성
		 */
		Scanner scan = new Scanner(System.in);
		int scores[] = new int[3];
		int total=0;
		for(int i = 0; i<scores.length; i++) {
			System.out.print("학생"+(i+1)+"성적 입력 :");
			scores[i] = scan.nextInt();
			//총점을 구하기위해 학생 성적을 입력 할때 마다 누적시킴
			total +=scores[i];
		}
		
		for(int i = 0; i<scores.length; i++) {
		System.out.println("학생"+(i+1)+" : "+scores[i]);
		}
		
		System.out.printf("3명의 평균 : %.3f",(double)total/scores.length);
	}

}
