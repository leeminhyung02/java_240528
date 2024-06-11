package day10;

import java.util.Arrays;
import java.util.Scanner;

public class VocabularyEx01 {

	public static void main(String[] args) {
		/*메뉴
		 * 1. 단어 등록
		 * 2. 단어 수정
		 * 3. 단어 검색
		 * 4. 단어 삭제
		 * 5. 종료
		 * 메뉴 선택 :
		 */
		int menu;
		final int WORD_MAX = 10;
		Word list[] = new Word[WORD_MAX];
		int wordCount = 0;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("메뉴");
			System.out.println("1. 단어 등록");
			System.out.println("2. 단어 수정");
			System.out.println("3. 단어 검색");
			System.out.println("4. 단어 삭제");
			System.out.println("5. 종료");
			System.out.print("메뉴 선택:");	 
			menu = scan.nextInt();
			switch (menu) {
				case 1: {		//단어 등록
					// 단어 정보(단어, 품사, 의미)를 입력
					System.out.print("단어 : ");
					String word = scan.next();
					System.out.print("품사 : ");
					String wordclass = scan.next();
					System.out.print("의미 : ");
					String mean = scan.next();
					// 입력한 단어 정보를 이용하여 단어 객체를 생성
					// 단어 리스트에 단어 객체를 저장 => 마지막으로 저장된 위치 다음에 단어 객체를 저장
					list[wordCount] = new Word(word,wordclass,mean); 
					// 저장된 단어 개수를 1 증가
					wordCount++;
					// 단어 리스트를 정렬(알파벳순으로)
					for (int i = 0; i < wordCount; i++) {
						list[i].getWord().charAt(0) > 
					}
					break;
				}
				case 2: {		//단어 수정
					System.out.println("단어 수정");

					break;
				}
				case 3: {		//단어 검색
					System.out.println("단어 검색");

					break;
				}
				case 4: {		//단어 삭제
					System.out.println("단어 삭제");

					break;
				}
				case 5: {		//종료
					System.out.println("프로그램을 종료합니다.");
					break;
				}
				default: {
					System.out.println("잘못 입력하셨습니다.");
				}
			}   //switch 끝 
		}while(menu !=5 );
	}
	public static void printmenu() {
		System.out.println("메뉴");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 검색");
		System.out.println("4. 단어 삭제");
		System.out.println("5. 종료");
		System.out.print("메뉴 선택:");	
	}
	
	/**단어를 추가하는 기능
	 * 
	 */
	public static Word inputWord(Scanner scan) {
		System.out.print("단어 : ");
		String word = scan.next();
		System.out.print("품사 : ");
		String wordclass = scan.next();
		System.out.print("의미 : ");
		String mean = scan.next();
		return new Word(word,mean,wordclass);
	}
	/** 단어 등록하는 기능
	 * 
	 */
	public static int insertWord(Word list[],Scanner scan,int wordCount) {
		//단어장이 다 찼을경우
		if (wordCount >=list.length) {
			return -1;
		}
		return wordCount;
	}
	
	
	
	
}











/** 영어 단어를 관리하기 위한 word 클래스를 만들고
 * 	필요한 멤버변수들을 선언해보세요.
 * */
class Word {
	//단어, 뜻, 품사
	private String word, meaning, wordClass;

	//생성자
	public Word() {}
	
	public Word(String word, String wordClass, String meaning) {
		this.word = word;
		this.wordClass = wordClass;
		this.meaning = meaning;
	}

	/**	단어를 출력하는 메소드	
	 */
	public void print() {
		System.out.println("-------------------------");
		System.out.println("단어 :  "+word);
		System.out.println("품사 :  "+wordClass);
		System.out.println("의미 :  "+meaning);
		System.out.println("-------------------------");

	}
	


	//getter | setter

	public String getWord() {
		return word;
	}

	public String getMeaning() {
		return meaning;
	}

	public String getWordClass() {
		return wordClass;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public void setWordClass(String wordClass) {
		this.wordClass = wordClass;
	}
}