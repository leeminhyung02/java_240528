package kr.kh.final_project.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVO {

	private String User_id; 
	private String user_type; 
	private String user_name; 
	private String user_pw; 
	private String user_email; 
	private int user_report;
	private Date user_freeze;
}
