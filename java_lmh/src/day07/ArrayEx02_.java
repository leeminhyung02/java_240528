package day07;

import java.util.Scanner;

public class ArrayEx02_ {

	public static void main(String[] args) {
		// 1~9사이의 랜덤한 수 3개를 배열에 저장하는데,
		//중복되지 않게 저장하는 코드를 작성해보세요.
		// 저장된 숫자가 3개가 아닐 때 반복 = > 저장된 숫자가 3보다 작을 때
		/*
		 * 랜덤한 수를 생성해서 중복되지 않으면 저장
		 * 반복문 종료 후 :  배열에 저장된 숫자 출력
		 */
		//랜덤한 수를 생성하여 변수에 저장
		int min = 1;
		int max = 10;
		int arr[] = new int[3];
		int count = 0;
		boolean same = false;
		for (int i = 0; i < arr.length; i++) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			arr[i] = random;
		}
		do {
			if (arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
				same = true;	
				for (int i = 0; i < arr.length; i++) {
					int random = (int)(Math.random() * (max - min + 1) + min);
					arr[i] = random;
				}
			}
			else {
				same = false;
			}
		}while (same == true);

		for (int tmp : arr) {
			System.out.println(tmp);
		}

	}

}
