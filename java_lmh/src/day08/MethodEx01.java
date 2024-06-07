package day08;

public class MethodEx01 {
	/*
	 * 주어진 정수 num3가 소수인지 아닌지 판별하는 코드를 작성하세요
	 * 단, 메서드를 이용해서
	 */
	public static void main(String[] args) {
		//num가 소수인지 판별하는 코드
		/*
		int num = 7;
		
		boolean result = primenum(num);
		if (result == true) {
			System.out.println(num+"은 소수");
		}
		else {
			System.out.println(num+"은 소수 아님");
		}
		*/
		//100이하의 소수를 판별하는 코드를 작성하세요. isPrime을 이용
		for (int i = 1; i <= 100; i++) {
			if (isPrime(i)) {
				System.out.print(i+"  ");
			}
		}
	}
	/*
	 * 정수를 받으면 소수인지 판별하고 T/F로 리턴
	 * 매개변수 : 정수 int num
	 * 리턴타입 : boolean
	 * 메서드명 : primenum
	 */
	public static boolean primenum(int num) {
		int count = 0;
		boolean a;
		for (int i = 1; i <=num;i++ ) {
			if (num % i == 0) {
				count++;
			}
			i++;
		}
		if (count == 2) {
			a = true;
		}
		else {
			a = false;
		}
		return a;
	}
	public static boolean isPrime(int num) {
		int count = 0;
		for (int i = 1; i <=num; i++) {
			if(num% i == 0) {
				count++;
			}
		}
		if(count ==2) {
			return true;
		}
		return false;
	}
	public static boolean isPrime2(int num) {
		if (num == 1) {
			return false;
		}
		//1과 자기자신을 제외한 수 중에서 약수를 반복문을 이용하여 찾음
		for(int i   = 2; i < num; i++) {
			//1과 자기자신을 제외한 수 중에서 약수가 있으면
			if (num % i == 0) {
				//소수가 아님
				return false;
			}
		}
		//반복문이 끝날때까지 약수를 못 찾았다 => 약수가 1과 자기자신 뿐이다 => 소수이다
		return true;
	}
}
