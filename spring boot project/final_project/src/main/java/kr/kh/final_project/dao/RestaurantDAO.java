package kr.kh.final_project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.final_project.model.vo.RestaurantVO;

public interface RestaurantDAO {

	List<RestaurantVO> selectRestaurant_list();

	RestaurantVO selectRestaurant(int res_id);

	List<RestaurantVO> selectRestaurant_list_all();

	void updatepermission(int res_id);

	void updatepermission2(int res_id);

	boolean insertRes(@Param("res")RestaurantVO res, @Param("user_id")String user_id);

	List<RestaurantVO> selectRestaurant_list_user(@Param("user_id")String user_id);

	
}
