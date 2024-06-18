package day15;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Ex5_1 {

	public static void main(String[] args) {
		int min = 1,max = 9, count = 3;
		List<Integer>com = createRandom(min,max,count);
		System.out.println(com);
		
		Scanner scan = new Scanner(System.in);
		int s,b;
		List<Integer>user;
		do {
			s = b = 0;
			//
			System.out.println("입력 : ");
			user = inputUser(min,max,count,scan);
			System.out.println(user);
			//
			s = gets(com,user);
			b = getb(com,user);
			
			if(s != 0) {
				System.out.println(s+"S");
			}
			if(b != 0) {
				System.out.println(b+"B");
			}
			if(s==0 && b == 0) {
				System.out.println("O");
			}
			
		}while(s != 3);
		
	}
	private static int getb(List<Integer> com, List<Integer> user) {
		if(com.size() != user.size()) {
			throw new RuntimeException("크기가 달라 판별할 수 없습니다.");
		}
		int ball = 0;
		//일치하는 숫자가 있는지 개수를 셈(볼 + 스트라이크)
		for(int tmp1 : com) {
			if (user.contains(tmp1)) {
				ball++;
			}
		}
		return ball-gets(com,user);
	}
	private static int gets(List<Integer> com, List<Integer> user) {
		if(com.size() != user.size()) {
			throw new RuntimeException("크기가 달라 판별할 수 없습니다.");
		}
		int s = 0;
		for (int i = 0; i< com.size(); i++) {
			if(com.get(i) == user.get(i)) {
				s++;
			}
		}
		return s;
	}
	
	private static List<Integer> inputUser(int min, int max, int count, Scanner scan) {
		// TODO Auto-generated method stub
		if(min > max) {
			int tmp = min;
			min = max;
			max = min;
		}
		if(max - min +1 < count) {
			String format = "{0}~{1} 사이에서 중복되지 않은 {2}개의 수를 만들 수 없습니다.";
			throw new RuntimeException(MessageFormat.format(format, min,max,count));
		}
		System.out.print("입력 : ");
		int num = scan.nextInt();
		List<Integer> tmp = new ArrayList<Integer>();
		while(tmp.size() < count) {
			if(!tmp.contains(num)) {
				tmp.add(num);
			}
		}
		return null;
	}
	private static List<Integer> createRandom(int min, int max, int count) {
		//1,3 이 와야 하는데 3,1이 온 경우 1,3 으로 변경
		if(min > max) {
			int tmp = min;
			min = max;
			max = min;
		}
		if(max - min +1 < count) {
			String format = "{0}~{1} 사이에서 중복되지 않은 {2}개의 수를 만들 수 없습니다.";
			throw new RuntimeException(MessageFormat.format(format, min,max,count));
		}
		
		HashSet<Integer>set = new HashSet<Integer>();
		while (set.size() < count) {
			int r = (int)Math.random()*(max - min+1)+min;
			set.add(r);
		}
		//숫자 야구 게임 에서 순서가 중요하기 때문에 Set에 있는 숫자들을 list에 저장한 후 섞어 줌
		List<Integer>list = new ArrayList<Integer>();
		list.addAll(set);
		
		Collections.shuffle(list);
		
		return list;
	}
}
