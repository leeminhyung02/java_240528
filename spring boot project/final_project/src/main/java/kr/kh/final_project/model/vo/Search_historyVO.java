package kr.kh.final_project.model.vo;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class Search_historyVO {
	private int SH_id; 
	private String s_history; 
	private Date his_date; 
	private String User_id;
}
