package account;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class AccountManager implements Program {
	private List<Account> list = new ArrayList<Account>();

	private String fileName = "src/account/account.txt";

	private Scanner scan = new Scanner(System.in);

	private final String income = "수입";
	private final String expenditure = "지출";
	
	@Override
	public void printMenu() {
		System.out.print("메뉴\n" + "1. 내역 입력\n" + "2. 내역 수정\n" + "3. 내역 삭제\n" + "4. 내역 조회\n" + "5. 프로그램 종료\n"
				+ "메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch (menu) {
		case 1:
			insertaccount();
			break;
		case 2:
			updateaccount();
			break;
		case 3:
			deleteaccount();
			break;
		case 4:
			searchaccount();
			break;
		case 5:
			System.out.println("종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴 : "+ menu);
		}
	}

	private void insertaccount() {
		list.add(inputaccount());
	}


	private Account inputaccount() {
		System.out.print("날짜 : ");
		String date = scan.next();
		System.out.print("수입|지출 : ");
		String type = scan.next();
		String classification = "";
		if (type.equals(income)) {
			System.out.println("분류 목록\n"
					+ "월급\n"
					+ "용돈\n"
					+ "부수입\n"
					+ "분류 : ");
			classification = scan.next();
		}
		else if ( type.equals(expenditure)){
			System.out.println("분류 목록\n"
					+ "생활비\n"
					+ "여가\n"
					+ "분류 : ");
			classification = scan.next();
		}
		else {
			System.out.println("잘못된 입력"+ type);
			
		}
		System.out.print("금액 : ");
		int cash = scan.nextInt();
		System.out.print("내용 : ");
		String info = scan.next();
		return new Account(date, type, info, classification, cash);
	}

	private void updateaccount() {
		searchaccount();
		System.out.print("수정할 항목의 번호 :");
		int index = scan.nextInt()-1;
		if (index < 0 || index >= list.size()) {
			System.out.println("잘못된 번호 입력 : "+ (index+1));
		}
		Account tmpaccount = inputaccount();
		list.remove(index);
		list.add(tmpaccount);
		System.out.println("수정 했습니다.");
		
	}


	private void deleteaccount() {
		if(list.size() == 0) {
			System.out.println("내역이 없습니다.");
			return;
		}
		searchaccount();
		System.out.print("삭제할 항목의 번호 : ");
		int index = scan.nextInt()-1;
		if (index < 0 || index >= list.size()) {
			System.out.println("잘못된 번호 입력 : "+ (index+1));
		}
		list.remove(index);
		System.out.println("내역을 삭제 했습니다.");
	}

	private void searchaccount() {
		if(list.size() == 0) {
			System.out.println("내역이 없습니다.");
			return;
		}
		System.out.print("날짜 : ");
		scan.nextLine();
		String date = scan.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getDate().contains(date)) {
				System.out.println((i + 1) + ". " + list.get(i));
			}
		}
	}

	public void sortlist(List<Account> list) {
		//날짜를 이용하여 정렬
		
	}
	
	@Override
	public void run() {
		load(fileName);
		int menu;

		do {
			printMenu();

			menu = scan.nextInt();

			try {
				runMenu(menu);
				sortlist(list);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (menu != 5);
		save(fileName);
	}

	@Override
	public void save(String fileName) {
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try {
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (List<Account>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
