package day01;

public class Ex1 {

	public static void main(String[] args) {
		String s = "1 2 Z 4";
		String[] arr = s.split(" ");
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			if(i == arr.length-1 && !arr[arr.length-1].equals("Z")) {
				int index = Integer.parseInt(arr[i]);
				result += index;
				break;
			}
			if (i + 1 <= arr.length && arr[i + 1].equals("Z")) {
				i++;
				continue;
			} else {
				int index = Integer.parseInt(arr[i]);
				result += index;
			}
		}
		System.out.println(result);
	}

}
