package java_hotel.controller;

import java.util.Scanner;

import java_hotel.model.vo.CustomerVO;
import java_hotel.service.MemberService;
import java_hotel.service.MemberServiceImp;

public class MemberController {

	private MemberService memberService = new MemberServiceImp();
	private Scanner scanner;

	public MemberController(Scanner scan) {
		this.scanner = scan;
	}

	public boolean userRegister() {

		System.out.print("아이디: ");
		String mb_id = scanner.nextLine();
		System.out.print("비밀번호: ");
		String mb_password = scanner.nextLine();
		System.out.print("이름: ");
		String mb_name = scanner.nextLine();
		System.out.print("이메일: ");
		String mb_email = scanner.nextLine();
		return memberService.Register(mb_id, mb_password, mb_name, mb_email);
	}



	public CustomerVO userLogin() {
		System.out.print("아이디: ");
		String mb_id = scanner.nextLine();
		System.out.print("비밀번호: ");
		String mb_password = scanner.nextLine();
		CustomerVO user = memberService.loginmember(mb_id, mb_password);
		return user;
	}

	public boolean updatemember(String mb_id, CustomerVO loginmember) {

		System.out.print("비밀번호: ");
		String mb_password = scanner.nextLine();
		System.out.print("이름: ");
		String mb_name = scanner.nextLine();
		System.out.print("이메일: ");
		String mb_email = scanner.nextLine();
		CustomerVO newUser = new CustomerVO(mb_id, mb_name, mb_password, mb_email);
		return memberService.update(loginmember, newUser);
	}

	public CustomerVO refresh(String mb_id) {
		return memberService.refresh(mb_id);
	}

	public void deleteMember(CustomerVO loginmember) {
		System.out.println("정말로 탈퇴하시겠습니까? (Y | N)");
		char input = scanner.next().charAt(0);
		if(input == 'y' || input == 'Y') {
			if(memberService.deleteMember(loginmember)) {
				System.out.println("회원탈퇴를 완료했습니다.");
				return;
			}
			System.out.println("탈퇴 실패");
		}
	}



}
