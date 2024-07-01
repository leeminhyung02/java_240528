package day24;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		/*
		 * 문자열을 입력받아 exit가 아니면 입력한 문자열을 출력하고, exit이면 종료하는 코드를 작성하려고 했다
		 * 원인 :
		 * 	1. res가 false라 while문이 항상 작동안함
		 * 	2. 문자열을 비교할때는 ==을 사용하면 안됨
		 *	3. continue 는 해당반복문을 나가는 명령어가 아님
		 * 해결 방법:
		 * 	1. res -> true
		 * 	2. str.equals() 사용
		 * 	3. break 사용
		 */
		Scanner scan = new Scanner(System.in);
		boolean res = false;
		while(res) {
			System.out.println("문자열 입력 : ");
			String str = scan.next();
			if(str == "exit") {
				continue;
			}
			System.out.println(str);
		}
	}

}
