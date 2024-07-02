package day24;

public class Ex12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1+2의 결과를 출력하기위해 다음같이 작성했다
		 * 원인 :sum 메소드는 리턴타입이 void임
		 * 결과 :메소드의 리턴타입을 바꾸거나 int res 없이 단독으로 실행
		 */
		sum(1,2);
	}
	public static void sum(int num1, int num2) {
		System.out.println(num1+num2);
	}
}
