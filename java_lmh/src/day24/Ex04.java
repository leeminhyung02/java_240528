package day24;

public class Ex04 {

	public static void main(String[] args) {
		int score = 80;
		/*
		 * A를 판별하는 코드를 작성했는데, A가 아닌 경우에도A가 출력
		 * 원인 : or(||)를 써서
		 * 해결방안 : and(&&) 사용
		 */
		if(score >= 90 || score <=100) {
			System.out.println("A");
		}
		System.out.println("-------");
		if(score >= 90 && score <=100) {
			System.out.println("A");
		}

	}

}
