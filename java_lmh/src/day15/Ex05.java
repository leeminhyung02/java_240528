package day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {
		// 숫자 야구 게임을 구현하세요
		// S : 숫자가 있고 위치가 같은 경우
		// B : 숫자가 있고 위치가 다른 경우
		// O : 일치하는 숫자가 하나도 없는 경우

		Scanner scan = new Scanner(System.in);
		int min = 1, max = 10;
		// 중복되지 않은 1~9 사이의 3개의 숫자를 생성
		HashSet<Integer> set = new HashSet<Integer>();
		while (set.size() < 3) {
			int random = (int)(Math.random() * (max - min + 1) + min);
			set.add(random);
		}
		ArrayList <Integer> list = new ArrayList<Integer>(set);
		Collections.shuffle(list);
		System.out.println(list);
		ArrayList <Integer>user = new ArrayList<Integer>();

		//반복문
		// 반복문을 이용하여 정수 3개를 입력 받은 후 판별(다 맞출 때까지)
		/*
		do {
			int s = 0;
			int b = 0;
			int o = 0;
			// 입력 안내문구 출력
			System.out.println();
			System.out.print("입력 : ");
			//사용자가 숫자 3개를 중복되지 않게 1~9 사이의 값을 입력
			for (int i = 0; i < list.size(); i++) {
				user.add(scan.nextInt()); 
			}
			//입력한 값과 랜덤 값을 이용하여 결과를 출력
			for (Integer tmp : list) {
				
			}
			
			
		}while (s !=3);
		*/
	}
	
}
