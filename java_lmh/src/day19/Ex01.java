package day19;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		/* 리스트에 문자열을 5개 입력받아 저장하는 예제
		 * */
				
		//1. Scanner 생성
		Scanner scan = new Scanner(System.in);
		//2. 리스트를 생성
		List<String> list = new ArrayList<String>();
		//3. 반복문을 이용해서 문자열을 입력받아 리스트에 저장
		for (int i = 1; i < 6; i++) {
			System.out.print("문자열 입력 "+i+" : ");
			String str = scan.next();
			list.add(str);
		}
		//4. 저장된 문자열을 출력
		System.out.println(list);
		/* 문자열 A를 입력받아 리스트에 A를 포함하는 문자열들을 출력하는 예제 */
		System.out.print("찾을 문자열 입력 : ");
		String str = scan.next();
		for (String tmp : list) {
			if(tmp.contains(str)) {
				System.out.println(tmp);
			}
		}
		
		list.stream().filter(c->c.contains(str))
		.forEach(c->System.out.println(c));
	}

}
