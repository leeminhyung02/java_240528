package ex;

public class Ex12 {
	public static void main(String [] args) {
		int n = 105;
		int count = 0;
		for (int j = 1; j <= n; j++) {
			int sum = 0;
			for (int i =j; i<=n; i++) {
				sum+=i;
				if (sum == n) {
					count++;
					break;
				}
			}
		}
		System.out.println(count);
	}
}
