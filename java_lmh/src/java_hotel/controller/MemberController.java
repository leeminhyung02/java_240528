package java_hotel.controller;

import java.util.Scanner;

import java_hotel.model.vo.CustomerVO;
import java_hotel.service.MemberServiceImp;

public class MemberController {

	private MemberServiceImp memberService = new MemberServiceImp();
	private Scanner scanner;

	public MemberController(Scanner scan) {
		this.scanner = scan;
	}

	public void userRegister() {

		CustomerVO cus = inputMember();

		if (memberService.insertMember(cus)) {
			System.out.println("회원가입이 완료되었습니다.");

		} else {
			System.out.println("이미 등록된 회원 정보이어서 추가하지 못했습니다.");
		}
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
		return new CustomerVO(mb_id, mb_name, mb_password, mb_email, false);
	}

	private CustomerVO inputidpwmember() {
		System.out.print("아이디: ");
		String mb_id = scanner.nextLine();
		System.out.print("비밀번호: ");
		String mb_password = scanner.nextLine();
		CustomerVO cus = new CustomerVO();
		cus.setMb_id(mb_id);
		cus.setMb_password(mb_password);
		return cus;
	}

	public CustomerVO userLogin() {
		CustomerVO cus = inputidpwmember();
		if (memberService.loginmember(cus)) {
			return cus;
		}
		return null;
	}

	public void searchUser() { // 아이디로 검색
		System.out.print("검색 (아이디): ");
		String mb_id = scanner.nextLine();
		CustomerVO cus = new CustomerVO();
		cus.setMb_id(mb_id);
		memberService.searchmember(cus);
	}

	public void updateuser() {
		CustomerVO cus = inputidpwmember();
		if (!memberService.contains(cus)) {
			System.out.println("일치하는 회원이 없습니다.");
			return;
		}
		CustomerVO newCustomer = inputMember();
		if (memberService.updatemember(cus, newCustomer)) {
			System.out.println("회원 정보를 수정했습니다.");
			return;
		}
		System.out.println("이미 등록된 회원 정보로 수정할 수 없습니다.");
	}

	public void deleteUser() {
		CustomerVO cus = inputidpwmember();
		if (!memberService.contains(cus)) {
			System.out.println("일치하는 회원이 없습니다.");
			return;
		}
		System.out.println("정말로 계정을 삭제하시겠습니까? (Y/N)");
		if (scanner.next() != "Y") {
			System.out.println("계정 삭제를 취소합니다.");
			return;
		}
		memberService.deleteMember(cus);

	}

}
