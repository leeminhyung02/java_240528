package java_hotel.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import java_hotel.model.vo.ReservationVO;

public interface ReservationDAO {

	ReservationVO selectRes(@Param("rv_start_date")Date rv_start_date, @Param("rv_end_date")Date rv_end_date, @Param("rv_room_num")int rv_room_num);

}
