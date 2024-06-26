package day21.socket2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import program.Program;

public class Clientmanager1 implements Program {

	private Scanner scan = new Scanner(System.in);
	private List<Contact> list = new ArrayList<Contact>();
	private String fileName = "src/day21/socket2.client.txt";
	private String ip = "192.168.30.26";
	private int port = 5001;

	@Override
	public void printMenu() {
		System.out.print(
				"메뉴\n" + "1. 연락처 추가\n" + "2. 연락처 수정\n" + "3. 연락처 삭제\n" + "4. 연락처 확인\n" + "5. 프로그램 종료\n" + "메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) throws Exception {
		switch (menu) {
		case 1:
			insertContact();
			break;
		case 2:
			updateContact();
			break;
		case 3:
			deleteContact();
			break;
		case 4:
			searchContact();
			break;
		case 5:
			break;
		default:
			System.out.println("잘못된 번호 입니다.  : " + menu);
		}

	}

	private void insertContact() {
		System.out.print("추가할 연락처의 이름 : ");
		String name = scan.next();
		System.out.print("추가할 연락처 : ");
		String number = scan.next();
		if (samenumber(number)) {
			System.out.println("추가할 연락처가 이미 리스트에 있습니다.");
			return;
		}
		list.add(new Contact(number, name));
		System.out.println("연락처를 추가 했습니다.");
	}

	private void updateContact() {
		if (!checkempty()) {
			System.out.println("리스트가 비어있습니다.");
			return;
		}
		searchContact();
		System.out.print("수정할 번호를 입력 : ");
		int index = scan.nextInt() - 1;
		System.out.print("이름 : ");
		String name = scan.next();
		System.out.print("연락처 : ");
		String number = scan.next();
		if (samenumber(number, list.get(index).getNumber())) {
			System.out.println("이미 번호가 저장되어있습니다.");
			return;
		}
		list.get(index).setName(name);
		list.get(index).setNumber(number);
		System.out.println("수정을 완료했습니다.");
		return;
		/*
		//연락처를 선택
		//번호를 입력
		System.out.println("번호 입력 :");
		int index = scan.nextInt()-1;
		//입력된 번호 -1 한 번지에 있는 객체를 가져옴
		Contact contact = list.get(index);
		//새로운 연락처 정보를 입력(이름, 번호)
		System.out.println("새 이름 : ");
		String name = scan.next();
		System.out.println("새 번호 : ");
		String num = scan.next();
		//새로운 연락처 객체를 생성
		Contact newContact = new Contact(name, num);
		//수정
		//수정 : 새로운 연락처가 리스트에 있으면 안내문구 출력 후 종료(단, 현재 선택한 연락처가 아닌 연락처중에서)
		
		//전체 탐색
		for (Contact tmp : list) {
			//리스트에서 가져온 객체와 위에서 가져온 객체가 같으면 건너띔
			if(tmp == contact) {
				continue;
			}
			//리스트에서 가져온 객체와 새로운 연락처 객체가 같으면 안내문구 출력후 종료
			if ( tmp.equals(newContact)) {
				System.out.print("이미 등록된 번호입니다.");
				return;
			}
		}
		//위에서 가져온 객체(90)를 새로운 객체로 수정(Contact 클래스에 update 메소드를 추가)
		//contact.update(newContact);
		 * System.out.println("연락처를 수정했습니다.");
		 * */
	}

	private void deleteContact() {
		if (!checkempty()) {
			System.out.println("리스트가 비어있습니다.");
			return;
		}
		searchContact();
		System.out.print("수정할 번호를 입력 : ");
		int index = scan.nextInt() - 1;
		System.out.println(list.get(index));
		System.out.println("삭제할 번호가 맞습니까? (y/n)");
		char yn = scan.next().charAt(0);
		if (yn == 'y' || yn == 'Y') {
			list.remove(index);
			System.out.println("삭제 했습니다.");
		}
		System.out.println("메뉴로 돌아갑니다.");
		return;
		//이름을 입력
		
		//입력한 이름이 포함된 연락처들을 번호와 함께 출력
		
		//번호를 선택
		
		//선택한 번호의 연락처를 삭제
	}

	private void searchContact() {
		if (!checkempty()) {
			System.out.println("리스트가 비어있습니다.");
			return;
		}
		System.out.println("전체 검색 : 엔터");
		System.out.print("찾을 연락처의 이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contains(name)) {
				System.out.println((i + 1) + ". " + list.get(i));
			}
		}
		return;

	}

	/**
	 * 비어있지 않으면 true 비어있으면 false
	 * 
	 * @return t/f
	 */
	private boolean checkempty() {
		if (list == null || list.size() == 0) {
			return false;
		}
		return true;
	}

	/**
	 * 입력받은 번호와 리스트의 번호가 같은지 확인
	 * 
	 * @param number 입력받은 번호
	 * @return 같으면 true/ 틀리면 false
	 */
	private boolean samenumber(String number) {
		for (Contact tmp : list) {
			if (tmp.getNumber().equals(number)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 입력받은 번호와 리스트의 번호가 같은지 확인
	 * 
	 * @param number  입력받은 번호
	 * @param number1 제외할 번호
	 * @return 같으면 true/ 틀리면 false - num1을 제외하고
	 */
	private boolean samenumber(String number, String number1) {
		for (Contact tmp : list) {
			if (tmp.getNumber().equals(number)) {
				if (tmp.getNumber().equals(number1)) {
					continue;
				}
				return true;
			}
		}
		return false;
	}

	@Override
	public void run() {
		int menu = 1;
		load();
		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			menu = scan.nextInt();
			try {
				// 메뉴 실행
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (menu != 5);
		System.out.println("프로그램을 종료합니다.");
		save();

	}

	@SuppressWarnings("unchecked")
	public void load() {
		//소켓 생성
		try {
			Socket socket = new Socket(ip,port);
			//ObjectInput/OutputStream 생성(Socket)
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
			
			//oos를 이용해서 load 문자열 전송
			oos.writeUTF("load");
			oos.flush();
			//ois를 이용해서 연락처 리스트를 저장
			list = (List<Contact>) ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save()	{
		//	1. 소켓 생성
		try {
			Socket socket = new Socket(ip,port);
			//	2. 소켓을 이용하여 ObjectoutputStream 객체 생성
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			//	3. save 문자열 전송
			oos.writeUTF("save");
			//	4. 연락처 리스트를 전송
			oos.writeObject(list);
			oos.flush();
		}catch (Exception e) {
			System.err.println("예외 발생[저장]");
			e.printStackTrace();
		}

	}

}
