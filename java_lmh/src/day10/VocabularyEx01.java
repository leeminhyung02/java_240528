package day10;

import java.util.Scanner;

public class VocabularyEx01 {

	private static Scanner scan = new Scanner(System.in);
	
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
		int WORD_MAX = 2;
		Word list[] = new Word[WORD_MAX];
		int wordCount = 0;
		do {
			printmenu(); 
			menu = scan.nextInt();
			switch (menu) {
				case 1: {		//단어 등록
					wordCount = insertWord(list, wordCount);
					//단어 리스트가 다 찼으면 단어 리스트를 늘려줌
					if (wordCount == list.length) {
						list = expandWordList(list, list.length+10);
					}
					for (int i = 0; i < wordCount; i++) {
						list[i].print();
					}
					System.out.println("단어 등록을 완료 했습니다.");
					break;
				}
				case 2: {	
					updateWord(list, wordCount);
					break;	

				}
				case 3: {		//단어 검색
					//단어 리스트가 비어있을때(하나도 등록X)
					if (list[0] == null) {
						System.out.println("단어 리스트가 비어있습니다.");
						break;
					}
					// 단어를 입력하면 해당하는 단어를 출력
					System.out.print("검색할 단어를 입력  : ");
					String word = scan.next();
					int count = 0;
					//	단어 리스트에 수정할 단어와 일치하는 단어들을 번호와 함께 출력
					// 같은 단어가 여러개라면 여러개의 단어를 출력
					for (int i = 0; i < wordCount; i++) {
						if (word.equals(list[i].getWord())) {
							System.out.println((i+1)+"번.");
							list[i].print();		
						}
						else {
							count++;
						}
					}
					if (count >= wordCount) {
						System.out.println("해당 단어가 리스트에 없습니다.");
					}
					break;
					//printSerachWord(list, wordCount, word);
				}
				case 4: {		//단어 삭제
					wordCount = deleteWord(list,wordCount);
					for (int i = 0; i <wordCount; i++) {
						list[i].print();
					}
					break;
				
					// 삭제할 단어 입력
					/*
					System.out.print("삭제할 단어 입력 :");
					// 해당 단어가 있으면 삭제
					String word = scan.next();
					int count = 0;
					// 단어가 끝에 있는 단어가 아니라면 앞으로 하나씩 당기기
					for (int i = 0; i < wordCount; i++) {
						if (word.equals(list[i].getWord())) {
							System.out.println((i+1)+"번.");
							list[i].print();		
							count++;
						}
					}
					// 해당 단어가 없으면 없다고 출력
					if (count == 0) {
						System.out.println("해당 단어가 리스트에 없습니다.");
						break;
					}
					System.out.print("삭제할 단어의 번호를 선택하세요  : ");
					int num = scan.nextInt();
					boolean res = checkWord(list, word, num-1);
					if (!res) {
						System.out.println("잘못된 번호를 선택했습니다.");
						break;
					}
					//단어를 삭제하고 단어가 끝에 있는 단어가 아니라면 앞으로 하나씩 당기기
					int index = num-1;
					list[index] = null;
					if (num == wordCount) {
						System.out.println("단어를 삭제 했습니다.");
						wordCount--;
					}
					else { 
						for(index = num-1; index < wordCount-1; index++) {
							list[index] = list[index+1];
						}
						list[wordCount-1] = null;
						wordCount--;
						System.out.println("단어를 삭제 했습니다.");
					}
					*/
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
	public static int deleteWord(Word[] list, int wordCount) {
		//삭제할 단어를 입력
		System.out.print("단어 : ");
		String word = scan.next();
		//삭제할 단어를 출력
		printSerachWord(list, wordCount, word);
		//삭제할 단어를 선택
		//잘못된 선택이면 안내문구 출력
		int num = scan.nextInt();
		if (!checkWord(list, word, wordCount)) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return wordCount;
		}
		//올바른 선택이면 삭제
		//삭제하려는 번지 다음에 있는 단어들부터 앞으로 한칸씩 당기고 마지막 단어를 null로 만듦
		//저장된 단어수를 1감소
		wordCount = deleteWordlist(list, wordCount, num-1);
		System.out.println("삭제를 완료했습니다."); 
		return wordCount;
	}
	/** 단어를 입력받아 단어 리스트에 해당 단어가 있는지 출력하는 메소드
	 * @param list 단어 리스트
	 * @param wordCount 저장된 단어 개수
	 * 
	 */
	public static void a(Word[] list, int wordCount, String word) {
		int count = 0; //일치하는 단어가 몇개 있는지 확인하는 변수
		//	단어 리스트에 수정할 단어와 일치하는 단어들을 번호와 함께 출력
		for (int i = 0; i < wordCount; i++) {
			if (word.equals(list[i].getWord())){
				System.out.println((i+1)+"번.");
				list[i].print();
				count++;
			}
		}
		if (count == 0) {
			System.out.println("수정할 단어가 없습니다.");
			return;
		}
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
		

	
	/** 기능 : 단어 정보를 입력받아 단어 객체를 돌려주는 메소드
	 * @return 단어 객체
	 */
	public static Word inputWord() {
		// 단어 정보(단어, 품사, 의미)를 입력
		System.out.print("단어 : ");
		String word = scan.next();
		System.out.print("품사 : ");
		String wordclass = scan.next();
		System.out.print("의미 : ");
		scan.nextLine();//공백 처리용
		String mean = scan.nextLine();
		Word tmp = new Word(word, wordclass, mean);
		return tmp;
	}
	/** 기능 :  단어 리스트에 단어를 입력받아 단어를 추가하고 등록된 단어 숫자를 알려주는 메소드
	 * @param list 단어 리스트
	 * @param wordCount 저장된 단어 개수
	 * @return 저장된 단어 개수
	 */
	public static int insertWord(Word[] list, int wordCount) {
		
		Word tmp = inputWord();
		// 단어 리스트에 단어 객체를 저장 => 마지막으로 저장된 위치 다음에 단어 객체를 저장
		list[wordCount] = tmp;
		// 저장된 단어 개수를 1 증가
		wordCount++;
		// 단어 리스트를 정렬(알파벳순으로)
		wordSort(list, wordCount);
		
		return wordCount;
	}
	
	/**기능 : 저장된 단어 리스트를 정렬하는 메소드
	 * @param list 단어 리스트
	 * @param wordCount 저장된 단어 개수
	 */
	public static void wordSort(Word list[],int wordCount) {
		for (int i = 0; i <wordCount-1;i++) {
			for (int j = 0; j < wordCount-1;j++) {
				//j번지에 있는 단어가 사전순으로 j+1번지에 있는 단어보다 뒤이면 두 단어 객체를 교환
				//j번지에 있는 단어 :list[j].getWord() , j+1번지에 있는 단어 :list[j+1}.getWord()
				if (list[j].getWord().compareTo(list[j+1].getWord()) > 0) {
					Word tmp = list[j];
					list[j] = list[j+1];
					list[j+1] = tmp;
				} 
			}
		}
	}
	
	/** 단어 리스트를 늘려서 돌려주는 메소드
	 * @param list 단어 리스트
	 * @param size 늘려줄 크기
	 * @return 늘어난 단어 리스트
	 */
	public static Word[] expandWordList(Word[] list,int size) {
		if (list.length >= size) {
			return list;
		}
		Word [] tmp = new Word[size];
		//list 0번지부터 list.length를 tmp 의 0번지 부터 복붙
		System.arraycopy(list, 0, tmp, 0, list.length);
		return tmp;
	}
	
	/**list에 i번지에 있는지 단어가 word인지 아닌지 알려주는 메소드
	 * 
	 * @param list 단어 리스트
	 * @param word 검색할 단어
	 * @param i 해당 단어의 번지
	 * @return index 번지에 word가 있으면 true, 없으면 false
	 */
	public static boolean checkWord(Word[] list, String word, int i) {
		if(list.length <= i || i < 0) {
			return false;
		}
		if(list[i] == null) {
			return false; 
		}
		return list[i].getWord().equals(word);
	}
	
	public static void updateWord(Word [] list, int wordCount) {
//		단어 수정을 구현하기 위한 과정을 주석으로 작성. 같은 단어가 있는 경우
		//	누구를 수정할지를 선택하는 부분을 고민해야함.
		//	수정할 단어를 입력
		System.out.print("수정할 단어를 입력");
		String word = scan.next();
		//	단어 리스트에 수정할 단어와 일치하는 단어들을 번호와 함께 출력
		//	수정할 단어를 선택
		printSerachWord(list, wordCount, word);
		System.out.print("수정할 단어의 번호를 선택하세요  : ");
		int num = scan.nextInt();
		boolean res = checkWord(list, word, num-1);
		if (!res) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		//수정한 단어, 품사, 의미를 입력
		//입력한 정보로 선택한 단어를 수정
		Word tmp = inputWord();
		list[num-1].updateWord(tmp);
		list[num-1].print();
		//	단어 리스트 정렬
		wordSort(list, wordCount);
		System.out.println("단어를 수정했습니다.");
	}
	
	/** 단어 리스트에 단어가 있으면 해당 단어를 출력하고 없으면 없다고 출력하는 메소드
	 *  @param list 단어 리스트
	 *  @param word 단어
	 *  @param wordCount 저장된 단어 수
	 */
	public static void printSerachWord(Word[] list, int wordCount, String word) {
		int count = 0; //일치하는 단어가 몇개 있는지 확인하는 변수
		//	단어 리스트에 수정할 단어와 일치하는 단어들을 번호와 함께 출력
		for (int i = 0; i < wordCount; i++) {
			if (word.equals(list[i].getWord())){
				System.out.println((i+1)+"번.");
				list[i].print();
				count++;
			}
		}
		if (count == 0) {
			System.out.println("수정할 단어가 없습니다.");
			return;
		}
	}
	
	/** 배열의 index번지에 요소를 삭제하는 메소드
	 * @param list 단어 리스트
	 * @param wordCount 단어 수
	 * @param index 삭제할 위치
	 * @return 삭제된 후 단어 수
	 */
	public static int deleteWordlist(Word[] list, int wordCount, int index) {
		
		Word[] tmp = new Word[list.length];
		//올바른 선택이면 삭제
		//삭제하려는 번지 다음에 있는 단어들부터 앞으로 한칸씩 당기고 마지막 단어를 null로 만듦
		//저장된 단어수를 1감소
		if(wordCount - index -1 != 0) {
			System.arraycopy(tmp, index+1, list, index, wordCount-index-1);
		}
		wordCount--;
		list[wordCount] = null;
		return wordCount;
	}
	
	
}   //클래스 끝



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
	/** 새 단어 정보가 주어지면 수정하는 메소드
	 * 	@param word 새 단어 정보
	 */
	public void updateWord(Word word) {
		this.word = word.word;
		this.wordClass = word.wordClass;
		this.meaning = word.meaning;
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