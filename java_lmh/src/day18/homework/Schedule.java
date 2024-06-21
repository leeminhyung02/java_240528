package day18.homework;

import java.io.Serializable;

import lombok.Data;

@Data
public class Schedule implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -2014863073736704687L;

	/**
	 * date : 날짜 (yyyy-MM-dd hh:mm) 정규 표현식
	 * schedule : 일정 (String)
	 * info : 상세 (String)
	 */
	
	private String schedule;
	private String info;
	private String date;
	static final String regex = "\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]) ([0-1][0-9]|2[0-3]):([0-5][0-9])";
	
	public Schedule(String schedule, String info, String date) {
		this.schedule = schedule;
		this.info = info;
		this.date = date;
	}

	@Override
	public String toString() {
		return date + " : "+ schedule+ " - "+ info;
	}
	
	
	
	
}
