package day04.homework;

import java.util.Scanner;

public class UpDowngame2 {

	public static void main(String[] args) {
		// 1~100 사이의 랜덤한 수를 생성하여 해당 숫자를 맞추는 게임을 작성하세요
		/*		랜덤한 수 30
		 * 정수 입력 : 50
		 * down
		 * 정수입력 : 20
		 * up
		 * 정수입력 : 30
		 * 정답입니다.
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		int num = 0;
		int min = 1, max = 100; 
		int n1,n2 = -1;
		int count = 0;
		int random;
		for (int i = 1; i<=100; i++) {
			random = get_random(min, max);
			if (random == 50) {
				count++;
			}
		}
		System.out.println(count);
	} 
	public static int get_random(int min, int max) {
		int random = (int)(Math.random() * (max - min + 1) + min);
		return random;
	}
}
