package day18.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class ScheduleManagerHard implements Program{
	private List <Member> member = new ArrayList<Member>();
	
	private Scanner scan = new Scanner(System.in);
		
	private final int MAINMEMBER = 1;
	private final int MAINSH = 2;
	private final int EXIT = 3;
	

	
	public void test() {
		List < Schedule> list = new ArrayList<Schedule>();
		Member mem = new Member(list,"아이디","이름");
		member.add(mem);
		member.get(0).getName();
		
	}
	public void MainMenu() {
		System.out.println("메인 메뉴");
		System.out.println("1. 회원 관리");
		System.out.println("2. 일정 관리");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		
	}
	public void printmembermanage() {
		System.out.println("1. 회원 추가");
		System.out.println("2. 회원 수정");
		System.out.println("3. 회원 삭제");
		System.out.println("4. 이전으로");
		System.out.print("메뉴 선택 : ");
	}
	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 일정 추가");
		System.out.println("2. 일정 수정");
		System.out.println("3. 일정 삭제");
		System.out.println("4. 일정 확인");
		System.out.println("5. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		
	}
	@Override
	public void runMenu(int menu) throws Exception {
		switch (menu) {
		case MAINMEMBER:    //새로 추가되는 부분  회원관리
			printmembermanage();
			int n = scan.nextInt();
			membermanage(n);
			break;
		case MAINSH:          // 기존에 있던 쉬운버전 사용
			if(checkID()) {
				ScheduleManager sm = new ScheduleManager();
				sm.run();
			}
			else {
				System.out.println("등록되지 않은 회원입니다.");
			}
			break;
		case EXIT:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			throw new IllegalArgumentException("잘못된 입력 : " + menu);
		}
		
	}
	private void membermanage(int n) {
		switch (n) {
		case 1: //회원 추가
			addmember();
			break;
		case 2: //회원 수정
			updatemember();
			break;
		case 3: //회원 삭제
			deletemember();
			break;
		case 4: // 이전으로
			System.out.println("메인 메뉴로 돌아갑니다.");
			break;
		default:
			throw new IllegalArgumentException("잘못된 입력 : " + n);
		}
		
	}
	private void deletemember() {

	}
	private void updatemember() {
		// TODO Auto-generated method stub
		
	}
	private void addmember() {
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		String checkfileName = "src/day18/homework/list/"+id+".txt";
		load(checkfileName);
		for (Member tmp : member) {
			if(tmp.getId().equals(id)) {
				System.out.println("이미 있는 아이디입니다.");
				return;
			}
		}
		System.out.print("이름 입력 : ");
		String name = scan.next();
		Member tmp = new Member(null, id, name);
		System.out.println("회원생성이 완료되었습니다.");
		String fileName = "src/day18/homework/list/"+id+".txt";
		save(fileName);
	}
	private boolean checkID() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void run() {
		
		int menu = 0;
		
		do {
			MainMenu();
			menu = scan.nextInt();
			try {
				runMenu(menu);
				
			}// catch(Exception) {
		//	}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("예외발생");
			}
		} while (menu != EXIT);

	}
	
	@Override
	public void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(member);
		} catch (IOException e) {
			System.out.println("저장실패");
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
				member = (List<Member>)ois.readObject();
		} catch (Exception e) {
			System.out.println("불러오기실패");
		}
	}

}
