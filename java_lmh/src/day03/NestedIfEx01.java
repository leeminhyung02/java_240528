package day03;

public class NestedIfEx01 {

	public static void main(String[] args) {
		// 6의 배수를 중첩 if문을 이용하여 작성하기
		
		int num = 90;
		if (num % 2 == 0) {
			if(num % 3 == 0) {
				System.out.println(num+"은(는) 6의 배수 입니다.");
			}
			else {
				System.out.println(num+"은(는) 6의 배수가 아닙니다.");
			}
		}
		else {
			System.out.println(num +"은(는) 6의 배수가 아닙니다.");
		}
	}

}
