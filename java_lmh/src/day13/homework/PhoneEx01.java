package day13.homework;

import java.text.MessageFormat;
import java.util.Scanner;

public class PhoneEx01 {
	/*
	 * 연락처 관리를 위한 프로그램을 만드세요
	 *
	 * 메뉴 1. 연락처 추가 2. 연락처 수정 3. 연락처 삭제 4. 연락처 검색 5. 프로그램 종료 메뉴 선택 : 1
	 * ------------------- 이름 : 홍길동 연락처 : 010-1234-5678 ------------------- 등록이
	 * 완료됐습니다.
	 * 
	 * 메뉴 선택 : 1 이름 : 홍길동 연락처 : 010-5315-3515 ------------------- 등록이 완료됐습니다.
	 * ------------------- 이름 : 고길동 연락처 : 010-1234-5678 --------------------- 이미 등록된
	 * 번호입니다. --------------------- 메뉴 선택 : 2 이름 : 홍 1. 홍길동 : 010-1234-5678 2. 홍길동 :
	 * 010-5315-3515 번호 선택 : 1 이름 : 홍길동 번호 : 010-7894-5678 --------------------- 수정이
	 * 완료됐습니다. 메뉴 선택 : 2 이름 : 홍 1. 홍길동 : 010-7894-5678 2. 홍길동 : 010-5315-3515 번호 선택
	 * : 1 이름 : 홍길동 번호 : 010-5315-3515 ------------------- 이미 등록된 번호입니다.
	 * ------------------- 메뉴 선택 : 4 검색할 이름을 작성하세요(전체 검색 : 엔터) : 1. 홍길동 :
	 * 010-7894-5678 2. 홍길동 : 010-5315-3515 ------------- 메뉴 선택 : 3 이름 : 홍 삭제할 번호 선택
	 * : 1 ----------------- 번호를 삭제했습니다.
	 * 
	 */
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int menu;
		//
		Phonebook[] pb = new Phonebook[3];
		int listcount = 0;
		do {
			printmenu();
			menu = scan.nextInt();

			switch (menu) {
			case 1: {
				// 번호 추가
				listcount = insertnumber(pb, listcount);
				if (listcount == pb.length) {
					pb = expandnumlist(pb, listcount+3);
				}
				break;
			}
			case 2: {  //번호 수정
				updatelist(pb, listcount);
				break;
			}
			case 3: { // 번호 삭제
				if (pb[0] == null) {
					System.out.println("번호 리스트가 비어있습니다.");
					break;
				}
				System.out.print("이름 : ");
				String name = scan.next();
				printSerachWord(pb,listcount,name);
				System.out.print("삭제할 번호를 입력하세요 :");
				int num = scan.nextInt();
				int index = num-1;
				if (!checkWord(pb, name, index)) {  //아니면
					System.out.println("잘못된 번호를 선택했습니다.");
					break;
				}
				else {
					pb[index] = null;
					if (num == listcount) {
						System.out.println("번호를 삭제 했습니다.");
						listcount--;
					}
					else { 
						for(index = num-1; index < listcount-1; index++) {
							pb[index] = pb[index+1];
						}
						pb[listcount-1] = null;
						listcount--;
						System.out.println("번호를 삭제 했습니다.");
					}
				}
				break;
			}
			case 4: { // 번호 검색
				if (pb[0] == null) {
					System.out.println("번호 리스트가 비어있습니다.");
					break;
				}
				// 단어를 입력하면 해당하는 단어를 출력
				System.out.print("검색할 이름을 입력 (엔터시 전체 검색)  : ");
				String word = scan.nextLine();
				word = scan.nextLine();
				int count = 0;
				//	단어 리스트에 수정할 단어와 일치하는 단어들을 번호와 함께 출력
				// 같은 단어가 여러개라면 여러개의 단어를 출력
				if (word.equals("")) {
					for (int i = 0; i < listcount; i++) {
						System.out.print((i+1)+"번. ");
						pb[i].print();
					}
					break;
				}
				for (int i = 0; i < listcount; i++) {
					if (pb[i].getName().contains(word)) {
						System.out.print((i+1)+"번. ");
						pb[i].print();		
					}
					else {
						count++;
					}
				}
				if (count >= listcount) {
					System.out.println("해당 이름이 리스트에 없습니다.");
				}
				break;
			}
			case 5: { // 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + menu);
			}

		} while (menu != 5);

	}

	public static void bar() {
		System.out.println("-----------------");
	}



	/**
	 * 단어를 입력받아 단어 리스트에 해당 단어가 있는지 출력하는 메소드
	 * 
	 * @param pb      단어 리스트
	 * @param listcount 저장된 단어 개수
	 * 
	 */


	public static void printmenu() {
		System.out.println("메뉴");
		System.out.println("1. 번호 추가");
		System.out.println("2. 번호 수정");
		System.out.println("3. 번호 삭제");
		System.out.println("4. 번호 검색");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 :");
	}
	/**
	 * 기능 : 단어 리스트에 단어를 입력받아 단어를 추가하고 등록된 단어 숫자를 알려주는 메소드
	 * 
	 * @param list      단어 리스트
	 * @param wordCount 저장된 단어 개수
	 * @return 저장된 단어 개수
	 */
	public static int insertnumber(Phonebook[] pb, int listcount) {
		Phonebook tmpt = pb[listcount];
		Phonebook tmp = inputWord(pb, listcount);
		// 단어 리스트에 단어 객체를 저장 => 마지막으로 저장된 위치 다음에 단어 객체를 저장
		if (tmp == null) {
			pb[listcount] = tmpt;
			return listcount;
		}
		pb[listcount] = tmp;
		// 저장된 단어 개수를 1 증가
		listcount++;
		// 단어 리스트를 정렬(알파벳순으로)

		return listcount;
	}
	
