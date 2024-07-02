package day24;

import lombok.Getter;
import lombok.Setter;

public class Ex10 {

	public static void main(String[] args) {
		PointB p1 = new PointB();
		p1.setX(100);
		/*
		 * 원인 : 정수형 매개변수에 실수형을 사용
		 * 해결방안 : 정수형으로 바꾸기 / 메소드를 오버로딩해서 새 메소드를 추가하던지, 실수 대신 정수로 변경
		 */
		p1.print(10.5, 20.5);
	}

}
class PointB{
	@Setter
	@Getter
	private int x, y;
	/*
	 * 메소드 오버로딩을 이용하여 print 메소드를 여러개 생성하려고 했다.
	 * 원인 : 매개변수의 개수가 같은 메소드가있을
	 * 해결방안 :둘중 하나의 매개변수를 정하거나 이름을 다르게 해야함
	 * 
	 */
	public void print() {
		System.out.println(x+" , "+y);
	}
	public void print(int x, int y) {
		System.out.println(x+" , "+y);		
	}
	public void print(double x, double y) {
		System.out.println(x+" , "+y);
	}
}