package day06;

public class ArrayEx03 {

	public static void main(String[] args) {
		/*
		 * 2단의 결과값인 2,4,6,8,10...18을 배열에 저장하고 
		 * 배열에 있는 값을 이용하여 구구단 2단을 출력하는 예제
		 */

		int[] arr = new int[9];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (i + 1) * 2;
			System.out.println("2 X " + (i + 1) + " = " + arr[i]);
		}
		/*for (int i = 0; i < arr.length; i++ ) {
		*	arr[i] =  2* ( i + 1 );
		*}
		*
		*배열에 있는 값을 이용하여 2단을 출력	
		*for (int i = 0; i < arr.length; i++ ) {
		*	System.out.println("2 X " + (i + 1) + " = " + arr[i]);
		*}
		*/
		//10개짜리 배열을 만들어서 0번지를 사용하지 않고 1번지부터 사용
		int arr2[] = new int[10];
		for(int i = 1; i< arr2.length; i++) {
			arr2[i] = i*2;
			System.out.println("2 X "+i+" = "+arr2[i]);
		}
	}

}
