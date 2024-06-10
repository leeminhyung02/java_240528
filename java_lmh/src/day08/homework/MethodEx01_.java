package day08.homework;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx01_ {
	/*정수 n을 입력받아 입력받은 n크기를 가지는 배열을 생성하는 코드를 작성하세요
	 * 메서드를 이용
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("입력 :");
		int input = scan.nextInt();
		int list[] =arrlength(input);
		System.out.println(Arrays.toString(list));
	}
	/**기능 : 정수를 입력받은 정수 n 을 크기로 하는 배열을 반환
	 *  매개변수 : int n
	 *  리턴타입 :int[]
	 *  메서드명 :arrlength
	 */
	public static int[] arrlength(int n) {
		int arr[] = new int[n];
		return arr;
	}
}
