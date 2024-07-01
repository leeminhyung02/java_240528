package day24;

import lombok.Setter;

public class Ex09 {

	public static void main(String[] args) {
		PointA p1 = new PointA(10, 20);
		p1.print();
		/*
		 * x의 값을 100, y의 값을 200으로 수정하려 했다
		 * 원인 :클래스에 멤버는 private인데 세터를 안만들었다
		 * 해결 방법 :private를 바꾸거나 세터 추가
		 */
		/*
		 * p1.x = 100;
		 * p1.y = 200;
		 */
		p1.setX(100);
		p1.setY(200);
		
		p1.print();
		/*
		 * 기본 생성자를 이용해서 객체를 생성하려 했다.
		 * 원인 :생성자가 1개라도 있으면 기본 생성자가 자동으로 추가되지 않음 
		 * 				매개변수가 없는 생성자를 만들지 않음
		 * 해결 방법:매개변수 없는 생성자 만들기
		 */
		PointA p2 = new PointA();
		p2.print();
		
	}

}

class PointA {
	@Setter
	private int x, y;

	public PointA(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public PointA() {};
	public void print() {System.out.println(x + "," + y);}
}