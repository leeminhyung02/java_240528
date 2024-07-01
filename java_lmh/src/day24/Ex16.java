package day24;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex16 {

	public static void main(String[] args) {
		/*
		 *1. 이름과 나이를 저장하고 관리하는 클래스를 생성하세요
		 *
		 *2. 이름이 홍길동, 나이는 21인 객체를 생성하세요
		 *
		 *3, src/day24/ex16.txt에 2번에서 작성한 객체를 저장하세요.
		 */
		String fileName = "src/day24/ex16.txt";
		A a = new A("홍길동", 21);
		
		try {
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(a);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 *4. fileName에 저장된 객체를 불러온 후 콘솔창에 출력하는 코드를 작성하세요
		 */
		A b = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
			/*
			 * (A)를 생략하면 에러발생
			 * 원인 : 읽어온객체는 Object객체이기 때문에 자식클래스 객체게 맞게 변환해야함
			 * 다운캐스팅은 자동으로 이루어지지 않는다.
			 * 그래서 명시적으로 클래스형 변환을 해햐한다.
			 */
			b = (A) ois.readObject();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		b.print();
	}

}
@Data
@AllArgsConstructor
class A implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1258805259458660313L;
	private String name;
	private int age;
	
	public void print() {
		System.out.println(name+':'+age);
	}
}