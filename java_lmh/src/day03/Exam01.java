package day03;

import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		// 성적을 입력받아 입력받은 성적이 60>= pass, 아니면 fail
		Scanner scan = new Scanner(System.in);
		System.out.print("성적 입력 : ");
		int result = scan.nextInt();
		String str = (result>=60)? "Pass":"Fail";
		System.out.println(result+"점은	"+str);
	}

}
