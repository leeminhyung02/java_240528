package day22;

public class Ex02 {

	public static void main(String[] args) {
		/* 정수로 이루어진 문자열에서 각 정수들의 합을 구하는 코드를 작성하세요
		 * 1 23 45 3 9 7 5
		 * */
		String str = "1 23 45 3 9 7 5";
		String[] num = str.split(" ");
		System.out.println(convertAndsum(str));
		System.out.println(sum(numlist(num)));
		
	}
	/*	위에서 작성한 코드 중 일부를 메소드로 만든다고 했을 때 필요하다고 생각하는코드를
	 * 	메소드로 만들기   */
	public static int[] numlist(String[] num) {
		int numlist[] = new int[num.length];
		for (int i = 0; i< num.length; i++) {
			numlist[i] = Integer.parseInt(num[i]);
		}
		return numlist;
	}
	public static int sum(int[] numlist) {
		int sum = 0;
		for (int i = 0; i< numlist.length; i++) {
			sum +=numlist[i];
		}
		return sum;
	}
	/**
	 * 주어진 문자열에 있는 정수들을 더해서 더한 결과를 반환하는 메소드
	 * @param str 정수들이 들어있는 문자열
	 * @return 문자열에 있는 정수들의 합
	 */
	 public static int  convertAndsum(String str) {
		String [] nums = str.split(" ");
		int sum = 0;
		for(String num : nums) {
			int number = Integer.parseInt(num);
			sum += number;
		}
		return sum;
	}
}
