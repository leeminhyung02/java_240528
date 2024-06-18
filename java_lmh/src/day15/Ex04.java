package day15;

import java.util.HashSet;
import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		/* 1~45사이의 중복X 6개의 번호와 1개의 보너스 번호를 랜덤으로 생성하고,
		 * 사용자가 번호를 6개 입력해서 몇등인지 맞추는 로또 예제
		 * 
		 * 1등 6개 일치
		 * 2등 5개, 보너스번호 일치
		 * 3등 5개 일치
		 * 4등 4개 일치
		 * 5등 3개 일치*/
		
		//로또 번호와 보너스 번호를 생성
		HashSet <Integer> lotto = new HashSet<Integer>();
		int min = 1, max = 45;
		int bonus = 0;
		int count = 0;
		boolean bonuscount = false;
		while(lotto.size() < 6) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			lotto.add(r);
		}
		do {
			bonus = (int)(Math.random() * (max - min + 1) + min);
			
		}while (lotto.contains(bonus));
		System.out.println("확인용"+lotto+bonus);
		
		
		//사용자가 6개의 번호를 입력
		HashSet <Integer> set2 = new HashSet<Integer>();
		Scanner scan = new Scanner(System.in);
		System.out.print("번호 입력(1~45사이의 중복되지 않은 수 6개)  : ");
		while (set2.size() < 6) {
			set2.add(scan.nextInt());
		}

		//입력한 번호를 이용하여 당첨 등수를 출력
		
		for (Integer num : set2) {
			if (lotto.contains(num)) {
				count++;
			}
			if(num == bonus) {
				bonuscount = true;
			}
		}
		System.out.println("맞힌 개수 : "+count);
		switch (count) {
		case 3: {
			//5등
			System.out.println("5등입니다.");
			break;
		}
		case 4: {
			//4등
			System.out.println("4등입니다.");
			break;
		}
		case 5:{
			if (bonuscount) {
			//if (set2.contains(bonus))
				//2등
				System.out.println("2등입니다.");
				break;
			}
			//3등
			System.out.println("3등입니다.");
			break;
		}
		case 6:{
			//1등
			System.out.println("1등입니다.");
			break;
		}
		default:
			System.out.println("맞힌 개수 : "+count);
			break;
		}
	}

}
