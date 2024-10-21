package kr.kh.final_project.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuVO {

	private int Res_id;
	private String menu;
	private String menu_e;
	private int menu_price;
	private int menu_count;
}
