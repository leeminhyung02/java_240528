package student;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import day19.board.Board;
import program.Program;

public class StudentManager implements Program {
	// 학생 성적 관리를 위한 리스트
	private List<Student> list = new ArrayList<Student>();
	// 과목 관리를 위한 리스트
	private Scanner scan = new Scanner(System.in);
	private List<String> subjectlist = new ArrayList<String>();
	private String fileName = "src/student/student.txt";
	
	
	@Override
	public void printMenu() {
		System.out.print("메뉴\n" + "1. 학생 관리\n" + "2. 과목 관리\n" + "3. 종료\n" + "메뉴 선택 :");
	}

	@Override
	public void run() {
		load(fileName);
		int menu;

		do {
			printMenu();

			menu = nextInt();

			try {
				runMenu(menu);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (menu != 3);
		save(fileName);
	}
	
	@Override
	public void save(String fileName) {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(list);
			oos.writeObject(subjectlist);
		} catch (IOException e) {
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try (FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			list = (List<Student>) ois.readObject();
			subjectlist = (List<String>) ois.readObject();
		} catch (Exception e) {
		}
	}
	
	/**
	 * 콘솔에서 정수를 입력받아 반환하는 메소드로 잘못입력하면(문자열) 정수의 가장 작은 수를 반환
	 * 
	 * @return 입력한 정수 또는 정수의 가장 작은 수
	 */
	public int nextInt() {
		try {
			return scan.nextInt();
		} catch (InputMismatchException e) {
			scan.nextLine(); // 잘못 입력한 값을 입력 버퍼에 비워줌
			return Integer.MIN_VALUE; // int의 가장 작은 수를 리턴
		}
	}

	@Override
	public void runMenu(int menu) throws Exception {

		switch (menu) {
		case 1:
			student();
			break;
		case 2:
			subject();
			break;
		case 3:
			exit();
			break;
		default:

		}
	}

	private void student() {
		int menu;
		do {
			printStudentMenu();
			menu = nextInt();
			runStudentMenu(menu);
		} while (menu != 5);

	}

	private void printStudentMenu() {
		System.out.print("학생 관리 메뉴\n" 
				+ "1. 학생 추가\n" 
				+ "2. 학생 수정\n" 
				+ "3. 학생 삭제\n" 
				+ "4. 학생 조회\n" 
				+ "5. 이전으로 \n"
				+ "메뉴 선택 : ");
	}

	private void runStudentMenu(int menu) {
		switch (menu) {
		case 1:
			studentInsert();
			break;
		case 2:
			studentUpdate();
			break;
		case 3:
			studentDelete();
			break;
		case 4:
			studentSearch();
			break;
		case 5:
			prev();
			break;
		default:
		}
	}

	private void studentInsert() {

		// 입력한 정보를 이용하여 객체를 생성
		Student std = inputStudentExpand();

		// 객체가 리스트에 있으면 안내문구 출력 후 종료
		if (list.contains(std)) {
			System.out.println("이미 등록된 학년, 반, 번호입니다.");
			return;
		}

		// 없으면 추가 후 안내문구 출력
		list.add(std);
		System.out.println("학생을 추가했습니다.");
	}

	/**
	 * 학년 반 번호를 입력받아 학생 객체를 만들어서 반환하는 메소드
	 * 
	 * @return 학년, 반, 번호가 있는 만들어진 학생 객체
	 */
	public Student inputStudent() {
		// 학년, 반, 번호, 이름을 입력
		System.out.print("학년 : ");
		int grade = nextInt();
		System.out.print("반 : ");
		int classNum = nextInt();
		System.out.print("번호 : ");
		int num = nextInt();
		return new Student(grade, classNum, num, "");
	}

	/**
	 * 학년 반 번호 이름을 입력받아 학생 객체를 만들어서 반환하는 메소드
	 * 
	 * @return 학년, 반, 번호, 이름이 있는 만들어진 학생 객체
	 */
	public Student inputStudentExpand() {
		Student std = inputStudent();
		System.out.print("이름 : ");
		scan.nextLine();
		String name = scan.nextLine();
		std.setName(name);
		return std;
	}

	private void studentUpdate() {
		int menu;
		do {
			printStudentUpdateMenu();
			menu = nextInt();
			runStrudentUpdateMenu(menu);
		} while (menu != 5);

	}

	private void printStudentUpdateMenu() {
		System.out.print("학생 수정 메뉴\n" 
				+ "1. 학생 정보 수정\n" 
				+ "2. 성적 추가\n" 
				+ "3. 성적 수정\n" 
				+ "4. 성적 삭제\n" 
				+ "5. 이전으로\n"
				+ "메뉴 선택 : ");

	}

	private void runStrudentUpdateMenu(int menu) {
		switch(menu) {
		case 1:
			studentInfoUpdate();
			break;
		case 2:
			insertSubjectScore();
			break;
		case 3:
			updateSubjectScore();
			break;
		case 4:
			deleteSubjectScore();
			break;
		case 5:
			prev();
			break;
		default:
			defaultPrint();
		}
		
	}

	private void studentInfoUpdate() {
		//수정하려는 학년, 반, 번호를 입력
		/*
		//입력한 정보를 이용해서 학생 객체를 생성
		//=>indexOf 또는 contains등을 이용해서 객체를 쉽게 비교하기 위해서
		Student std = inputStudent();
		//생성한 학생객체를 이용해서 리스트에 몇번지에 있는지 번지룰 가져옴
		int index = list.indexOf(std);
		//번지가 유효하지 않은 번지이면 => 번지가 0보다 작으면 알림문구 출력 후 종료
		if (index < 0) {
			System.out.println("해당하는 정보가 없습니다.");
			return;
		}
		//유효한번지이면 수정할 학년, 반, 번호, 이름을 입력
		
		//위에서 입력한 학년, 반, 번호, 이름으로 객체 생성
		Student inputstd = inputStudentExpand();
		//수정할 객체를 리스트에서 번지에 있는 객체를 삭제해서 가져옴
		//=> 번지를 이용해서 삭제하면 삭제된 객체를 반환
		Student deletestd = list.remove(index);
		//생성한 객체가 리스트에 있는지 확인해서 있으면 알림문구 출력 후 종료
		for (Student tmp : list) {
			if(tmp.equals(inputstd)) {
				System.out.println("이미 등록되어있는 정보입니다.");
				return;
			}
		}
		//아니면 수정할 객체를 리스트에서 번지를 이용해서 가져옴
		Student updatestd = list.get(index);
		//가져온 객체의 update 메소드를 이용해서 학년, 반, 번호, 이름을 수정
		//update메소드는 Student 클래스에서 새로 추가해야 함
		updatestd.update();
		//리스트에 삭제되었던 객체를 추가
		list.add(deletestd);
		*/
		//---------------------------------------------
		//수정하려는 학년, 반, 번호를 입력
		//입력한 정보를 이용해서 학생 객체를 생성
		//=>indexOf 또는 contains등을 이용해서 객체를 쉽게 비교하기 위해서
		Student std = inputStudent();
		
		//생성한 학생객체를 이용해서 리스트에 몇번지에 있는지 번지룰 가져옴
		int index = list.indexOf(std);
		//번지가 유효하지 않은 번지이면 => 번지가 0보다 작으면 알림문구 출력 후 종료
		if(index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		//유효한번지이면 수정할 학년, 반, 번호, 이름을 입력
		//위에서 입력한 학년, 반, 번호, 이름으로 객체 생성
		Student newStudent = inputStudentExpand();
		
		std = list.remove(index);
		if (list.contains(newStudent)) {
			System.out.println("이미 등록된 학생 정보로 수정할 수 없습니다.");
			//삭제했던 학생 정보를 추가
			list.add(newStudent);
			return;
		}
		std.update(newStudent);
		list.add(std);
		//생성한 객체가 리스트에 있는지 확인해서 있으면 알림문구 출력 후 종료
		
		//아니면 수정할 객체를 리스트에서 번지를 이용해서 가져옴
		
		//가져온 객체의 update 메소드를 이용해서 학년, 반, 번호, 이름을 수정
		//update메소드는 Student 클래스에서 새로 추가해야 함
		
		//수정할 학생 객체를 번지를 통해 가져옴
	}

	private void insertSubjectScore() {
		//"등록된 과목이 없으면 알림문구 출력 후 종료"
		if(subjectlist.size() == 0) {
			System.out.println("등록된 과목이 없어서 추가할 수 없습니다. 과목을 등록해주세요.");
			return;
		}
		//학생 정보 입력(학년, 반, 번호)를 입력해서 학생 객체를 생성
		Student std = inputStudent();
		//리스트에 입력한 학생 객체가 몇번지에 있는지 번지를 가져옴
		int index = list.indexOf(std);
		//번지가 유효하지 않으면 안내문구 출력 후 종료
		if(index < 0) {
			System.out.println("목록에 없습니다.");
			return;
		}
		//리스트에서 번지에 있는 학생 정보를 가져옴
		std = list.get(index);
		//등록된 과목 리스트를 출력
		searchSubject();
		//학년, 학기, 과목명, 중간, 기말, 수행평가를 입력한 후 과목 객체를 생성
		Subject subject = inputSubject();
		
		//입력한 과목이 과목 리스트에 없으면 안내문구 출력 후 종료
		if (subjectlist.contains(subject.getName())){
			System.out.println("등록되지 않은 과목 입니다."
					+ "성적을 추가할 수 없습니다.");
			return;
		}
		
		
		//학생의 과목 리스트를 가져옴
		List<Subject>tmplist = std.getSubjectList();
		//학생의 과목 리스트에 생성한 과목 객체가 있으면 안내문구 출력 후 종료
		if(tmplist.contains(subject)) {
			System.out.println("과목 성적이 이미 등록되어 있습니다.");
			return;
		}
		
		//없으면 학생의 과목 리스트에 추가
		tmplist.add(subject);
		System.out.println("학생 성적을 등록했습니다");
	}

	private Subject inputSubject() {
		Subject subject = inputRequiredSubject();
		System.out.print("중간 : ");
		int mid = nextInt();
		System.out.print("기말 : ");
		int finals = nextInt();
		System.out.print("수행 : ");
		int performance = nextInt();
		subject.update(mid, finals, performance);
		return subject;
	}

	private void updateSubjectScore() {
		//학생 정보를 입력하여 객체를 생성
		Student std = inputStudent();
		//학생 리스트에서 학생 객체가 몇번지에 있는지 번지를 가져옴
		int index = list.indexOf(std);
		//번지가 유효하지 않으면 알림문구 출력 후 종료
		if (index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		//번지에 있는 학생 객체를 가져옴
		std = list.get(index);
		//학생의 과목 리스트를 가져옴
		List<Subject>Subjectlist = std.getSubjectList(); 
		//삭제할 과목, 학년, 학기 정보를 입력
		Subject subject = inputRequiredSubject();
		//과목이 과목리스트에 없으면 안내문구 출력 후 종료
		if (!subjectlist.contains(subject.getName())) {
			System.out.println("등록되지 않은 과목 성적입니다.");
			return;
		}
		
		//과목 객체가 학생 성적 리스트에 없으면 안내문구 출력 후 종료
		if (!Subjectlist.contains(subject)){
			System.out.println("등록되지 않은 과목 성적입니다.");
		}
		//중간, 기말, 수행평가를 입력
		System.out.print("중간 : ");
		int mid = nextInt();
		//중간, 기말, 수행평가를 입력
		System.out.print("기말 : ");
		int finals = nextInt();
		//중간, 기말, 수행평가를 입력
		System.out.print("수행평가 : ");
		int performance = nextInt();
		//과목 객체의 성적을 수정
		subject.update(mid, finals, performance);
		//제거하고 추가하는 이유는 이렇게 하지 않으면
		//subjectlist에서 해당 과목이 몇번에 있는지 확인해서 해당 과목 정보를 가져오고
		//성적을 수정해야하는데 번거롭기 때문에 아래와 같이 작성
		//리스트에서 과목 객체를 제거
		Subjectlist.remove(subject);
		//리스트에서 과목 객체를 추가
		Subjectlist.add(subject);
		System.out.println("과목 성적을 수정했습니다.");
	}

	private void deleteSubjectScore() {
		//학생 정보를 입력하여 객체를 생성
		Student std = inputStudent();
		//학생 리스트에서 학생 객체가 몇번지에 있는지 번지를 가져옴
		int index = list.indexOf(std);
		//번지가 유효하지 않으면 알림문구 출력 후 종료
		if (index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		//번지에 있는 학생 객체를 가져옴
		std = list.get(index);
		//학생의 과목 리스트를 가져옴
		List<Subject>Subjectlist = std.getSubjectList(); 
		//삭제할 과목, 학년, 학기 정보를 입력
		Subject subject = inputRequiredSubject();
		//과목이 과목리스트에 없으면 안내문구 출력 후 종료
		if (!subjectlist.contains(subject.getName())) {
			System.out.println("등록되지 않은 과목 성적입니다.");
			return;
		}
		//과목, 학년, 학기를 이용해서 객체를 생성
		//학생 과목 리스트에서 과목 객체를 삭제하여 성공하면 안내문구 출력 후 종료
		if (Subjectlist.remove(subject)) {
			System.out.println("삭제했습니다.");
			return;
		}
		//실패하면 안내문구 출력 후 종료
		System.out.println("등록되지 않은 과목 성적이어서 삭제할 수 없습니다.");
	}
	
	public Subject inputRequiredSubject() {
		System.out.print("과목 : ");
		scan.nextLine();
		String subjectName = scan.nextLine();
		System.out.print("학년 : ");
		int grade = nextInt();
		System.out.print("학기 : ");
		int semester = nextInt();
		return new Subject(subjectName, grade, semester, 0, 0, 0);
	}
	
	private void studentDelete() {
		// 학년, 반, 번호를 입력해서 학생 객체를 생성
		Student std = inputStudent();
		// 리스트에서 학생 객체를 삭제하고 삭제에 성공하면 알림문구 출력 후 종료
		if (list.remove(std)) {
			System.out.println("학생을 삭제했습니다.");
			System.out.println(list);
			return;
		}
		// 아ㄴ면 알림문구 출력
		System.out.println("일치하는 학생이 없습니다.");

	}

	private void studentSearch() {
		// 학년 반 번호를 입력 후 객체를 생성
		Student std = inputStudent();
		// 생성된 객체와 일치하는 객체를 가져옴
		// 리스트에서 객체와 일치하는 번지를 가져옴
		int index = list.indexOf(std);
		// 번지가 0보다 작으면 객체에 null을 저장
		if (index < 0) {
			std = null;
		}
		// 아니면 객체에 번지에 있는 객체를 가져옴
		else {
			std = list.get(index);
		}
		// 가져온 객체가 null이면 안내문구 출력 후 종료
		if (std == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		// null이 아니면 학생 정보를 출력
		std.print();
	}

	private void prev() {
		System.out.println("이전으로 돌아갑니다.");
	}

	private void subject() {
		
		int menu;
		do {
			printSubjectMenu();
			menu = nextInt();
			runSubjectMenu(menu);
		}while(menu != 5);
		
	}

	private void printSubjectMenu() {
		System.out.println("과목 관리 메뉴\n"
				+ "1. 과목 추가\n"
				+ "2. 과목 수정\n"
				+ "3. 과목 삭제\n"
				+ "4. 과목 확인\n"
				+ "5. 이전으로\n"
				+ "메뉴 선택 : ");
		
	}

	private void runSubjectMenu(int menu) {
		switch(menu) {
		case 1:
			insertSubject();
			break;
		case 2:
			updateSubject();
			break;
		case 3:
			deleteSubject();
			break;
		case 4:
			searchSubject();
			break;
		case 5:
			prev();
			break;
		default:
			defaultPrint();
		}
		
	}

	private void insertSubject() {
		//과목명을 입력
		System.out.print("과목명 : ");
		scan.nextLine();
		String subjectName = scan.nextLine();
		//과목 리스트에 등록된 과목인지 확인해서 등록되었으면 안내문구 출력 후 종료
		if(subjectlist.contains(subjectName)) {
			System.out.println("이미 등록된 과목입니다.");
		}
		//과목 리스트에 과목을 추가
		subjectlist.add(subjectName);
		System.out.println("과목을 추가했습니다.");
	}

	private void updateSubject() {
		//수정할 과목을 입력
		System.out.print("과목명 : ");
		scan.nextLine();
		String subjectName = scan.nextLine();
		//수정할 과목이 있는지 없는지 확인해서 없으면 알림 문구 출력후 종료
		if(!subjectlist.contains(subjectName)) {
			System.out.println("등록되지 않은 과목입니다.");
			return;  
		} 
		//새 과목명 입력
		System.out.print("새 과목명 입력 : ");
		String newsubjectName = scan.nextLine();
		//새 과목명이 이미 등록되어 있으면 안내문구 출력 후 종료
		if (subjectlist.contains(newsubjectName)) {
			System.out.println("등록된 과목으로 수정할 수 없습니다.");
			return;
		}
		//아니면 수정할 과목명 삭제
		subjectlist.remove(subjectName);
		//새 과목명 추가
		subjectlist.add(newsubjectName);
		System.out.println("과목을 수정했습니다.");
	}

	private void deleteSubject() {
		//삭제할 과목명을 입력
		System.out.print("삭제할 과목명 : ");
		scan.nextLine();
		String subjectName = scan.nextLine();
		//리스트에서 과목을 삭제해서 성공하면 알림문구 출력 후 종료
		if (subjectlist.remove(subjectName)) {
			System.out.println("삭제했습니다.");
			return;
		}
		//실패하면 알림문구 출력
		System.out.println("등록되지 않은 과목입니다.");
	}

	private void searchSubject() {
		System.out.println("과목 목록");
		for (String subject : subjectlist) {
			System.out.println(subject);
		}
		
	}

	private void defaultPrint() {
		System.out.println("올바른 메뉴를 선택하세요.");
	}

	private void exit() {
		System.out.println("프로그램을 종료합니다.");
	}

}
