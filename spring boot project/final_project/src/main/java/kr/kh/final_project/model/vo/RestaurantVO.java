package kr.kh.final_project.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RestaurantVO {

	private int Res_id; 
	private String address; 
	private String res_name; 
	private String res_type; 
	private float res_score;
	private boolean permission; 
	private String res_info; 
	private String res_banner; 
	private String User_id;
}
