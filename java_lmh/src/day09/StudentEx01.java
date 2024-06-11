package day09;

import java.util.Scanner;

public class StudentEx01 {
	/*
	 * 학생 성적을 관리하기 위한 프로그램  국어, 영어 , 수학
	 */
	/*
	 * 다음 메뉴가 출력되도록 코드를 작성하세요.
	 * 메뉴
	 * 1. 학생 등록
	 * 2. 성적 수정
	 * 3. 성적 확인
	 * 4. 종료
	 * 메뉴 선택 : 
	 * 
	 * 메뉴를 출력하고 메뉴를 콘솔창에서 입력받는 코드를 작성하세요
	 * 단, 입력받은 메뉴가 4가 아니면 반복하도록 작성하세요.
	 */
	/*3. 입력한 메뉴가 1이면 학생 등록 입니다. 2이면 성적수정입니다. 3이면 성적확인입니다. 4이면 프로그램을 종료합니다. 
	 * 라고 출력하도록 코드를작성하세요*/
	/*
	 * 프로그램 관리를 위한 Student 클래스를 추가하세요.
	 * - 학년, 반, 번호, 이름, 국어, 영어, 수학
	 * 	멤버 변수는 private 으로 하고 getter/setter 를 추가
	 * 	기본 생성자와 학년,반,번호,이름을 이용한 생성자를 추가
	 * 	국어, 영어,수학 성적을 변경하는 기능을 추가
	 */
	/*
	 * 5. 학생 등록 기능을 구현하세요
	 *  학년, 반, 번호, 이름을 입력받아 학생을 추가하세요
	 */
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int menu;
		//학생 배열
		int count = 0;
		Student std[] = new Student[10];
		int grade;
		int classNum;
		int num;
		Student tmp;
		do {
			printMenu();
			menu = scan.nextInt();
			//runMenu(menu);
			switch (menu) {
				case 1: {
					count = insertStudent(std, scan, count);
					break;
				}
				case 2:{
					updateStudent(std, count, scan);
					break;
				}
				case 3:{
					printStudent(std, count, scan);
					break;
				}
				case 4:{
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				default: {
					System.out.println("잘못된 메뉴입니다.");
				}
			}
		}while (menu != 4);
	}
	/**기능 : 메뉴를 출력하는 메소드  */
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 등록");
		System.out.println("2. 성적 수정");
		System.out.println("3. 성적 확인");
		System.out.println("4. 종료");
		System.out.print("메뉴 선택 :  ");
	}
	/**기능 : 메뉴에 맞는 기능을 실행하는 메소드
	 * @param menu 실행할 메뉴
	 * 
	 */
	public static void runMenu(int menu) {

		switch (menu) {
		case 1: {
			System.out.println("학생 등록 입니다.");
			break;
		}
		case 2:{
			System.out.println("성적 수정 입니다.");
			break;
		}
		case 3:{
			System.out.println("성적 확인 입니다.");
			break;
		}
		case 4:{
			System.out.println("프로그램을 종료합니다.");
			break;
		}
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
	
	/**  기능 : 학년,반,번호가 맞는지 체크하고 맞으면 해당 index 반환, 아니면 -1 반환
	 * 
	 * @param std
	 * @param grade
	 * @param classNum
	 * @param num
	 * @return
	 */
	public static int indexOf(Student std[],int grade, int classNum, int num) {
		for (int i = 0; i < std.length; i++) {
			if(std[i] == null) {
				return -1;
			}
			if(std[i].getGrade() == grade && std[i].getClassNum() == classNum && std[i].getNum() == num) {
			return i;
		}
	}
		return -1;
	}
	
	/**
	 * 					System.out.print("학년 : ");
					int grade = scan.nextInt();
					System.out.print("반 : ");
					int classNum = scan.nextInt();
					System.out.print("번호 : ");
					int num = scan.nextInt();
	 */
	/** 기능 : 학생 배열과 검색할
	 * 
	 */
	public static int indexOf2(Student list[],Student std,int count) {
		if (list == null || std == null) {
			return -1;
		}
		for (int i = 0; i <count; i++) {
			if(std.getGrade() != list[i].getGrade()) {
				continue;
			}
			if(std.getClassNum() != list[i].getClassNum()) {
				continue;
			}
			if(std.getNum() != list[i].getNum()) {
				continue;
			}
			return i;
		}
		return -1;
	}
	/** 기능 : 학생 정보를 입력받아 학생 객체로 알려주는 메소드
	 * @param scan 콘솔에서 입력받기 이ㅜ한 scanner
	 *  @return 입력받은 학생 정보를 이용하여 생성한 학생 객체
	 */
	public static Student inputStudent(Scanner scan) {
		System.out.print("학년 : ");
		int grade = scan.nextInt();
		System.out.print("반 : ");
		int classNum = scan.nextInt();
		System.out.print("번호 : ");
		int num = scan.nextInt();
		return new Student(grade,classNum,num, "");
	}
	/** 기능 :  학생 정보를 입력받아 학생리스트에 추가하고 등록된 학생 숫자를 알려주는 메소드
	 * @param std 학생리스트
	 * @param scan 학생 정보를 입력받기 위한 Scanner
	 * @param count 현재 학생 숫자
	 * @return 등록된 학생 숫자
	 * */

	public static int insertStudent(Student [] std, Scanner scan, int count) {
		if (count > std.length-1) {
			System.out.println("학생수가 다 찼습니다.");
			return count;
		}
		Student tmp = inputStudent(scan);
		System.out.print("이름 : ");
		String name = scan.next();
		tmp.setName(name);
		int index = indexOf2(std,tmp,count);
		if(index != -1) {
			System.out.println("이미 등록된 학생입니다.");
			return count;
		}
		std[count] = tmp;
		return count+1;
	}
	/**기ㅡㄴㅇ : 학생 리스트에 있는 학생 정보에서 성적을 수정하는 메소드
	 * @param std 학생리스트
	 * @param count 등록된 학생 숫자
	 * @param scan 콘솔에서 입력받기 위한 Scanner
	 * 
	 */
	public static void updateStudent(Student[] std, int count, Scanner scan) {
		Student tmp = inputStudent(scan);
		int index = indexOf2(std, tmp, count);
		if (index == -1) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.print("국어 : ");
		int kor = scan.nextInt();
		System.out.print("영어 : ");
		int eng = scan.nextInt();
		System.out.print("수학 : ");
		int math = scan.nextInt();
		std[index].updateScore(kor, eng, math);
		System.out.println(std[index].getName()+" 의 성적을 수정했습니다.");
		std[index].print();
	}
	
	/**기능 : 학생 리스트에서 학생 정보를 검색해서 출력하는 메소드
	 *  @param list
	 *  @param count
	 *  @param scan
	 * 
	 * 
	 */
	public static void printStudent(Student[] std, int count, Scanner scan) {
		Student tmp = inputStudent(scan);
		int index = indexOf2(std,tmp,count);
		if(index == -1) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		std[index].print();
	}
	
	
	
	
	
}



class Student {
	private int grade, classNum, num;
	private String name;
	private int kor, eng, math;
	//getters/setters
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}

	public Student(int grade, int classNum, int num, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.num = num;
		this.name = name;
	}
	public Student() {
	
	}
	/**기능 : 국어, 영어, 수학 성적이 주어지면 변경하는 메소드
	 * 
	 * @param kor 국어 성적
	 * @param eng 영어 성적
	 * @param math 수학 성적
	 */
	public void updateScore(int kor, int eng, int math) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	/**기능 : 학생 정보를 콘솔에 출력하는 메소드
	 * 
	 */
	public void print() {
		System.out.println(grade+"학년"+classNum+"반"+num+"번"+name);
		System.out.println("국어 :  "+kor+" 영어 :  "+eng+" 수학 :  "+math);
	}
}