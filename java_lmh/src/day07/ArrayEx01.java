package day07;

import java.util.Scanner;

public class ArrayEx01 {

	public static void main(String[] args) {
		/*
		 * 3명의 학생의 국어,영어, 수학 성적을 입력받고 각 학생의 평균을 구하는 코드를 작성
		 */
		Scanner scan = new Scanner(System.in);

		double[] arr = new double[3];
		int tmp;
		int []kor = new int[3];
		int []eng = new int[3];
		int []math = new int[3];

		for (int i = 0; i < arr.length; i++) {
			System.out.print("학생" + (i + 1) + "의 성적 국어 입력 :");
			tmp= scan.nextInt();
			arr[i] +=tmp;
			kor[i] = tmp;
			System.out.print("학생" + (i + 1) + "의 성적 영어 입력 :");
			tmp = scan.nextInt();
			arr[i] += tmp;
			eng[i] =tmp;
			System.out.print("학생" + (i + 1) + "의 성적 수학 입력 :");
			tmp = scan.nextInt();
			arr[i] += tmp;
			math[i] += tmp;
			arr[i] = arr[i] / 3.0; 
		} 
		for (int i = 0; i < arr.length; i++) {
			System.out.println("학생" + (i + 1) + "의 평균 :" + arr[i]);
		}
		int temp = 0;
		for ( int j = 0; j < kor.length; j++) {
			temp +=kor[j];
		}
		System.out.println("국어 성적 평균 : "+temp/3.0);
		temp = 0;
		for ( int j = 0; j < eng.length; j++) {
			temp +=eng[j];
		}
		System.out.println("영어 성적 평균 : "+temp/3.0);
		temp = 0;
		for ( int j = 0; j < math.length; j++) {
			temp +=math[j];
		}
		System.out.println("수학 성적 평균 : "+temp/3.0);
		temp = 0;
	}

}
