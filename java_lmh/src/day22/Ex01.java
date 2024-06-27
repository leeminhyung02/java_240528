package day22;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Ex01 {

	public static void main(String[] args) {
		/*
		 * 콘솔에서 한문장(영어)을 입력하고 한 문장에 몇 개의 단어로 구성되어 있는지 확인하는 코드를 작성하세요 
		 * Hi My name is Hong Hi
		 */
		Scanner scan2 = new Scanner("Hi My name is Hong Hi\n");
		Scanner scan = new Scanner(System.in);
		System.out.print("영어 문장 입력 : ");
		String str = scan.nextLine();
		str = str.trim();

		String[] words = str.split(" ");
		System.out.println("단어의 개수 : " + words.length);

		StringTokenizer st = new StringTokenizer(str, " ");
		System.out.println(st.countTokens());
			
		}
	}

