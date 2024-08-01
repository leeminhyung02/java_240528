package java_hotel.service;

import java.util.Date;

import java_hotel.model.vo.ReservationVO;

public interface ReservationService {

	ReservationVO reservation(Date startdate, Date enddate, int rv_room_num, String mb_id);

}
