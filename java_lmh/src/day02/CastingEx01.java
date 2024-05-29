package day02;

public class CastingEx01 {
	public static void main(String[] args) {
		// 상수,변수,리터럴의 자료형을 일시적으로 변환시키는 것
		double num1 = 3; 
		long num2 = 3; //o   // 자동 자료형 변환이 동작, 정수 리터럴은 int
		int num3 = 3;  //x   그대로
		long num4 = num3; //o 자동자료형 변환이 동작
		
		int num5 = (int)3.14;  // 정수 3으로 자료형 변환(명시적 자료형 변환)
		System.out.println(num5);
		byte num6 = (byte)num5;  //명시적 자료형변환을 했지만 다행이 짤리는 값이 없는 경우
		System.out.println(num6);
		byte num7 = (byte)123123;  //명시적 자료형 변환을 해서 짤리는 값이 있는 경우, 원래값과 결과가 다름
		System.out.println(num7);  
		
		//자동자료형변환이 일어나지만 명시적 자료형변환이 필요한 경우
		double res = 1/2;   //   1/2의 결과인 0이 자동자료형변환을 통해 0.0으로 변환
		System.out.println(res);
		
		res = 1/(double)2;    //(1/2.0) -> 0.5   
		System.out.println(res);  
	}
}
