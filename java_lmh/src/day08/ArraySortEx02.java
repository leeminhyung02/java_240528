package day08;

import java.util.Arrays;

public class ArraySortEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] arr = new String[] {"abc","a","zoo","banana"};
		
		for (int i = 0; i <arr.length-1;i++) {
			for (int j = 0; j < arr.length-1;j++) {
				//문자열.compareTo(문자열2) : 문자열1과 문자열2를 알파벳순으로 배치했을 때 위치를 정수로 알려줌
				//같은 번지에 있는 문자들끼리 순서대로 비교
				//apple 과 a 를 비교하면
				//apple 의 a 와 a 의 a 를 비교
				//apple 의 p 와 a 의 다음이 없어서 a 가 앞으로
				//같으면 0, 문자열1이 앞으면 음수, 문자열1이 뒤이면 양수
				if (arr[j].compareTo(arr[j+1]) > 0) {
					String tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
