package java_hotel.main;

import java.util.Scanner;

import java_hotel.controller.MemberController;
import java_hotel.model.vo.CustomerVO;

public class CustomerManager {
	private Scanner scanner = new Scanner(System.in);

	private MemberController memberController = new MemberController(scanner);
	private CustomerVO loginmember;

	public void run() {
		userMenu();
	}

	private void userMenu() {
		while (true) {
			System.out.println("사용자 메뉴");
			System.out.println("1. 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 뒤로가기");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				loginmember = memberController.userLogin();
				if (loginmember == null) {
					System.out.println("로그인 실패");
				} else {
					userLoggedInMenu();
				}
				break;
			case 2:
				userRegister();
				break;
			case 3:
				return;
			default:
				System.out.println("잘못된 선택입니다. 다시 시도하세요.");
			}
		}
	}

	private void userRegister() {
		if(memberController.userRegister()) {
			System.out.println("회원가입 성공");
		}else {
			System.out.println("회원가입 실패");
		}
		
	}

	private void userLoggedInMenu() {
		System.out.println(loginmember.getMb_name()+"님 환영합니다.");
		while (true) {
			System.out.println("사용자 메뉴");
			System.out.println("1. 예약");
			System.out.println("2. 회원정보");
			System.out.println("3. 로그아웃");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				userManageReservations();
				break;
			case 2:
				userManageInfo();
				break;
			case 3:
				return;
			default:
				System.out.println("잘못된 선택입니다. 다시 시도하세요.");
			}
		}
	}

	private void userManageReservations() {
		while (true) {
			System.out.println("예약");
			System.out.println("1. 예약");
			System.out.println("2. 예약확인");
			System.out.println("3. 예약수정");
			System.out.println("4. 예약취소");
			System.out.println("5. 뒤로가기");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				makeReservation();
				break;
			case 2:
				confirmReservation();
				break;
			case 3:
				modifyReservation();
				break;
			case 4:
				cancelReservation();
				break;
			case 5:
				return;
			default:
				System.out.println("잘못된 선택입니다. 다시 시도하세요.");
			}
		}
	}

	private void userManageInfo() {
		while (true) {
			System.out.println("회원정보");
			System.out.println("1. 회원정보");
			System.out.println("2. 회원정보 수정");
			System.out.println("3. 회원탈퇴");
			System.out.println("4. 뒤로가기");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				searchUserInfo();
				break;
			case 2:
				modifyUserInfo();
				break;
			case 3:
				deleteUserInfo();
				break;
			case 4:
				return;
			default:
				System.out.println("잘못된 선택입니다. 다시 시도하세요.");
			}
		}
	}

	private void searchUserInfo() {
		System.out.println(loginmember);
		System.out.println("넘어가려면 엔터를 눌러주세요.");
		scanner.nextLine();
	}

	private void modifyUserInfo() {
		System.out.print("아이디: ");
		String mb_id = scanner.nextLine();
		if(memberController.updatemember(mb_id, loginmember)) {
			System.out.println("수정 성공");
			loginmember = memberController.refresh(mb_id);
			return;
		} 
		System.out.println("수정 실패");
		return;
	}

	private void deleteUserInfo() {
		memberController.deleteMember(loginmember); 
		//실행 종료
		System.exit(0);
	}

	private void makeReservation() {
		// 예약 로직 추가
	}

	private void confirmReservation() {
		// 예약 확인 로직 추가
	}

	private void modifyReservation() {
		// 예약 수정 로직 추가
	}

	private void cancelReservation() {
		// 예약 취소 로직 추가
	}
}