	/**
	 * 기능 : 단어 정보를 입력받아 단어 객체를 돌려주는 메소드
	 * 
	 * @return 단어 객체
	 */
	public static Phonebook inputWord(Phonebook [] pb , int listcount) {
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("번호 : ");
		String number = scan.next();
		for (int i = 0;  i < listcount;  i++) {
			if ( pb[i].getNumber().equals(number)) {
				System.out.println("이미 번호가 있습니다.");
				return null;
			}
		}
		Phonebook tmp = new Phonebook( name, number);
		return tmp;
	}




	/**
	 * 단어 리스트를 늘려서 돌려주는 메소드
	 * 
	 * @param pb 단어 리스트
	 * @param size 늘려줄 크기
	 * @return 늘어난 단어 리스트
	 */
	public static Phonebook[] expandnumlist(Phonebook[] pb, int size) {
		if (pb.length >= size) {
			return pb;
		}
		Phonebook[] tmp = new Phonebook[size];
		// list 0번지부터 list.length를 tmp 의 0번지 부터 복붙
		System.arraycopy(pb, 0, tmp, 0, pb.length);
		return tmp;
	}

	/**
	 * list에 i번지에 있는지 단어가 word인지 아닌지 알려주는 메소드
	 * 
	 * @param pb 단어 리스트
	 * @param name 검색할 단어
	 * @param i    해당 단어의 번지
	 * @return index 번지에 word가 있으면 true, 없으면 false
	 */
	public static boolean checkWord(Phonebook[] pb, String name, int i) {
		if (pb[i] == null) {
			return false;
		}
		return pb[i].getNumber().contains(name);
	}

	public static void updatelist(Phonebook[] pb, int listcount) {
//		단어 수정을 구현하기 위한 과정을 주석으로 작성. 같은 단어가 있는 경우
		// 누구를 수정할지를 선택하는 부분을 고민해야함.
		// 수정할 단어를 입력
		System.out.print("수정할 번호를 입력");
		String name = scan.next();
		// 단어 리스트에 수정할 단어와 일치하는 단어들을 번호와 함께 출력
		// 수정할 단어를 선택
		printSerachWord(pb, listcount, name);
		System.out.print("수정할 단어의 번호를 선택하세요  : ");
		int num = scan.nextInt();
		boolean res = checkWord(pb, name, num - 1);
		if (!res) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		// 수정한 단어, 품사, 의미를 입력
		// 입력한 정보로 선택한 단어를 수정
		Phonebook tmp = inputWord(pb,listcount);
		pb[num - 1].updatelist(tmp);
		pb[num - 1].print();
		System.out.println("단어를 수정했습니다.");
	}

	/**
	 * 단어 리스트에 단어가 있으면 해당 단어를 출력하고 없으면 없다고 출력하는 메소드
	 * 
	 * @param pb      단어 리스트
	 * @param name      단어
	 * @param listcount 저장된 단어 수
	 */
	public static void printSerachWord(Phonebook[] pb, int listcount, String name) {
		int count = 0; // 일치하는 단어가 몇개 있는지 확인하는 변수
		// 단어 리스트에 수정할 단어와 일치하는 단어들을 번호와 함께 출력
		for (int i = 0; i < listcount; i++) {
			if (pb[i].getName().contains(name)) {
				System.out.print((i + 1) + "번.");
				pb[i].print();
				count++;
			}
		}
		if (count == 0) {
			System.out.println("번호가 없습니다.");
			return;
		}
	}
	public static int deleteWord(Phonebook[] pb, int listcount) {
		// 삭제할 단어를 입력
		if(listcount == 0) {
			System.out.println("번호 리스트가 비어있습니다.");
			return listcount;
		}
		System.out.print("이름 : ");
		String name = scan.next();
		// 삭제할 단어를 출력
		printSerachWord(pb, listcount, name);
		// 삭제할 단어를 선택
		// 잘못된 선택이면 안내문구 출력
		System.out.println("번호를 입력하세요");
		int num = scan.nextInt();
		if (!checkWord(pb, name, num-1)) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return listcount;
		}
		// 올바른 선택이면 삭제
		// 삭제하려는 번지 다음에 있는 단어들부터 앞으로 한칸씩 당기고 마지막 단어를 null로 만듦
		// 저장된 단어수를 1감소
		listcount = deleteWordlist(pb, listcount, num );
		System.out.println("삭제를 완료했습니다.");
		return listcount;
	}
	
	/**
	 * 배열의 index번지에 요소를 삭제하는 메소드
	 * 
	 * @param pb      단어 리스트
	 * @param listcount 단어 수
	 * @param index     삭제할 위치
	 * @return 삭제된 후 단어 수
	 */
	public static int deleteWordlist(Phonebook[] pb, int listcount, int index) {

		Phonebook[] tmp = new Phonebook[pb.length];
		// 올바른 선택이면 삭제
		// 삭제하려는 번지 다음에 있는 단어들부터 앞으로 한칸씩 당기고 마지막 단어를 null로 만듦
		// 저장된 단어수를 1감소
		if (listcount - index - 1 != 0) {
			System.arraycopy(tmp, index + 1, pb, index, listcount - index - 1);
		}
		listcount--;
		pb[listcount] = null;
		return listcount;
	}

}

/**
 *
 */
class Phonebook {

	private String name;
	private String number;

	// getter| setter
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
	public Phonebook() {
	}

	public Phonebook(String name, String number) {
		this.name = name;
		this.number = number;
	}
	public void print() {
		String format = "{0} :  {1}";
		String res = MessageFormat.format(format,name, number);
		System.out.println(res);
	}
	public void updatelist(Phonebook pb) {
		this.name = pb.name;
		this.number = pb.number;
	}
}
