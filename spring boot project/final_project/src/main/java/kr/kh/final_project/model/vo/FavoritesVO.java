package kr.kh.final_project.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FavoritesVO {

	private int Fav_id; 
	private String User_id; 
	private int Res_id;
}
