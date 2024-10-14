package kr.kh.final_project.dao;

import java.util.List;

import kr.kh.final_project.model.vo.RestaurantVO;

public interface RestaurantDAO {

	List<RestaurantVO> selectRestaurant_list();

	RestaurantVO selectRestaurant(int res_id);

	List<RestaurantVO> selectRestaurant_list_no_per();

	void updatepermission(int res_id);

	void updatepermission2(int res_id);

	
}
