package day06;

public class ArraySortEx03_ {

	public static void main(String[] args) {
		// 배열생성
		final int len = 10;
		int [] list = new int[len];
		int min = 1, max = 100;
		int random;
		for ( int i = 0; i < list.length; i++) {
			random = (int)(Math.random() * (max - min + 1) + min);
			list[i] = random; 
		}
		System.out.println("기본");
		for (int temp : list) {
			System.out.print(temp+"  ");
		}
		//오름차순 정렬
		System.out.println("\n오름차순");
		//처음부터 끝-1까지     //비교하는데 i번지,i+1번지 필요하기때문
		for ( int i = 0; i<list.length-1; i++) {  //list.length 번 반복
			for (int j = 0; j < list.length-i-1 ; j++) {  //처음에는 9번 비교  //그다음에는 8번.......마지막에는 1번
				if (list[j] > list[j+1]) { 
					int tmp = list[j];//앞 번지의 값이 크면 순서를 바꿈
					list[j] = list[j+1];
					list[j+1] = tmp;
				} 
			}					
		}
		
		for (int temp : list) {
			System.out.print(temp+"  ");
		}
		System.out.println("\n내림차순");
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length-i-1; j++) {
				if (list[j] < list[j+1]) {
					int tmp = list[j];
					list[j] = list[j+1];
					list[j+1] = tmp;
				}
			}
		}
		for (int temp : list) {
			System.out.print(temp+"  ");
		}
	}

}
