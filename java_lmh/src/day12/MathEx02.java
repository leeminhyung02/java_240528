package day12;

public class MathEx02 {

	public static void main(String[] args) {
		/*
		 * 3.14를 소수점 2번째 자리에서 올림하는 코드를 작성하세요
		 */

		double py = 3.14;
		//py 에 *10을 하고 올림을 한후 /10
		
		py *=10;
		py = Math.ceil(py);
		py /= 10;
		System.out.println(py);
	}

}
