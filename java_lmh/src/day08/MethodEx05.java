package day08;


public class MethodEx05 {

	public static void main(String[] args) {
		/* 정수 배열이 주어지고 주어진 배열에 원하는 정수가 있는지 없는지 확인하는 코드 
		 */
		
		int []arr = new int[] {1,3,5,7,9};
		int num = 1;
		if (contains(num,arr)) {
			System.out.println("있음");
		}
		else {
			System.out.println("없음");
		}
	}
	/**	정수 배열이 주어지면 배열에 정수 input이 있는지 없는지 알려주는 메서드
	 *  매개변수 :int input, int arr[]
	 *  리턴 타입 : boolean
	 *  메서드명 : contains
	 * @param input 입력받은 값
	 * @param arr 주어진 배열
	 * @return 입력받은 값이 배열에 있는지 없는지
	 */
	public static boolean contains(int input, int arr[]) {
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
}
