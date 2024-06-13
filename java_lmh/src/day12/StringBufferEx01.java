package day12;

public class StringBufferEx01 {

	public static void main(String[] args) {
		//String과 차이는 String은 수정이 아니라 교체, StringBuffer는 수정을함
		//프로그램내에서 문자열 수정이 자주 일어난다. => StringBuffer을 이용
		StringBuffer sb = new StringBuffer("Hello world");
		
		sb.append("!");
		System.out.println(sb);
		
		sb.insert(0, "\"");
		System.out.println(sb);
		sb.append("\"");
		System.out.println(sb);
		
		sb.delete(6, sb.length()-1);
		System.out.println(sb);
	}

}
