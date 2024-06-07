package day08.homework;

import java.util.Arrays;

public class MethodEx03 {
	/*
	 * 배열에 랜덤으로 1~9사이의 중복되지 않은 배열을 생성하고 콘솔에 출력하는 코드를 작성하세요
	 * 단 메서드 이용
	 */
	// homework.MethodEx01, homework.MethodEx02, day08.MethodEx05를 합친 예제

	public static void main(String[] args) {
		//배열을 생성
		int list[] = null;
		//최대 9
		list = arrlength(5);
		
		//배열에 랜덤수 입력
		int min = 1, max = 9;
		list = randarr(list, min, max);
		System.out.println(Arrays.toString(list));
		//배열의 원소가 중복이 아닐때 까지 확인 변경
		int count = 0;  
		int i = 0;
		while (count < 3) {
			int random = (int) (Math.random() * (max - min + 1) + min);
			for (i = 0; i < count; i++) {
				if (arr[i] == random) {
					break;
				}
			}
			if (i == count) {
				arr[count] = random;
				count++;
			}
		}
		
		//중복이 아니면 콘솔에 출력
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
	/**기능 : 1~9사이의 랜덤한 수를 배열에 저장
	 *  매개변수 : 배열, 랜덤수의 최대, 최소 값
	 *  리턴타입 :int[]
	 *  메서드명 :randarr
	 */
	public static int[] randarr(int arr[],int min, int max) {
		for ( int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * (max - min + 1) + min);
		}
		return arr;
	}
	// 랜덤한 수 반환
	//  @randint(최소 , 최대)
	public static int randint(int min, int max) {
		return (int) (Math.random() * (max - min + 1) + min);
	}
	/**	정수 배열이 주어지면 배열에 정수 input이 있는지 없는지 알려주는 메서드
	 *  매개변수 :int input, int arr[]
	 *  리턴 타입 : boolean
	 *  메서드명 : contains
	 * @param input 입력받은 값
	 * @param arr 주어진 배열
	 * @return 입력받은 값이 배열에 있는지 없는지
	 */
	public static boolean contains(int arr[], int input) {
		if (arr == null) {
			return false;
		}
		for (int tmp : arr) {
			if (input == tmp) {
				return true;
			}
		}
		return false;
	}
	/** 배열의 원소 값 바꾸기
	 * 	매개변수 배열 , 번지수, 바꿀 값
	 * 	리턴타입 :배열
	 *    메서드명 @changearr
	 */
	public static int[] changearr(int[] arr, int index, int n) {
		arr[index] = n;
		return arr;
	}
}
