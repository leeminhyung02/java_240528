package day15;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		/*
		 * 다음 기능을 가진 프로그램을 작성하세요 메뉴 1. 번호 추가 2. 번호 삭제 3. 번호 조회 sysout(list) 4. 종료
		 */
		ArrayList<String> list = new ArrayList<String>();

		Scanner scan = new Scanner(System.in);
		int menu;
		do {
			printmenu();
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				System.out.print("전화번호 입력 : ");
				String number1 = scan.next();
				if(list.contains(number1)) {
					System.out.println("이미 등록된 번호입니다.");
				}
				else {
					System.out.println("번호를 등록했습니다.");
					list.add(number1);
				}
				break;
			case 2:
				System.out.print("삭제할 번호 입력 : ");
				if (list.remove(scan.next())) {
					System.out.println("삭제 했습니다.");
				} else {
					System.out.println("없는 번호입니다.");
				}
				break;
			case 3:
				System.out.println(list);
				break;
			case 4:
				System.out.println("종료합니다.");
				break;

			default:
				throw new IllegalArgumentException("올바르지 않은 번호 : " + menu);
			}
		} while (menu != 4);
	}
	public static void printmenu() {
		System.out.println("메뉴");
		System.out.println("1. 번호 추가");
		System.out.println("2. 번호 삭제");
		System.out.println("3. 번호 조회");
		System.out.println("4. 종료");

	}
}
