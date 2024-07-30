package java_hotel.controller;

import java.util.Scanner;

import java_hotel.service.MemberServiceImp;

public class MemberController {

	private MemberServiceImp memberService = new MemberServiceImp();
	private Scanner scanner;

	public MemberController(Scanner scan) {
		this.scanner = scan;
	}

	public void userRegister() {
		
		CustomerVO cus =  inputMember();

		
	}
	public CustomerVO inputMember() {
	        System.out.print("아이디: ");
	        String mb_id = scanner.nextLine();
	        System.out.print("비밀번호: ");
	        String mb_password = scanner.nextLine();
	        System.out.print("이름: ");
	        String mb_name = scanner.nextLine();
	        System.out.print("이메일: ");
	        String mb_email = scanner.nextLine();
	        CustomerVO cus = new CustomerVO();
	        return new CustomerVO(mb_id,mb_name,mb_password,mb_email,false);
	}
	
}
