package day02;

public class LogicalOperatorEx01 {

	public static void main(String[] args) {
		//논리 연산자 예제
		
		//성적이 B학점인지 확인하는 예제
		int score = 95;
		boolean isB;
		// score가 80이상, 90미만이면 B이다.  (80~89)
		//score >= 80 && score <90
		
		/* &&연산자 진리표
		 * A		B		A&&B
		 * T		T		T
		 * T 		F		F
		 * F		F		F
		 * F		T		F
		 */
		

		isB = score >= 80 && score <90;
		System.out.println(score + "점은 B학점 인가요?\n" + isB);
		
		/* ||연산자 진리표
		 * A		B		A||B
		 * T		T		T
		 * T	 	F		T
		 * F		F		F
		 * F		T		T
		 */
		
		/* !연산자 진리표
		 * A		!A
		 * T		F
		 * F		T
		 */
		
		/*4과목중 하나라도 과락이 있으면 탈락이다.
		*과락은 과목 점수가 40 미만인 경우.
		*각 과목의 성적이 다음과 같을 대 과락이 있는지 확인하는 코드
		*과목1이 성적이 40미만이거나 과목2 성적이 40미만 이거나 과목3 성적이40미만이거나 과목 4 성적이 40미만이다.
		*sub1이 40보다 작다|| sub2가 40보다 작다 ||sub3이 40보다 작다 ||sub4가 40보다 작다.
		*sub1 < 40 || sub3 < 40 || sub3 < 40 || sub4 < 40 
		*/
		
		int sub1 = 60, sub2 = 100, sub3 = 50, sub4= 80;
		boolean ifFail = 	sub1 < 40 || sub2 < 40 || sub3 < 40 || sub4 < 40 ;
		System.out.println("과락이 있습니까?\n" +  ifFail);
		
		/* 19세 이상은 성인이다.
		 * 나이가 주어지면 미성년자 인지 확인하기   */
		int age = 20;
		boolean isMinor = !(age >=19);
		System.out.println("미성년자 입니까? \n" + isMinor);
	}
}
