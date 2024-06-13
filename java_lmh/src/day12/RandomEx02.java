package day12;

import java.util.Random;

public class RandomEx02 {

	public static void main(String[] args) {
		/*
		 * min~max사이의 랜덤한 수를 만드는 코드를 작성하세요
		 */
		/*
		int min = 1;
		int max = 10;
		int r = (int)(Math.random()*(max-min+1)+min);
		*/
		Random r = new Random();
		int min = 1, max = 10;
		for (int i = 0; i<20; i++) {
			int num = r.nextInt(max-min+1)+min;
			System.out.print(num+" ");
			
		}
		System.out.println();
		for (int i = 0; i<20; i++) {
			int num = r.nextInt(min, max+1);
			System.out.print(num+" ");
			
	
		}
		int [] A = {1,23,5,6};
		int a = A.length;
		System.out.println();
		System.out.println(a);
		
	}

}
