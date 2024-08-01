package java_hotel.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReservationVO {

	private long rv_id;
	private Date rv_date;
	private int rv_room_num;
	private Date rv_start_date;
	private Date rv_end_date;
	private String rv_statu;
	private int rv_total_price; 
	private int rv_stay_person; 
	private String mb_id;
	
	public ReservationVO(Date startdate, Date enddate, int rv_room_num, String mb_id) {
		this.rv_date = new Date();
		this.rv_start_date = startdate;
		this.rv_end_date = enddate;
		this.rv_room_num = rv_room_num;
		this.mb_id = mb_id;
	}
}
