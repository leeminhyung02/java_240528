package day03;

import java.util.Scanner;

public class IfExam01 {

	public static void main(String[] args) {
		// 나이를 입력받고 19>=이면 성인, 20< 이면 미성년자 
		Scanner scan = new Scanner(System.in);
		System.out.print("나이 : ");
		int age = scan.nextInt();
		if (age >=19) {
			System.out.println("성인");
		}
		else if(age <19) {
			System.out.println("미성년자");
		}

	}

}
