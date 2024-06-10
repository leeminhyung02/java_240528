package day09.access2;

import day09.access.Student;

public class AccessModifierEx02 {
	//접근 제어자 예제
	public static void main(String[] args) {
		Student std1 = new Student();
		std1.grade = 10;//접근제어자가 public이어서 다른 클래스에서 사용 가능
		//std1.classNum = 1; //접근제어자가 protected이어서 다른패키지에있는 다른 클래스에서 사용불가
		//std1.num = 1; //접근제어자가 default여서 다른패키지에있는 다른 클래스에서 사용불가
		//std1.name = "홍길동"; //접근제어자가 private 이어서 다른 클래스에서 사용불가
	}

}
