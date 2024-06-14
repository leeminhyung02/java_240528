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
		Scanner scan = new Scanner(System.in);
		int menu;
		String bar = "-----------------";
		int count = 0;
		Phonebook [] pb = new Phonebook[3];
		do {
			printmenu();
			
			menu = scan.nextInt();
			switch (menu) {
			case 1: {  //번호 추가 
				//1을 입력받으면 공간이 있는지 체크하고 
				for (Phonebook tmp : pb) {
					if (tmp == null) {
						count++;
					}
				}
				if (count == pb.length) {
					pb = expandWordList(pb, 3);
				//없으면 늘리기
				}
				//있다면 입력 받기
				System.out.println(bar);
				System.out.print("이름 :");
				String name = scan.next();
				System.out.print("번호 :");
				String number = scan.next();
				//번호가 중복인지 검사
				boolean tf = false;
				for (int j = 0; j < pb.length; j++) {
					tf = pb[j].getNumber().contains(number);
					if (tf) {System.out.println("이미 등록된 번호 입니다.");}//중복
					break;
				}
				if (tf) {
					break;
				}
				//중복이면 안내문구 출력
				
				//중복이 아니면 전화번호부에 저장
				//입력받은 값을 전화 번호부에 넣기
				for (int i = 0; i < pb.length; i++) {
					if (pb[i] == null) {
						pb[i] = new Phonebook(name,number);	
						break;
					}
				}
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
		System.out.println("1. 번호 추가");
		System.out.println("2. 번호 수정");
		System.out.println("3. 번호 삭제");
		System.out.println("4. 번호 검색");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	/** 단어 리스트를 늘려서 돌려주는 메소드
	 * @param pb 전화번호부
	 * @param size 늘려줄 크기
	 * @return 늘어난 전화번호부
	 */
	public static Phonebook[] expandWordList(Phonebook[] pb, int size) {
		if (pb.length >= size) {
			return pb;
		}
		Phonebook [] tmp = new Phonebook[size];
		//list 0번지부터 list.length를 tmp 의 0번지 부터 복붙
		System.arraycopy(pb, 0, tmp, 0, pb.length);
		return tmp;
	}
}
/**
 *
 */
class Phonebook{
	
	private String name;
	private String number;
	//getter| setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	// constructor
	public Phonebook() {}
	public Phonebook(String name, String number) {
		this.name = name;
		this.number = number;
	}
	
	
}













