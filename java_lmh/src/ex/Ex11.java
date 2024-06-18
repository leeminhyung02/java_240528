package ex;


public class Ex11 {

	public static void main(String[] args) {
		for (int i = 0; i <100; i++) {
			
		}
	}
	public static int fiv(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return (fiv(n-1)+fiv(n-2));
	}
}
