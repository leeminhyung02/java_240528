package kr.kh.final_project.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Mail {

	private String to;
	
	private String title;
	
	private String content;
}
