package day07;

import java.util.Arrays;
import java.util.Scanner;

public class Exam04 {

	public static void main(String[] args) {

		/*
		 * Exam01~03 기능을 하나로 합쳐서 다음 기능을 구현하세요.
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * ----------------------
		 * 단어입력 (종료 : -1) : cat
		 * 단어를 추가했습니다.
		 * 단어입력 (종료 : -1) : dog
		 * 단어를 추가했습니다.
		 * 단어입력 (종료 : -1) : good
		 * 단어를 추가하지 못했습니다.
		 * 단어입력 (종료 : -1) : -1
		 * 메뉴로 돌아갑니다.
		 * ----------------------
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 2
		 *  ----------------------
		 *  단어 입력 (종료 : -1) : apple
		 *  없는 단어입니다. 
		 *  단어 입력 (종료 : -1) : cat 있는 단어입니다. 
		 *  단어 입력 (종료 : -1) : -1 
		 *  메뉴로 돌아갑니다.
		 *   ----------------------
		 * 메뉴
		 * 1. 추가
		 * 2. 검색
		 * 3. 종료
		 * 메뉴 선택 : 3
		 * 종료합니다.
		 */
		final int len = 2; // 배열의 크기
		String arr[] = new String[len];
		Scanner scan = new Scanner(System.in);
		int input;
		int count = 0;
		boolean result = false;
		String input_word;
		String bar = "- - - - - - - - - - - - - - - - - - - - - -";
		while (true) {
			// 안내문구
			System.out.println("메뉴");
			System.out.println("1. 추가");
			System.out.println("2. 검색");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			input = scan.nextInt();
			System.out.println(bar);
			switch (input) {
			case 1: { // 추가

				while (true) {
					System.out.print("단어 입력 (종료 : -1) : ");
					input_word = scan.next();
					System.out.println(bar);
					if (input_word.equals("-1")) {
						System.out.println("메뉴로 돌아갑니다.");
						break;
					}
					if (count == arr.length) {
						System.out.println("단어를 추가하지 못했습니다.\n");
					} else {
						arr[count] = input_word;

						count++;
						System.out.println("단어를 추가했습니다.\n");
					}
				}
				System.out.println(Arrays.toString(arr));
				System.out.println(bar);
				break;
			}

			case 2: { // 검색

				while (true) {
					System.out.print("단어 입력 (종료 : -1) : ");
					input_word = scan.next();
					System.out.println(bar);
					// 종료
					if (input_word.equals("-1")) {
						System.out.println("메뉴로 돌아갑니다");
						break;
					}
					// 있는지 체크
					for (String tmp : arr) {
						if (input_word.equals(tmp)) {
							result = true;
							break;
						}
					}
					// 출력
					if (result == true) {
						System.out.println("있는 단어입니다.\n");
						result = false;
					} else {
						System.out.println("없는 단어입니다.\n");
					}
				}
				System.out.println(bar);
				break;
			}
			case 3: {
				System.out.println("종료합니다.");
				System.out.println(bar);
				break;
			}
			default: {
				System.out.println("잘못된 메뉴입니다.");
				System.out.println(bar);
				break;
			}
			}
			if (input == 3) {
				break;
			}
		}
	}

}
