package kr.kh.final_project.dao;

import java.util.List;

import kr.kh.final_project.model.vo.RestaurantVO;

public interface RestaurantDAO {

	List<RestaurantVO> selectRestaurant_list();

	RestaurantVO selectRestaurant(int res_id);

	
}
