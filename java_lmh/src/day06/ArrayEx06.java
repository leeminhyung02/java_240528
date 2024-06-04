package day06;

import java.util.Scanner;

public class ArrayEx06 {

	public static void main(String[] args) {
		/* 4과목의 성적을 입력받아 배열에 저장하고, 과락이 없고 평균이 60점이 넘으면 Pass, 아니면 Fail이라고 출력하시오 */
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[4];
		int total = 0, j = 0;
		// 정석 4개를 입력
		for (int i = 0; i < arr.length; i++) {
			System.out.print("성적" + (i + 1) + " 입력 :");
			int input = scan.nextInt();
			arr[i] = input;
			total += arr[i];
		} // 총합을 이용하여 평균을 계산
		int avg = total / arr.length;
		for (int tmp : arr) { // 과락 여부를 확인하여 변수에 저장
			if (tmp >= 40) {
				j = 1;
			} else {
				j = 0;
				break;
			}
		} // 과락이 아니고 평균이 60이상이면 Pass
		if (j == 1 && avg >= 60) {
			System.out.println("Pass");
		} // 아니면 Fail
		else {
			System.out.println("Fail");
		}
	}
}
