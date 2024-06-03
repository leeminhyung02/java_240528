package day05;

public class StarEx02 {

	public static void main(String[] args) {
	/* *을 하나씩 출력해서 다음과 같이 출력되도록 중첩 반복문을 이용해서  작성하세요.
	 *        *			i = 1, * = 1
	 *        **			i = 2, * = 2
	 *        ***			i = 3, * = 3
	 *        ****		i = 4, * = 4
	 *        *****		i = 5, * = 5
	 *        
	 *        반복횟수 : i는 1부터 5까지 1씩 증가
	 *        규칙성 : i가j보다 크면 *출력을 멈추고 줄바꿈
	 *        
	 *        반복문 종료 후 : 없음
	 */
		for (int i = 1; i<=5; i++) {
			for (int j = 1; j<=5 ; j++) {
				if( i >= j) {
					System.out.print("*");
				}
			}					
			System.out.println();  //System.out.print("\n");
		}
	}
}

