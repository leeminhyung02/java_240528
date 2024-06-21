package day18.homework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import program.Program;

public class ScheduleManager implements Program{

	private List < Schedule> list = new ArrayList<Schedule>();
	private Scanner scan = new Scanner(System.in);
	
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE= 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	
	
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
		case INSERT:
			insert();
			sort();
			break;
		case UPDATE:
			update();
			sort();
			System.out.println("-----------------------");
			break;
		case DELETE:
			delete();
			sort();
			System.out.println("-----------------------");
			break;
		case SEARCH:
			search();
			System.out.println("-----------------------");
			break;
		case EXIT:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			throw new IllegalArgumentException("잘못된 메뉴 선택 : " + menu);
		}
		
	}
	private void sort() {
		Collections.sort(list,(o1,o2)->o1.getDate().compareTo(o2.getDate()));
	}
	
	
	private void delete() {
		System.out.println("날짜 : ");
		scan.nextLine();
		String date = scan.nextLine();
		List<Schedule>tmp = list.stream().filter(t->t.getDate().contains(date))
				.collect(Collectors.toList());
		if(tmp.size() == 0) {
			System.out.println("일치하는 날짜가 없습니다.");
			return;
		}
		for(int i = 0; i < tmp.size(); i++) {
			System.out.println((i+1)+"번. "+tmp.get(i));
		}
		System.out.println("번호 : ");
		int index = scan.nextInt() -1;
		if (index < 0 || index >= tmp.size()) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		list.remove(index);
		System.out.println("일정을 삭제 했습니다.");
		return;
	}

	private void update() {
		System.out.println("날짜 : ");
		scan.nextLine();
		String date = scan.nextLine();
		
		List<Schedule>tmp = list.stream().filter(t->t.getDate().contains(date))
				.collect(Collectors.toList());
		if(tmp.size() == 0) {
			System.out.println("일치하는 날짜가 없습니다.");
			return;
		}
		for(int i = 0; i < tmp.size(); i++) {
			System.out.println((i+1)+"번. "+tmp.get(i));
		}
		System.out.println("번호 : ");
		int index = scan.nextInt() -1;
		if (index < 0 || index >= tmp.size()) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		list.remove(tmp.get(index));
		Schedule newSchedule =inputdata();
		list.add(newSchedule);
	}

	/**
	 * 날짜를 입력받고
	 * 해당하는 날짜의 일정리스트를 출력
	 */
	private void search() {
		System.out.println("날짜 : ");
		scan.nextLine();
		String date = scan.nextLine();
		
		long count = list.stream().filter(c->c.getDate().contains(date)).count();
		if(count == 0) {
			System.out.println("일치하는 날짜가 없습니다.");
			return;
		}
		list.stream().filter(c->c.getDate().contains(date))
			.forEach(c->System.out.println(c));
		
	}

	/**
	 * 입력받은 내용을 토대로 객체에 저장
	 * @return  Schedule
	 */
	private Schedule inputdata() {
		
		System.out.println("날짜 : ");
		scan.nextLine();
		String date = scan.nextLine();
		System.out.print("일정 : ");
		String schedule = scan.nextLine();
		System.out.print("상세 : ");
		String info = scan.nextLine();
		Schedule tmp = new Schedule(schedule, info, date);
		return tmp;
	}
	/**
	 * 입력받은 날짜가 알맞으면 리스트에 저장
	 */
	private void insert() {
		Schedule sh = inputdata();
		
		if(checkregex(sh)) {
			list.add(sh);
			System.out.println("-----------------------");
			System.out.println("일정이 추가되었습니다.");
			System.out.println("-----------------------");
		}
		else {
			System.out.println("-----------------------");
			System.out.println("날짜가 알맞게 입력되지 않았습니다.");
			System.out.println("-----------------------");

		}
	}


	/**
	 * 정규 표현식으로 문법에 맞는지 체크후 T/F 반환
	 * @param Schedule  (yyyy-MM-dd hh:mm) (String)
	 * @return  T/F
	 */
	public boolean checkregex(Schedule sh) {
		return Pattern.matches(Schedule.regex,sh.getDate());
	}
	

	@Override
	public void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(list);
		} catch (IOException e) {
			System.out.println("저장실패");
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis)){
				list = (List<Schedule>)ois.readObject();
		} catch (Exception e) {
			System.out.println("불러오기실패");
		}
	}
	@Override
	public void run() {
		String fileName = "src/day18/homework/homework.txt";
		
		load(fileName);
		
		int menu = 0;
		
		do {
			printMenu();
			menu = scan.nextInt();
			try {
				runMenu(menu);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("예외발생");
			}
		} while (menu != EXIT);

		save(fileName);
	}

}
