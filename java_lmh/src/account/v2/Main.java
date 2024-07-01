package account.v2;

import java.text.ParseException;

public class Main {

	public static void main(String[] args) {
		Item item;
		try {
			item = new Item("2024-07-01", "수입", "월급", 1000000, "7월 월급");
			System.out.println(item);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
