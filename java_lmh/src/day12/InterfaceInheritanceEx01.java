package day12;

public class InterfaceInheritanceEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterfaceInheritanceEx01 a = new InterfaceInheritanceEx01();
		
	}

}

interface InterfacePA{
	void print();
	void test1();
}
interface InterfacePB{
	void print();
	void test1();
}
//print메소드가 겹치는데 상속을 받으면 어차피 구현부가 없어서 하나로 합치면 되기 대문에 다중 상속이 가능(인터페이스)
interface InterfaceC extends InterfacePA, InterfacePB{
	
}

class ClassA{
	void print() {}
	void test2() {}
}
class ClassB{
	void print() {}
	void test1() {}
}
class ClassC extends ClassA{}