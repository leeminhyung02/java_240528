package ex;

public class Solution {
	public int solution(int n) {
		int answer = 0;
		return answer;

	}
	public int fiv(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fiv(n-1)+fiv(n-2);
	}
}
