package day13;

import java.util.Calendar;

public class CalendarEx01 {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);//년을 추출 int year = cal.get(1);
		int month = cal.get(Calendar.MONTH);//월을 추출 int year = cal.get(2);
		int day = cal.get(Calendar.DAY_OF_MONTH); // int year = cal.get(5);
		System.out.println(year+"-"+(month+1)+"-"+day);   //month는 0~11이 나오기때문에 +1
		
	}

}
