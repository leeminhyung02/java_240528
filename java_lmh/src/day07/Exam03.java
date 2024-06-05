package day07;

import java.util.Scanner;

public class Exam03 {

	public static void main(String[] args) {
		/*
		 * 입력한 문자열이 배열에 있는지 없는지 확인하는 코드를 작성
		 *  단어 입력 (종료 : -1) : apple
		 *  없는 단어입니다. 
		 *  단어 입력 (종료 : -1) : cat 있는 단어입니다. 
		 *  단어 입력 (종료 : -1) : -1 
		 *  종료합니다.
		 */

		String[] arr = new String[] { "cat", "dog", "banana" };
		Scanner scan = new Scanner(System.in);
		String input;
		boolean result = false;
		while (true) {
			System.out.print("단어 입력 (종료 : -1) : ");
			input = scan.next();
			// 종료
			if (input.equals("-1")) {
				System.out.println("종료합니다.");
				break;
			}
			// 있는지 체크
			for (String tmp : arr) {
				if (input.equals(tmp)) {
					result = true;
					break;
				}
			}
			// 출력
			if (result == true) {
				System.out.println("있는 단어입니다.");
				result = false;
			} else {
				System.out.println("없는 단어입니다.");
			}
		}
	}

}
