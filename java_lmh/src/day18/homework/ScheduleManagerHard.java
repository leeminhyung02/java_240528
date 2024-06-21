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

public class ScheduleManagerHard implements Program{
	private List <Member> member = new ArrayList<Member>();
	
	private Scanner scan = new Scanner(System.in);
		
	private final int MAINMEMBER = 1;
	private final int MAINSH = 2;
	private final int MAINEXIT = 3;
	
	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE= 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;
	
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
		switch () {
		case value: {
			
			yield type;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	


}
