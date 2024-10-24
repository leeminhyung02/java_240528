package kr.kh.final_project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.final_project.model.vo.MenuVO;
import kr.kh.final_project.model.vo.RestaurantVO;

public interface RestaurantDAO {

	List<RestaurantVO> selectRestaurant_list();

	RestaurantVO selectRestaurant(int res_id);

	List<RestaurantVO> selectRestaurant_list_all();

	//true로 바꾸기
	void updatepermission_true(int res_id);

	//false로 바꾸기
	void updatepermission_false(int res_id);

	boolean insertRes(@Param("res")RestaurantVO res, @Param("user_id")String user_id);

	List<RestaurantVO> selectRestaurant_list_user(@Param("user_id")String user_id);

	boolean update_Res(@Param("res")RestaurantVO res);

	boolean insertMenu(int res_id, @Param("menu")MenuVO menu);

	List<RestaurantVO> selectRestaurant_list_by_type(String type);

	List<MenuVO> select_Menu_List(int res_id);


	
}
