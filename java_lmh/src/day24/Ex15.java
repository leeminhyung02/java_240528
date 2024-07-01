package day24;

import program.Program;

public class Ex15 {

	public static void main(String[] args) {
		//아래에서 작성한 TestProgram의 run()메소드를 실행하는 코드를 작성하세요ㅛ
		TestProgram tp = new TestProgram();
		tp.run();
	}

}
/*
 * 프로그램 인터페이스를 구현한 구현 클래스를 만들려고 했다 
 * 원인 : 프로그램 인터페이스의 추상메소드들을 오버라이딩 하지 않음
 * 해결 방버 :추상 메소드들을  오버라이딩 한다.
 */
class TestProgram implements Program{

	@Override
	public void printMenu() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runMenu(int menu) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("프로그램을 실행했스ㅃ니다.");
	}
	
}