package day06;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		/*
		 * 4자리 정수를 입력받아 입력받은 정수를 역순으로 배열에 저장하고출력 4자리 정수 입력 4자리 정수가 아니면 잘못입력됐다고 출력 4자리
		 * 정수이면 역순으로 배열 저장 배열에 값을 순차적으로 출력
		 */

		Scanner scan = new Scanner(System.in);
		int arr[], num;
		arr = new int[4];
		System.out.print("정수 역순 :");
		num = scan.nextInt();
		if (num < 1000 || num > 9999) { // 9999>=num >=1000
			System.out.println("정수가 잘못 입력되었습니다."); // 123
		} else {
			int tmp = num;
			int i = 0;
			while (tmp != 0) {
				arr[i++] = tmp % 10;
				tmp /= 10;
			}
			for (int temp: arr) {
				System.out.println(temp);
			}

		}

	}

}
