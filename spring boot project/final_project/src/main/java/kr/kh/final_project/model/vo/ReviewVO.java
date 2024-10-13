package kr.kh.final_project.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReviewVO {

	private int Rev_id; 
	private String content; 
	private int score; 
	private String User_id; 
	private int Res_id;
}
