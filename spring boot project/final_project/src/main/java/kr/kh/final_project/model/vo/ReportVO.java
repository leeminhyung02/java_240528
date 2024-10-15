package kr.kh.final_project.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReportVO {

	private int Rev_id; 
	private String rep_reason; 
	private boolean res_state;
	private String rev_content;
	private boolean rep_result;
}
