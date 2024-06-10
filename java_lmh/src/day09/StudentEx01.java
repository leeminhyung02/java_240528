package day09;

import java.awt.Checkbox;
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
		int check = 0;
		Student std[] = new Student[2];
		do {
			printMenu();
			menu = scan.nextInt();
			//runMenu(menu);
			switch (menu) {
				case 1: {
					if (count > std.length-1) {
						System.out.println("학생수가 다 찼습니다.");
						break;
					}
					System.out.print("학년 : ");
					int grade = scan.nextInt();
					System.out.print("반 : ");
					int classNum = scan.nextInt();
					System.out.print("번호 : ");
					int num = scan.nextInt();
					System.out.print("이름 : ");
					String name = scan.next(); 
					std[count] = new Student (grade, classNum, num, name);
					count++;
					break;
				}
				case 2:{
					//학년, 반, 번호를 입력받음
					System.out.print("학년 : ");
					int grade = scan.nextInt();
					System.out.print("반 : ");
					int classNum = scan.nextInt();
					System.out.print("번호 : ");
					int num = scan.nextInt();
					//입력받은 학년, 반, 번호를 이용하여 일치하는 학생이 있는지 확인
					int i = checknum(std, grade, classNum, num);
					if (i != -1) {
						System.out.print("국어 : ");
						int kor = scan.nextInt();
						System.out.print("영어 : ");
						int eng = scan.nextInt();
						System.out.print("수학 : ");
						int math = scan.nextInt();
						std[i].updateScore(kor, eng, math);
						System.out.println(std[i].getName()+" 의 성적을 수정했습니다.");
					}
					else {
						//없다면 일치하는 학생이 없다고 출력하고 종료
						System.out.println("일치하는 학생이 없습니다.");
					}
					break;
				}
				case 3:{
					//학년, 반, 번호를 입력
					System.out.print("학년 : ");
					int grade = scan.nextInt();
					System.out.print("반 : ");
					int classNum = scan.nextInt();
					System.out.print("번호 : ");
					int num = scan.nextInt();
					//입력받은 학년, 반, 번호를 이용하여 일치하는 학생이 있는지 확인
					int i = checknum(std, grade, classNum, num);
					if (i != -1) {
						System.out.println(std[i].getName()+"의 성적 :  ");
						System.out.print("국어 : "+std[i].getKor());
						System.out.print("  영어 : "+std[i].getEng());
						System.out.println("  수학 : "+std[i].getMath());
					}
					else {
						//없다면 일치하는 학생이 없다고 출력하고 종료	
						System.out.println("일치하는 학생이 없습니다.");
					}
					break;
				}
				case 4:{
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				default: {
					System.out.println("잘못된 메뉴입니다.");
				}
			check = 0;
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
	public static int checknum(Student std[],int grade, int classNum, int num) {
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
}