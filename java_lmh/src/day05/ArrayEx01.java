package day05;

public class ArrayEx01 {

	public static void main(String[] args) {
		/*5명의 학생 석정을 저장하기 위한 변수 선언 
		 * 지역변수는 자동으로 초기화 된다(X)
		 */
		int score1, score2,score3, score4, score5;
		//5명의 학생 성적을 저장할 수 있는 배열을 생성
		//배열을 자동으로 자료형에 맞는 초기화가 된다(O)
		//배열은 참초형. 
		int [] scores1 = new int[5];
		int scores2 [] = new int[5];
		//5개짜리 배열을 만들어서 1,2,3,4,5 순서대로 초기화
		int scores3 [] = new int[] {1,2,3,4,5};
		//score1배열에 0번지에 1, 1번지에 2, 2번지 3, 3번지에 4,4번지에 5를 저장
		/*
		scores1[0] = 1;
		scores1[1] = 2;
		scores1[2] = 3;
		scores1[3] = 4;
		scores1[4] = 5;
		System.out.println(scores1[0]);
		System.out.println(scores1[1]);
		System.out.println(scores1[2]);
		System.out.println(scores1[3]);
		System.out.println(scores1[4]);
		*/
		/*반복 횟수 : i는 0부터 5보다 작을때 까지 1씩 증가
		 * 규칙성 :  배열의 각 값은 번지수  + 1
		 */
		int i;
		for (i = 0; i<5; i++) {
			scores1[i] = i+1;
			System.out.println(scores1[i]);
		}
	}

}
