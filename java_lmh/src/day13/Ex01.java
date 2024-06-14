package day13;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		/*
		 *  다음과 같은 책 제목들이 있을 때 원하는 단어를 검색해서 해당 단어가 있는 책을 출력하는 코드를 작성하세요.
		 *  일치하는 책이 없는 경우 일치하는 책이 없습니다 라고 출력
		 */
		String [] books = {"자바의 정석","혼자하는 자바","혼자하는 C","수학의 정석","누구나 하는 C"};
		Scanner scan = new Scanner(System.in);
		System.out.print("원하는 단어를 입력하세요 : ");
		String word = scan.next();
		int count = 0;
		for (int i = 0; i < books.length; i++) {
			int j = books[i].indexOf(word);
			if (j != -1) {   //해당 단어가 문자열에 있다면
				System.out.print(books[i]+"   ");
			}
			else {
				count++;
			}
		}
		if (count  == books.length) {
			System.out.println("일치하는 책이 없습니다.");
		}
		else {
			System.out.println("가 있습니다.");
		}
	}

}
