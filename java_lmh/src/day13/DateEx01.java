package day13;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx01 {

	public static void main(String[] args) throws ParseException {
		/*
		 * 
		 */
		
		Date date = new Date();
		System.out.println(date); 
		//날짜 -> 문자열로
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String datestr = format1.format(date);
		System.out.println(datestr);
		
		
		SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr2 =  format2.format(date);
		System.out.println(datestr2);
		
		SimpleDateFormat format3 = new SimpleDateFormat("yyyy년 MM월 HH시 mm분 ss초");
		String datestr3 =  format3.format(date);
		System.out.println(datestr3);
		
		//문자열 -> 날짜
		//포맷이 안맞는 경우 예외가 발생할 수 있다.
		String datestr4 = "2024-06-14 09:22";
		SimpleDateFormat format4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date4 = format4.parse(datestr4);
		System.out.println(date4);
		
		
		
		
		
		
		
		
		
	}
 
}
