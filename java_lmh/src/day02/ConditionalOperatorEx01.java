package day02;

public class ConditionalOperatorEx01 {

	public static void main(String[] args) {
		//조건 연산자 예제

		//주어진 나이에따라 성인, 미성년자를 출력하는 예제
		
		int age = 15;
		String result = (age >= 19) ? "성인" : "미성년자";
		System.out.println(age + "살은 "+ result + "입니다.");
	}

}
