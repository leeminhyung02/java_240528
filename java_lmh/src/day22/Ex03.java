package day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		/*	리스트에 숫자들을 저장하고, 저장된 숫자들을 정렬하는 코드를 작성하세요.
		 * */
		Scanner scan = new Scanner(System.in);
		List<Integer>list = new ArrayList<Integer>();
		while(true) {
			System.out.print("숫자 입력 : ");
			int i = scan.nextInt();
			if(i == -1) {break;}
			list.add(i);
		}
		Collections.sort(list);
		System.out.println(list);
		/* 정렬된 숫자들을 역순으로 정렬한느 콛를 작성하세요*/
		//Collections.reverse(list);
		Collections.sort(list,(i1,i2)->i2 - i1);
		System.out.println(list);
	}

}
