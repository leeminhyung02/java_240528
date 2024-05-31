package day04;

public class WhileEx02 {

	public static void main(String[] args) {
		//while문을 이용해서 1부터 5까지 콘솔에 출력
		int i = 1;
		while(i <= 5) {
			System.out.println(i);
			i++;
		}
		/*
		 * 10부터 1까지 콘솔에 출력하는 코드 작성
		 */
		System.out.println("--------------------");
		i = 10;
		while (i >= 1) {
			System.out.println(i);
			i--;
		}
	}

}
