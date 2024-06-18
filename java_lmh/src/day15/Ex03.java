package day15;

import java.util.HashSet;
import java.util.Random;

public class Ex03 {

	public static void main(String[] args) {
		/*1~10사이의 랜덤한 수 6개를 중복되지 않게 생성해서 저장하고 출력하는 코드를 작성 */
		
		int min = 1;
		int max = 10;
		HashSet <Integer> set = new HashSet<Integer>();
		HashSet <Integer> set2 = new HashSet<Integer>();
		//1
		while(true) {
			int random = (int)(Math.random() * (max - min + 1) + min);
		 	set.add(random);
			if (set.size() == 6) {
				break;
			}
		} 
		System.out.println(set);
		//2
		while(set.size() < 6) {
			Random random = new Random();
			int r = random.nextInt(min, max+1);
			set2.add(r);
		}
	}

}
