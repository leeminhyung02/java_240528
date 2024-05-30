package day03;

public class SwitchEx01 {

	public static void main(String[] args) {
		// 스위치문을 이용한 홀짝 예제
		
			int num = 3;
			switch(num % 2){
			case 0:
				System.out.println(num+"는 짝수 입니다.");
				break;
			default :
				System.out.println(num+"는 홀수 입니다.");
			}

	}

}
