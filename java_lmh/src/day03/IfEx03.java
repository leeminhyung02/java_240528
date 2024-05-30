package day03;

public class IfEx03 {
	public static void main(String[] args) {
	int num = -1;
	
		if(num == 0) {
			System.out.println("0");
		}
		else if( num >0) {
			System.out.println(num+":  양수");
		}
		else {
			System.out.println(num+": 음수");
		}
	}
}
