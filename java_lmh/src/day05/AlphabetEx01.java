package day05;

public class AlphabetEx01 {

	public static void main(String[] args) {
		/* a
		 * ab
		 * abc
		 * .....
		 * a~z
		 * 
		 */
		char ch = 'a';

		for (int i = 0; i<=25; i++) {
			for (int j = 0; j<=i; j++) {
				System.out.print((char)('a'+j));
			}
			System.out.println();
		}
	}

}
