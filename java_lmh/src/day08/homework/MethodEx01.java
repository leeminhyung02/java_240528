package day08.homework;

import java.util.Arrays;
import java.util.Scanner;

public class MethodEx01 {
	/*정수 n을 입력받아 입력받은 n크기를 가지는 배열을 생성하는 코드를 작성하세요
	 * 메서드를 이용
	 */
	public static void main(String[] args) {
		System.out.print("배열 크기 입력 :");
		Scanner scan = new Scanner(System.in);
		int size = scan.nextInt();
		int [] arr = createArray(size);
		System.out.println(Arrays.toString(arr));
	}
	/** 기능 : 배열의 크기가 주어지면 주어진 배열 크기의 정수 배열을 생성해서 알려주는 메서드
	 * 매개변수 : 배열 크기 = >int size
	 * 리턴타입 : 생성된 정수 배열 = > int[]
	 * 메서드명 : createArray
	 */
	public static int [] createArray(int size) {
		if (size < 0) {
			return null;
		}
		return new int[size];
	}
}
