package day08;

public class MethodEx02 {

	public static void main(String[] args) {
		/*
		 * 두 수의 최대 공약수와 최소 공배수를 구하는 코드를 작성하세요.
		 */
		System.out.println(GCD(10,20));
		System.out.println(LCM(2,3));
	}
	//최대 공약수를 구하는 메서드
	/*리턴타입	int
	 * 매개변수  int num1,int num2
	 */
	public static int GCD(int num1,int num2) {
		int result;
		int tmp;
		if (num1 > num2) {
			tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		for (int i = num2; ; i--) {
			if (num1 % i == 0 && num2 % i == 0) {
				result = i;
				break;
			}
		}
		
		return result;
	}
	//최소 공배수를 구하는 메서드
	/*리턴타입	int
	 * 매개변수  int num1,int num2
	 */
	public static int LCM(int num1,int num2) {
		int result;
		for(int i = 1; ;  i++) {
			if(i % num1 == 0 && i % num2 == 0 ) {
				result = i;
				break;
			}
		}
		return result;
	}
}
