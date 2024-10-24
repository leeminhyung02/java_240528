package kr.kh.final_project.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuVO {

	private int Res_id;
	private String menu_name;
	private String menu_e;
	private int menu_price;
	private int menu_code;
	private int menu_count;
}
