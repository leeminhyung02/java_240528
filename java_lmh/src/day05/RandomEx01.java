package day05;

public class RandomEx01 {

	public static void main(String[] args) {
		/*
		 * min ~max 사이의 정수를 랜덤으로 만드는 코드 설명 예제
		 * Math.random()은 0이상 1미만의 랜덤한 실수를 생성
		 *  0 * (max-min+1)+min<= r * (max-min+1) + min< 1*(max-min+1)+min
		 *  min <= r* (max-min+1) + min < max+1
		 *  min이상 max+1 미만의 실수가 만들어짐 -> (int) 형변환 사용
		 */

		int min = 1, max = 7;
		int random = (int)(Math.random()* (max- min+1)+min);
		System.out.println(random);
	}

}
