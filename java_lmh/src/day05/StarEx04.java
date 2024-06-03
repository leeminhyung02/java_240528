package day05;

public class StarEx04 {

	public static void main(String[] args) {
	/* *을 하나씩 출력해서 다음과 같이 출력되도록 중첩 반복문을 이용해서  작성하세요.
	 *                *
	 *              ***
	 *            *****
	 *          *******
	 *        *********
	 *        반복 횟수 :i는 1부터 5까지 1씩 증가
	 *        규칙성 :  공백을 5-i 개 출력하고 *을 i개 출력 후 엔터
	 *        					=> 반복 횟수 : j = 1부터 5-i 까지 1씩 증가
	 *        					     규칙성 : 공백을 출력
	 *        					     반복문 종료후 : 없음
	 *        					=> 반복횟수 : j는 1부터 ?까지 1씩 증가
	 *        					     규칙성 : *을 출력
	 *        					     반복문 종료 후 : 엔터 출력
	 */
		for(int i = 1; i<=5; i++) {
			for(int j = 1; j <= 5-i; j++ ) {
				System.out.print("  ");
			}
			for(int j = 1; j<=i;j++) {
				System.out.print("*");
			}
			for(int j = 1; j<=i-1; j++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		/*
		 * 
		 */
	}
}

