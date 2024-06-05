package day07.homework;

import java.util.Arrays;
import java.util.Scanner;

public class BaseballGame {

	public static void main(String[] args) {
		// 숫자 야구게임을 구현하세요.
		/*
		 * 규칙 - 중복되지 않은 1~9사이의 랜덤한 수를 생성 - 스트라이크 : 해당 숫자가 있고 위치도 같은 경우 - 볼 : 숫자가 있지만 위치가
		 * 다른 경우 - 아웃 : 일치하는 숫자가 하나도 없는 경우
		 * 
		 * 예시 ( 3 9 7) 입력 : 1 2 3 
		 * 1B 
		 * 입력 : 5 6 7 
		 * 1S
		 * 입력 : 4 5 6 
		 * 아웃 
		 * 입력 : 3 7 9 
		 * 1s2b 
		 * 입력 3 9 7
		 * 3s 
		 * 정답입니다.
		 */
		// 생성부분
		int min = 1, max = 10;
		int count = 0;
		int arr[] = new int[3];
		int i;
		// 입력부분
		int input;
		int inputarr[] = new int[3];
		int strike = 0, ball = 0, out = 0;

		Scanner scan = new Scanner(System.in);

		while (count < 3) {
			int random = (int) (Math.random() * (max - min + 1) + min);
			for (i = 0; i < count; i++) {
				if (arr[i] == random) {
					break;
				}
			}
			if (i == count) {
				arr[count] = random;
				count++;
			}
		}
		System.out.println("임시\n" + Arrays.toString(arr));
		// 입력부분
		while (true) {
			System.out.print("입력 : ");
			for (int j = 0; j < 3; j++) {
				inputarr[j] = scan.nextInt();
			}
			// 스트라이크 체크 //숫자 위치 같음
			for (i = 0; i < inputarr.length; i++) {
				for (int j = 0; j < inputarr.length; j++) {
					if (arr[i] == inputarr[i]) {
						strike++;
					}
				}
			}
			// 볼 체크 //숫자 같음
			/*
			 * 0일때 1,2 1일때 0,2 2일때 0,1 체크
			 */
			for (i = 0; i < inputarr.length; i++) {
				if (i == 0) {
					if (arr[i] == inputarr[1]) {
						ball++;
					}
					if (arr[i] == inputarr[2]) {
						ball++;
					}
				} else if (i == 1) {
					if (arr[i] == inputarr[0]) {
						ball++;
					}
					if (arr[i] == inputarr[2]) {
						ball++;
					}
				} else { // i == 2
					if (arr[i] == inputarr[0]) {
						ball++;
					}
					if (arr[i] == inputarr[1]) {
						ball++;
					}
				}
			}
			// 아웃 체크 //일치하는 숫자 X
		}

	}

}
