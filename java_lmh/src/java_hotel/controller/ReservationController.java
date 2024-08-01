package java_hotel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import java_hotel.model.vo.CustomerVO;
import java_hotel.model.vo.ReservationVO;
import java_hotel.service.ReservationService;
import java_hotel.service.ReservationServiceImp;

public class ReservationController {
	
	private ReservationService reservationService = new ReservationServiceImp();
	private Scanner scanner;
	
	public ReservationController(Scanner scan) {
		this.scanner = scan;
	}

	public ReservationVO makeReservation(CustomerVO loginmember) {
		System.out.println("날짜를 정해주세요  (예시 : 2024-01-01");
		System.out.print("시작 날짜 : ");
		String start_date = scanner.nextLine();
		System.out.print("종료 날짜 : ");
		String end_date = scanner.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date startdate = format.parse(start_date);
			Date enddate = format.parse(end_date);
			if(startdate.compareTo(enddate) >= 0) {
				System.out.println("날짜를 잘못입력하셨습니다.");
				return null;
			}
			//몇일간 예약했는지 계산
			long days = calculate(startdate,enddate);
			//해당 날짜에 가능한 방 출력
			/* 끝나는 날짜가 예약되있는 시작날짜보다 앞에있어야함
			 *
			 * 시작하는 날짜가 예약되있는 종료날짜보다 뒤에 있어야함
			 */
			
			//날짜에 맞는 방 선택
			System.out.println("원하는 방의 번호를 선택해주세요 : ");
			int rv_room_num = scanner.nextInt(); 
			System.out.println(startdate+"~"+enddate+"까지 "+days+"일간 예약했습니다.");
			return reservationService.reservation(startdate, enddate, rv_room_num, loginmember.getMb_id());
		} catch (ParseException e) { 
			System.out.println("날짜를 잘못입력하였습니다.");
			return null;
		}

	}

	private long calculate(Date startdate, Date enddate) {
		long diffdays = (enddate.getTime() - startdate.getTime()) /1000;
		diffdays = diffdays / (24*60*60);
		return diffdays;
	}


}
