package day06;

public class ArrayEx05 {

	public static void main(String[] args) {
		// 100이하의 소수를 찾는 예제 : 에라토스테네스의 체
		// 1(x) 2 3 4(x) 5 6(x) 7 8(x) 9(x) 10(x)
		// x : 1, o :0
		final int len = 101;
		int arr[] = new int[len];
		arr[1] = 1;

		for (int i = 2; i < arr.length; i++) {
			// 2부터 에라토스테네스의 체를 이용하여 배열에 X 체크
			if (arr[i] == 0) {
				for (int j = 2; i * j <=arr.length-1; j++) {
					arr[i * j] = 1;
				}
			}
			// 2부터 100까지 x체크 안된 수(값이 0 인 수)를 출력
		}
		int l = 0;
		for (int k = 2; k <= arr.length - 1; k++) {
			if (arr[k] == 0) {
				if (l % 10 == 0) {
					System.out.println();
				}
				System.out.print(k + "  ");
				l++;

			}
		}

	}

}
