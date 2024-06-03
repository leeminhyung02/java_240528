package day05;

import java.util.Scanner;

public class ArrayEx04 {

	public static void main(String[] args) {
		/* 3개의 정수를 입력을 받아 배열에 저장하고, 역순으로 출력하는 코드를 작성하세요
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		int arr[] = new int[3];
		for (int i = 0; i < arr.length; i++) {
			System.out.print("정수 입력 :");
			arr[i] = scan.nextInt();
		}
		//역순으로 출력
		for (int i = arr.length-1; i>=0; i --) {
			System.out.print(arr[i]+ "   ");
		}
		/*역순 출력
		for ( int i = 0; i < arr.length; i ++) {
			System.out.print(arr[arr.length-i-1]+"  ");
		}
		*/	
		//
	}
}
