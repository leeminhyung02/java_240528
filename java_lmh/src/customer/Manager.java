package customer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import program.Program;

public class Manager implements Program {
	private Scanner scan = new Scanner(System.in);

	public List<Membership> list = new ArrayList<Membership>();
	public List<Room> roomlist = new ArrayList<Room>();
	private String fileName = "src/customer/memberlist.txt";
	private String roomfileName = "src/customer/roomlist.txt";

	public void creatroom() {
		for (int i = 0; i < 10; i++) {
			roomlist.add(new Room(i + 1,false));
		}
	}

	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("0. 회원 가입");
		System.out.println("1. 예약");
		System.out.println("2. 예약확인");
		System.out.println("3. 종료");
		System.out.println("4. 테스트(임시)");
		System.out.print("메뉴 선택 :");

	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch (menu) {
		case 0:
			Membership m = create_account();
			break;
		case 1:
			reservation();
			break;
		case 2:
			check_reservation();
			break;
		case 3:
			exit();
			break;
		case 4:
			test();
			break;
		}

	}

	private void test() {
		System.out.println("날짜 입력 : ");
		scan.nextLine();
		String input = scan.nextLine();
		checkinIn(input);
		
	}

	private Membership create_account() {
		System.out.print("아이디 :");
		String id = scan.next();
		System.out.print("비밀번호 :");
		String pw = scan.next();
		System.out.print("이름 :");
		String name = scan.next();
		System.out.print("전화번호 :");
		String p_number = scan.next();
		if(check_pnum(p_number)) {
			Membership m = new Membership(id, pw, name, p_number);
			return m;			
		}
		else {
			System.out.println("오류가 발생했습니다.");
			return null;
		}
	}

	private boolean check_pnum(String p_number) {
		final String number_pattern = "^\\d{3}-\\d{3,4}-\\d{4}$";

		if (Pattern.matches(number_pattern, p_number)) {
			//제대로 입력
			return true;
		}
		//제대로 입력X
		return false;
	}

	private void reservation() { // 예약
		System.out.println("회원이시라면 1, 회원이 아니시라면 2를 입력해주세요");
		if (scan.nextInt() == 1) {
			System.out.print("아이디 :");
			String id = scan.next();
			System.out.print("비밀번호 :");
			String pw = scan.next();
		}
		else {   //비회원
			System.out.print("이름 :");
			String name = scan.next();
			System.out.println("비밀번호 4자리를 생성(입력)해주세요 :");
			String pw = scan.next();
			System.out.print("전화번호 : ");
			scan.nextLine();
			String p_number = scan.nextLine();
			if(check_pnum(p_number)) {
				Membership m = new Membership(null, pw, name, p_number);			
				list.add(m);
			}	
			else {
				System.out.println("오류가 발생했습니다.");
				return;
			}

			
		}
		System.out.println("날짜 입력 방식 : 2024-01-01 12:30  (년-월-일 시:분)");
		System.out.println("예약하실 날짜를 선택해주세요 :");
		String date = scan.next();
		if(!checkinIn(date)) {
			System.out.println("잘못된 입력방식입니다.");
		}
		
		printroom();
		System.out.print("원하시는 방 번호를 선택해 주세요 : ");
		int roomnumber = scan.nextInt();
		
		if(roomlist.get(roomnumber-1).isIn() == true){
			System.out.println("해당 방은 이미 예약되었습니다.");
			
		}
		System.out.println(roomnumber + "번방 으로 예약 하겠습니다.");
		System.out.println("숙박 일수를 입력해주세요");
		int day = scan.nextInt();
		System.out.println(roomnumber+"호실 "+date+"~"+day+"일간 예약했습니다.");
		roomlist.get(roomnumber-1).setIn(true);
		
	}

	private boolean checkinIn(String input) {
		String format = 
		"\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]) (0[1-9]|1[0-9]|2[0-4]):(0[1-9]|[1-5][0-9])";
		return input.matches(format);
	}

	private void printroom() {
		System.out.println(roomlist);
	}

	private void check_reservation() { // 예약 확인
		
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");

	}

	@Override
	public void run() {
		load(fileName);
		loadRoom(roomfileName);
		int menu = 0;
		do {
			printMenu();
			menu = scan.nextInt();
			try {
				runMenu(menu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (menu != 3);

		save(fileName);
		saveroom(roomfileName);
	}

	@SuppressWarnings("unchecked")
	private void loadRoom(String roomfileName) {
		try (FileInputStream fis = new FileInputStream(roomfileName)) {
			ObjectInputStream ois = new ObjectInputStream(fis);
			roomlist = (List<Room>) ois.readObject();
		} catch (Exception e) {
			creatroom();
		}

	}

	public void saveroom(String roomfileName) {
		try (FileOutputStream fos = new FileOutputStream(roomfileName)) {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(roomlist);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public void load(String fileName) {
		try (FileInputStream fis = new FileInputStream(fileName)) {
			ObjectInputStream ois = new ObjectInputStream(fis);
			list = (List<Membership>) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save(String fileName) {
		try (FileOutputStream fos = new FileOutputStream(fileName)) {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
