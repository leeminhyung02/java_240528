package day24;

public class Ex08 {

	public static void main(String[] args) {

/*
 * 좌표 10, 20을 이용하여 객체를 생성했는데, 0,0 으로 나옴
 * 원인 : 생성자를 잘못 만듦
 * 해결 방법 :x = x;  -> this.x = x;로 수정
 */
		Point p1 = new Point(10, 20);
		
		p1.print();
		
/*
 * 기본 생성자를 이용하여 객체를 생성하려고 했는데 에러가 발생
 * 원인 : 생성자에는 void가 붙지 않음
 * 해결 방법 : void를 제거
 */
		//Point p2 = new Point();
		
	//	p2.print();
	}

}

class Point{
	private int x, y;
	
	public Point(int x, int y) {
		x = x;
		y = y;
	}
	public void Point()	{}
	public void print()	{
		System.out.println("("+x+", "+y+")");
	}
}