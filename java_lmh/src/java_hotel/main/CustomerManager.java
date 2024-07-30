package javehotel.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javehotel.controller.MemberController;
import javehotel.model.vo.CustomerVO;

public class CustomerManager {
	private Scanner scanner = new Scanner(System.in);

	private MemberController memberController = new MemberController(scanner);

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
                    userLogin();
                    break;
                case 2:
                    memberController.userRegister();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    private void userLogin() {
        System.out.print("아이디: ");
        String userId = scanner.nextLine();
        System.out.print("비밀번호: ");
        String userPw = scanner.nextLine();

        for (CustomerVO customer : customers) {
            if (customer.getUserId().equals(userId) && customer.getUserPw().equals(userPw)) {
                System.out.println("로그인 성공!");
                userLoggedInMenu();
                return;
            }
        }
        System.out.println("아이디 또는 비밀번호가 잘못되었습니다.");
    }

    private void userRegister() {
        System.out.print("아이디: ");
        String userId = scanner.nextLine();
        
        if(isUserIdTaken(userId)) {
        	System.out.println("이미 존재하는 Id입니다.");
        	return;
        }
        
        System.out.print("비밀번호: ");
        String userPw = scanner.nextLine();
        System.out.print("이름: ");
        String name = scanner.nextLine();
        System.out.print("전화번호: ");
        String phoneNumber = scanner.nextLine();

        CustomerVO newCustomer = new CustomerVO(userId, userPw, name, phoneNumber);
        customers.add(newCustomer);
        System.out.println("회원가입 성공!");
    }
    
   

    private boolean isUserIdTaken(String userId) {
    	for(CustomerVO customer : customers) {
    		if(customer.getUserId().equals(userId)) {
    			return true;
    		}
    	}
		return false;
	}

	private void userLoggedInMenu() {
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
        System.out.print("검색 (아이디 비밀번호): ");
        String userId = scanner.nextLine();
        String userPw = scanner.nextLine();
        // 검색 로직 추가
        System.out.println("검색 결과:");
        // 결과 출력 로직 추가
    }

    private void modifyUserInfo() {
        System.out.print("검색 (아이디 비밀번호): ");
        String userId = scanner.nextLine();
        String userPw = scanner.nextLine();
        // 검색 로직 추가
        // 수정 로직 추가
    }

    private void deleteUserInfo() {
        System.out.print("검색 (아이디 비밀번호): ");
        String userId = scanner.nextLine();
        String userPw = scanner.nextLine();
        // 검색 로직 추가
        System.out.print("탈퇴 여부 (y/n): ");
        String confirm = scanner.nextLine();
        if ("y".equalsIgnoreCase(confirm)) {
            // 탈퇴 로직 추가
        }
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

