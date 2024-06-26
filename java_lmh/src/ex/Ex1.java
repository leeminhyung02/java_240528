package ex;

public class Ex1 {
	public static void main(String[] args) {
		int []A = {1,22,3,4,5,6,7};
		for(int i = 0; i< A.length-1; i++) {
			if(A[i] >A[i+1]) {
				int tmp = A[i];
				A[i] = A[i+1];
				A[i+1] = tmp;
			}
		}
		for(int tmp : A) {
			System.out.println(tmp);
		}
		for(int i = 0; i< A.length-1; i++) {
			if(A[i] <A[i+1]) {
				int tmp = A[i];
				A[i] = A[i+1];
				A[i+1] = tmp;
			}
		}
		for(int tmp : A) {
			System.out.println(tmp);
		}
		
	} 
	
}
