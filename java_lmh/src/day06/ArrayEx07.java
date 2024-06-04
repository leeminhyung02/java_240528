package day06;

import java.util.Arrays;
import java.util.Scanner;

import javax.swing.DefaultListCellRenderer;

public class ArrayEx07 {

	public static void main(String[] args) {
		/* UpDown 게임에 다음 기능을 추가하세요.
		 * 메뉴
		 *1. 플레이
		 *2. 기록확인
		 *3. 종료
		 *메뉴 선택 : 1
		 *정수 입력 : 50
		 *맞힌 획수는 3회 입니다.
		 *기록이 등록됩니다.  5등까지
		 *
		 *기록확인
		 *1. 3회
		 *
		 *메뉴 선택 : 3
		 *프로그램을 종료합니다.
		 */
		int score[] = new int[5];
		int num;
		int count = 0;
		int count_length = 0;
		int count2 = 5;
		int j = 1;
		int menu=0;
		int min = 1, max = 100;   // int random = (int)(Math.random() * (max - min + 1) + min);
		Scanner scan = new Scanner(System.in);
		do {
			//메뉴 출력
			System.out.println("메뉴");
			System.out.println("1. 플레이");
			System.out.println("2. 기록확인");
			System.out.println("3. 종료");
			System.out.print("메뉴 선택 : ");
			//Scanner를 이요하여 메뉴를 입력
			menu = scan.nextInt();
			//선택한 메뉴에 따른 기능 실행
			switch(menu) {
			//선택한 메뉴가 1이면 플레이 문구 출력하는 코드 작성
			case 1:
				//1~100 사이의 랜덤한 수를 생성
				 int random = (int)(Math.random() * (max - min + 1) + min);
				 System.out.println(random);
				//입력한 값이 랜덤한 수와 같지 않으면 반복
					do {//정수 입력 : 안내문구 출력
						System.out.print("정수 입력 :");
						//Scanner를 이용하여 정수를 입력
						num = scan.nextInt();
						//입력한 횟수를 증가
						count++;
						if (num > random) {//입력한 값이 랜덤한 값보다 크면 DOWN이라고 출력하고
							System.out.println("DOWN!");
						}
						else if(num < random) {//입력한 값이 랜덤한 값보다 작으면 up이라고 출력하고 
							System.out.println("UP!");
						}
						else {//같으면 정답입니다를 출력하고 입력한 횟수를 출력합니다.
							System.out.println("정답입니다!");
							System.out.println("맞힌 횟수는 "+count+"입니다.");
							Arrays.sort(score);
							for(int i = 0; i < score.length; i++) {
								if (score[i] != 0) {
									count_length++;
									if(count_length == 5) {
										score[4] = (score[4] > count) ? count : score[4];
										System.out.println("기록이 등록됩니다.\n");
										break;
									}
								}
								else {
									score[i] = count;
									System.out.println("기록이 등록됩니다.\n");
									break;
								}
								
							}
							count = 0;
							count_length = 0;
						}
					} while(num != random);
				break;
			//선택한 메뉴가 2이면 기록 확인 문구 출력하는 코드 작성
			case 2:
				System.out.println("기록 확인\n");
				Arrays.sort(score);
				for (int i = 0; i < score.length; i++) {
					if (score[i] == 0) {
						count2--;
						 if(count2 == 0 ) {//다 없을때
								System.out.println("기록 없음\n");
						}
					}
					else {
						System.out.println(j+"등 : "+score[i]+"회\n");
						j++;
					}
				}
				count2 = 5;
				j = 1;
				break;
			//선택한 메뉴가 3이면 프로그램 종료 문구 출력하는 코드장ㄱ성
			case 3:
				System.out.println("프로그램을 종료합니다. ");
				break;
			//아니면 잘못된 메뉴 문구 출력하는 코드 작성
			default:
				System.out.println("잘못된 메뉴 입니다. ");	
			}
		}while ( menu !=3);
	}
}
