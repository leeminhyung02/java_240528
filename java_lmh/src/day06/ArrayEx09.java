package day06;

import java.util.Scanner;

public class ArrayEx09 {

	public static void main(String[] args) {
		String [] list = {"dog", "cat", "java","cup","computer"};
		
		//문자열을 입력받아 입력받은 문자열이 있는지 없는지 알려주는 코드를 작성하세요
		
		Scanner scan = new Scanner(System.in);
		System.out.print("체크할 문자열을 입력하세요 : ");
		String input = scan.next();
		int count = 0;
		  for (int i = 0; i < list.length; i++) {
			  if (input.equals(list[i])) {  //true
				  System.out.println(input+"은 배열의 "+i+"번지에 있습니다.");
				  break;
			  } 
			  else { //false
				  count++;
			  }
		  }
		 if (count == list.length) {
			 System.out.println(input+" 은 배열에 없습니다.");
		 }
	}

}
