package day24;

public class Ex01 {

	public static void main(String[] args) {
		
		int num1 = 4;
		double num2 = num1;
		
		/*에러발생
		 * 원인 :실수형 타입을 정수형으로 바꿔서
		 * 해결 방법 : num2앞에 형변환사용 (int)/실수형 변수에 저장
		 * 
		 */
		int num3 = (int)num2;
	}
}
