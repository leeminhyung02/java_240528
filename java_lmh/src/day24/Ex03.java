package day24;

public class Ex03 {

	public static void main(String[] args) {
		int num = 2;
		/*
		 * 짝수라고 판별해야하는데 짝수, 홀수 모드 출력이 됨
		 * 원인 : ;을 잘못붙여서 if문과 상관없는 문장이 됨
		 * 해결 방법 : ;을 지우기
		 */
		if(num % 2 == 0);	{
			System.out.println("짝수");
		}
		if(num % 2 != 0);	{
			System.out.println("홀수");
		}
	}

}
