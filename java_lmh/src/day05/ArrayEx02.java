package day05;

import java.util.Scanner;

public class ArrayEx02 {

	public static void main(String[] args) {
		/* 학생 3명의 성적을 저장하는 배열을 생성하고,
		 * 학생 3명의 성적을 콘솔을 통해 입력받고,
		 * 출력하는 코드를 작성하세요.
		 */
		Scanner scan = new Scanner(System.in);
		int scores[] = new int[3];
		for(int i = 0; i<3; i++) {
			System.out.print("성적 입력 :");
			scores[i] = scan.nextInt();
			System.out.println("학생"+(i+1)+" : "+scores[i]);
		}

	}

}
