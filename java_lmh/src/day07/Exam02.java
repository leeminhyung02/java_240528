package day07;

import java.util.Scanner;

public class Exam02 {

	public static void main(String[] args) {
		/*
		 * 최대 단어 2개를 저장할 수 있는 배열을 이용하여
		 * 원하는 단어를 입력하면 단어를 배열에 추가하는 코드를 작성하세요.
		 * 
		 * 단어입력 (종료 : -1) : cat
		 * 단어를 추가했습니다.
		 * 단어입력 (종료 : -1) : dog
		 * 단어를 추가했습니다.
		 * 단어입력 (종료 : -1) : good
		 * 단어를 추가하지 못했습니다.
		 */
		
		String arr[] = new String[] {"0","0"};
		Scanner scan = new Scanner(System.in);
		int count = 0;
		String input;
		do {
			//안내문구
			System.out.print("단어입력 (종료 : -1) : ");
			input = scan.next();
			for (int i = 0; i < arr.length; i++) {
				if ( arr[i] !="0" ) {
					arr[i] = input;
					System.out.println("단어를 추가했습니다.");
				}
				else {
					count++;
				}
			}
			if (count == arr.length) {
				System.out.println("단어를 추가하지 못했습니다.");
				count = 0;
			}
		}while ( input !=  "-1");
		
		while(true) {
			System.out.print("단어 입력 (종료 : -1) : ");
			input = scan.next();
			if (count == arr.length) {
				System.out.println("단어를 추가하지 못했습니다.");
			}
			else {
				arr[count] = input;
				count++;
				System.out.println("");
			}
		}
	}

}
