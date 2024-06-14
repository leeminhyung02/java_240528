package day08.homework;

import java.util.Arrays;

public class MethodEx3_ {
	/*
	 * 배열에 랜덤으로 1~9사이의 중복되지 않은 배열을 생성하고 콘솔에 출력하는 코드를 작성하세요
	 * 단 메서드 이용
	 */
	// homework.MethodEx01, homework.MethodEx02, day08.MethodEx05를 합친 예제

	public static void main(String[] args) {
		int size = 3, min = 1, max = 4;
		int [] arr = createRandomArray(size, min, max);
		System.out.println(Arrays.toString(arr));
		
	}
	public static int [] createArray(int size) {
		if (size < 0) {
			return null; 
		}
		return new int[size];
	}
	/**기능 : 정수를 입력받은 정수 n 을 크기로 하는 배열을 반환
	 *  매개변수 : int n
	 *  리턴타입 :int[]
	 *  메서드명 :arrlength
	 */
	
	public static boolean contains(int [] arr, int count, int num) {
		//배열이 null인 경우
		if (arr == null) {
			return false;
		}
		//count가 배열의 크기보다 큰 경우
		if (count > arr.length) {
			count = arr.length;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	public static int [] createRandomArray(int size, int min, int max) {
		if (size < 0) {
			return null;
		}
		//랜덤 숫자의 범위가 배열의 크기보다 작은 경우
		//랜덤 번위가 1~9, 크기가 20
		if (size > max -min +1) {
			return null;
		}
		if (min > max) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		int count = 0; //저장된 숫자의 개수
		return null;
		/*
		while(count < size) {
			int random = (int) (Math.random() * (max - min + 1) + min);
			if (!contains(arr,count,random)) {
				arr[count] = random;
				count++;
			}
		}
		
		return arr;
		*/
	}
}
