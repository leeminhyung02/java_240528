package day19.board;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import program.Program;

public class BoardManager implements Program {

	Scanner scan = new Scanner(System.in);
	List<Board> list = new ArrayList<Board>();

	public void printBar() {
		System.out.println("--------------------------");

	}

	private final int INSERT = 1;
	private final int UPDATE = 2;
	private final int DELETE = 3;
	private final int SEARCH = 4;
	private final int EXIT = 5;

	private String fileName = "src/day19/board/data.txt";

	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 조회");
		System.out.println("5. 프로그램 종료");
		System.out.println("--------------------------");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch (menu) {
		case INSERT: // 등록
			insert();
			break;
		case UPDATE: // 수정
			update();
			break;
		case DELETE: // 삭제
			delete();
			break;
		case SEARCH: // 조회
			search();
			break;
		case EXIT: // 종료
			exit();
			break;
		default:

		}

	}

	private void exit() {
		printBar();
		System.out.println("프로그램을 종료합니다.");
		printBar();
		
	}

	private void insert() {

		// 게시글 정보를 입력
		System.out.println("--------------------------");
		System.out.print("제목 : ");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();
		System.out.print("작성자 : ");
		String id = scan.nextLine();
		System.out.print("비번 : ");
		String pw = scan.nextLine();
		// 입력한 정보를 이용해서 게시글 객체를 생성
		Board b = new Board(title, contents, id, pw);
		// 생성한 게시글 객체를 리스트에 추가
		list.add(b);
		// 알림문구를 출력
		System.out.println("--------------------------");
		System.out.println(b.getNum() + "번 게시글이 추가되었습니다.");
		System.out.println("--------------------------");
	}

	private void update() {
		//수정할 게시글 번호를 입력
		System.out.print("수정할 게시글 번호");
		int num = scan.nextInt();
		printBar();
		
		Board board = selectBoard(num);
		if (board == null) {
			return;
		}
		//같으면 새 제목과 내용을 입력
		scan.nextLine();
		System.out.print("제목 : ");
		String title = scan.nextLine();
		System.out.print("내용 : ");
		String contents = scan.nextLine();
		
		//가져온 객체의 제목과 내용을 입력받은 제목과 내용으로 수정
		board.update(title, contents);
		//안내문구 출력
		printBar();
		System.out.println(board.getNum()+"번 게시글이 수정되었습니다.");
		
		
		
		/*
		if(checksize());
		System.out.println("--------------------------");
		System.out.print("수정할 게시글 번호 : ");
		int n = scan.nextInt() - 1;
		System.out.println("--------------------------");
		scan.nextLine();
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("비번 : ");
		String pw = scan.nextLine();
		if(list.get(n).checkWriter(id, pw)) {
			System.out.print("제목 : ");
			String title = scan.nextLine();
			list.get(n).setTitle(title+"(수정)");
			System.out.print("내용 : ");
			String contents = scan.nextLine();
			list.get(n).setContents(contents+"(수정)");
			printBar();
			System.out.println(list.get(n).getNum()+"번 게시글이 수정되었습니다.");
			return;
		}
		else {
			System.out.println("아이디와 비밀번호가 틀립니다.");
		}
		*/
	}


	private void delete() {
		//삭제할 게시글 번호를 입력
		
		//게시글 번호에 맞는 게시글을 가져옴
		
		//게시글이 없으면 종료
		
		//리스트에서 게시글을 삭제
		System.out.print("수정할 게시글 번호");
		int num = scan.nextInt();
		printBar();
		
		Board board = selectBoard(num);
		if (board == null) {
			return;
		}
		/*
		System.out.println(board.getNum()+"번 게시글을 삭제 했습니다.");
		list.remove(board);
		*/
		if(list.remove(board)) {
			printBar();
			System.out.println(board.getNum()+"번 게시글이 삭제되었습니다.");
		}
		
		
		/*
		System.out.println("--------------------------");
		System.out.print("삭제할 게시글 번호 : ");
		int n = scan.nextInt() - 1;
		System.out.println("--------------------------");
		scan.nextLine();
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("비번 : ");
		String pw = scan.nextLine();
		if(list.get(n).checkWriter(id, pw)) {
			// 삭제하기
			list.remove(n);
			System.out.println("게시글을 삭제 했습니다.");			
		}
		*/
	//게시글 번호가 주어지면 게시글을 가져오는 메소드(아이디, 비번 확인해서)
	}
	public Board selectBoard(int num) {
		//입력한 게시글 번호를 이용하여 게시글 객체를 생성
				Board board = new Board(num);
				//리스트에서 생성한 객체가 몇번지에 있는지 번지를 가져옴
				int index = list.indexOf(board);
				//일치하는 객체가 없으면(가져온 번지가 0보다 작으면) 알림문구 출력 후 종료
				if(index < 0) {
					printBar();
					System.out.println("등록되지 않거나 삭제된 게시글 입니다.");
					return null;
				}
				//아이디, 비번을 입력받
				System.out.print("아이디 : ");
				String id = scan.next();
				System.out.print("비번 : ");
				String pw = scan.next();
				
				//가져온 객체의 아이디와 비번이 입력받은 아이디와 비번과 같은지 확인해서
				//같지 않으면 안내문구 출력 후 종료
				board = list.get(index);
				if(!board.checkWriter(id, pw)) {
					printBar();
					System.out.println("아이디 또는 비번이 잘못 됐습니다.");
					return null;
				}
				return board;
	}

	private void search() {
		//검색어 입력
		scan.nextLine();
		System.out.print("검색어 (전체는 엔터) : ");
		String s = scan.nextLine();
		printBar();
		//게시글에서 검색어가 제목 또는 내용에 들어간 게시글리스트를 가져옴
		List<Board>tmplist = getTmplist(s);
		//게시글 리스트가 비어 있으면 안내문구 출력 후 종료
		if (tmplist.size() == 0) {
			System.out.println("검색어와 일치하는 게시글이 없습니다.");
			return;
		}
		//가져온 게시글 리스트를 출력
		printlist(tmplist);
		printBar();
		//게시글을 확인할건지 선택
		System.out.println("게시글을 확인하겠습니까? (y/n)");
		char ok = scan.next().charAt(0);
		
		//확인하지 않겠다고 하면 종료
		if( ok !='y') {
			return;
		}
		//확인하면 게시글 번호를 입력
		printBar();
		System.out.println("검색 결과중 확인할 게시글 번호: ");
		int num = scan.nextInt();
		//입력받은 게시글 번호로 객체를 생성
		Board board = new Board(num);
		//검색 리스트에서 생성된객체와 일치하는 번지를 확인해서
		int index = tmplist.indexOf(board);
		
		//번지가 유효하지 않으면 안내문구 출력후 종료
		printBar();
		if(index < 0) {
			System.out.println("검색 결과에는 없는 게시글입니다.");
			return;
		}
		//번지에 있는 게시글을 가져옴
		board = tmplist.get(index);
		//가져온 게시글을 출력
		board.print();
		//메뉴로 돌아가려면... 문구 출력
		printBar();
		System.out.println("메뉴로 돌아가려면 엔터를 치세요.");
		//엔터를 입력받도록 처리
		scan.nextLine();
		scan.nextLine();// 입력한 엔터 처리
		/*
		System.out.println("--------------------------");
		System.out.print("검색어 (전체는 엔터) : ");
		scan.nextLine();
		String s = scan.nextLine();
		System.out.println("--------------------------");
		System.out.println("검색 결과");
		list.stream().filter(o -> o.getTitle().contains(s)).forEach(o -> System.out.println(o));
		System.out.println("--------------------------");
		System.out.print("게시글을 확인하시겠습니다까? (Y/N) ");
		String ch = scan.next();
		if (ch.equals("y") || ch.equals("Y")) {
			System.out.print("검색 결과중 확인할 게시글 번호 선택 : ");
			int n = scan.nextInt() - 1;
			System.out.println("--------------------------");
			list.get(n).print();
			System.out.println("--------------------------");
		} else if (ch.equals("n") || ch.equals("N")) {
			return;
		} else {
			System.out.println("잘못 입력하셨습니다.   : " + ch);
			return;
		}
		System.out.println("메뉴로 돌아가려면 엔터를 치세요");
		scan.nextLine();
		scan.nextLine();
		return;
		*/
	}

	private void printlist(List<Board> tmplist) {
		for(Board board : tmplist) {
			System.out.println(board);
		}
		
	}

	private List<Board> getTmplist(String s) {
		//스트림을 이용하여 검색어와 일치하는 게시글 리스트를 가져옴
		return list.stream()
				.filter(b->b.getTitle().contains(s)|| b.getContents().contains(s))
				.collect(Collectors.toList());
	}

	@Override
	public void run() {
		int menu;
		load(fileName);
		do {
			// 메뉴 출력
			printMenu();
			// 메뉴 선택
			menu = scan.nextInt();
			// 선택한 메뉴 실행
			try {
				runMenu(menu);
			} catch (Exception e) {
				System.out.println("예외가 발생했습니다.");
				e.printStackTrace();
			}

		} while (menu != 5);

		save(fileName);
	}

	@Override
	public void save(String fileName) {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.write(Board.getCount());
			oos.writeObject(list);
		} catch (IOException e) {
			System.out.println("저장실패");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void load(String fileName) {
		try (FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			int count = ois.read();
			Board.setCount(count);
			list = (List<Board>) ois.readObject();
		} catch (Exception e) {
			System.out.println("불러오기실패");
		}
	}

}
