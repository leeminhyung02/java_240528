package day13.homework;

import java.util.Scanner;

public class PhoneEx01 {
	/*
	 *연락처 관리를 위한 프로그램을 만드세요
	 *
	 * 메뉴
	 * 1. 연락처 추가
	 * 2. 연락처 수정
	 * 3. 연락처 삭제
	 * 4. 연락처 검색
	 * 5. 프로그램 종료
	 * 메뉴 선택 : 1
	 * -------------------
	 * 이름 : 홍길동
	 * 연락처  : 010-1234-5678
	 * -------------------
	 * 등록이 완료됐습니다.
	 * 
	 * 메뉴 선택 : 1
	 * 이름 : 홍길동
	 * 연락처  : 010-5315-3515
	 * -------------------
	 * 등록이 완료됐습니다.
	 * -------------------
	 * 이름 : 고길동
	 * 연락처 : 010-1234-5678
	 * ---------------------
	 * 이미 등록된 번호입니다.
	 * ---------------------
	 * 메뉴 선택 : 2
	 * 이름 : 홍
	 * 1. 홍길동 : 010-1234-5678
	 * 2. 홍길동 : 010-5315-3515
	 * 번호 선택 : 1
	 * 이름 : 홍길동
	 * 번호 : 010-7894-5678
	 * ---------------------
	 * 수정이 완료됐습니다.
	 * 메뉴 선택 : 2
	 * 이름 : 홍
	 * 1. 홍길동 : 010-7894-5678
	 * 2. 홍길동 : 010-5315-3515
	 * 번호 선택 : 1
	 * 이름 : 홍길동
	 * 번호 : 010-5315-3515
	 * -------------------
	 * 이미 등록된 번호입니다.
	 * -------------------
	 * 메뉴 선택 : 4
	 * 검색할 이름을 작성하세요(전체 검색 : 엔터) : 
	 * 1. 홍길동 : 010-7894-5678
	 * 2. 홍길동 : 010-5315-3515
	 * -------------
	 * 메뉴 선택 : 3
	 * 이름 : 홍
	 * 삭제할 번호 선택 : 1
	 * -----------------
	 * 번호를 삭제했습니다.
	 * 
	 */
	public static void main(String[] args) {
		int menu;
		do {
			printmenu();
			Scanner scan = new Scanner(System.in);
			menu = scan.nextInt();
			switch (menu) {
			case 1: {  //번호 추가
				break;
			}
			case 2:{ 	//번호 수정
				break;
			}
			case 3:{	//번호 삭제
				break;
			}
			case 4:{	//번호 검색
				break;
			}
			case 5:{	//프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + menu);
			}
			
		}while (menu != 5);
		
	}
	public static void printmenu() {
		System.out.println("메뉴");
		System.out.println("1. 연락처 추가");
		System.out.println("2. 연락처 수정");
		System.out.println("3. 연락처 삭제");
		System.out.println("4. 연락처 검색");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
}
