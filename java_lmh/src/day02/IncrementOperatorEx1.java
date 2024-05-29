package day02;

public class IncrementOperatorEx1 {

	public static void main(String[] args) {
		int num1 = 10, num2 = 10;
		
		++num1;
		num2++;
		
		System.out.println("num1 = " +  num1);
		System.out.println("num2 = " + num2);
		
		System.out.println("증가전 num1 : " + num1	);
		System.out.println("증가전 num2 : " + num2	);
		
		System.out.println("증가중 num1 : " + ++num1	);
		System.out.println("증가중 num2 : " + num2++	);
		
		System.out.println("증가후 num1 : " + num1	);
		System.out.println("증가후 num2 : " + num2	);
		
	}

}
