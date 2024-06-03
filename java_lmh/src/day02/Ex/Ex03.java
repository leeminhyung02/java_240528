package day02.Ex;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		/*Scanner 클래스를 이용하여 정수로 된 돈의 액수를 입력받아
		 * 오만원권, 만원권, 천원권 몇장, 남은 잔액으로 변환되는지 출력하라.
		 */
		Scanner scan = new Scanner(System.in);
		System.out.print("금액을 입력하세요 : ");
		int cash = scan.nextInt();
		
		System.out.println(cash+"는\n" + "오만원권"+cash/50000+"장\n"+"만원권"+cash%50000/10000+"장\n"+"천원권"+cash%50000%10000/1000+"장");
		System.out.println("남은 잔액은 "+cash%50000%10000%1000+"원 입니다.");
	}

}
