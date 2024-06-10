package day08.homework;

import java.util.Arrays;

public class MethodEx02 {
	/* 1~9사이의 랜덤한 수를 배열에 저장하여 콘솔에 출력하는 코드를 작성하세요
	 * 메서드 이용*/
	public static void main(String[] args) {
		int arr[] = new int[10];
		System.out.println(Arrays.toString(randarr(arr,1,10)));
		
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = randint(1, 10);
		}
		System.out.println(Arrays.toString(arr));
	}
	/**기능 : 1~9사이의 랜덤한 수를 배열에 저장
	 *  매개변수 : 배열, 랜덤수의 최대, 최소 값
	 *  리턴타입 :@int[]
	 *  메서드명 :@randarr
	 */
	public static int[] randarr(int arr[],int min, int max) {
		for ( int i = 0; i < arr.length; i++) {
			arr[i] = randint(min,max);
		}
		return arr;
	}
	
	// min~max 사이의 랜덤한 수 반환(정수)
	public static int randint(int min, int max) {
		if(min>max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int) (Math.random() * (max - min + 1) + min);
	}
}
