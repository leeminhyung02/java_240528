package day05;

public class ArrayEx03 {

	public static void main(String[] args) {
	/*1~10사이의 랜덤한 수 3개를 저장하고 출력하는 코드 작성
	 * 
	 * 3개 짜리 정수 배열을 생성
	 * 
	 * 반복문을 이용하여 배열 전체를 반복
	 * 
	 * 1~10사이의 랜덤한 수를 생성
	 * 
	 * 배열에 생성한 랜덤한 수를 저장
	 * 
	 * 반복문을 이용하여 배열 전체를 반복
	 * 
	 * 배열에 있는 값을 콘솔에 출력
	 */
		int min = 1, max = 10;
		int randomarr[] = new int[3];
		System.out.print("랜덤한 수 : ");
		for (int i = 0; i < randomarr.length; i++) {
			randomarr[i] = (int)(Math.random()* (max- min+1)+min);
				System.out.print(randomarr[i]+"   ");
		}
	}
}
