package day24;

import lombok.Data;

public class Ex13 {

	public static void main(String[] args) {
		// 세점 1,1   2,2 3,3을 저장하기 위해 다음과같이 코드를 작성했다
		//원인 : 객체를 생성하지 않고 메소드들을 호출했기 때문에
		//해결 방법 : 객체를 생성
		PointC [] pts = new PointC[3];
		for(int i = 0; i<pts.length; i++) {
			pts[i] = new PointC(0, 0);
			pts[i].setX(i+1);
			pts[i].setY(i+1);
			pts[i].print();
		}
		
	}

}
@Data
class PointC{
	private int x, y;
	public PointC(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void print()	{
		System.out.println(x+" , "+y);
	}
}