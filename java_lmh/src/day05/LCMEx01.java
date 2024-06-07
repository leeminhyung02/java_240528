package day05;

public class LCMEx01 {

	public static void main(String[] args) {
		/* 두 정수의 최소 공배수를 구하는 코드를 작성하세요.
		 *  A의 배수 B: B를 A로 나누었을 때 나머지가 0인 B를 A의 배수라고 표현
		 *  6의 배수 :6, 12, 18, 24....
		 *  8의 배수 :8, 16, 24, 32....
		 *  공배수 : 두 수의 배수중 공통으로 있는 수
		 *  6 ,8 의 공배수는 24, 48,72....
		 *  최소 공배수는 두 수의 공배수중 가장 작은 수
		 *  6,8 의 최소공배수는 24
		 */
		int num1 = 111, num2 = 30000;
		for(int i = 1; ;  i++) {
			if(i % num1 == 0 && i % num2 == 0 ) {
				System.out.println(""+num1+"과 "+num2+"의 최소 공배수는 "+i+"입니다." );
				break;
			}
		}
		/*반복횟수 : i는 num1부터 무한대까지 num1씩 증가 (num1의 배수)
		 * 규칙성 : i는 num2의 배수이면 i를 출력하고 반복문 종료
		 * 반복문 종료 후 :
		 * 
		 */ 
		
		//num1이 num2보다 작으면 num1과 num2를 바꾸는 코드
		int tmp;
		if (num1 <num2) {
			tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		for (int i = num1; ; i+=num1) {
			if(i % num2 == 0) {
				System.out.println(""+num1+"과 "+num2+"의 최소 공배수는 "+i+"입니다." );
				break;
			}
		}
	}

}
