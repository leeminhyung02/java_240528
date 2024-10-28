package kr.kh.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.final_project.dao.RestaurantDAO;
import kr.kh.final_project.model.vo.MenuVO;
import kr.kh.final_project.model.vo.RestaurantVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class Restaurantservice {

	@Autowired
	private RestaurantDAO RestaurantDao;

	public List<RestaurantVO> show_Restaurant() {
		return RestaurantDao.selectRestaurant_list();
	}

	public RestaurantVO getRes(int res_id) {
		return RestaurantDao.selectRestaurant(res_id);
	}


	public List<RestaurantVO> getRes_all() {
		return RestaurantDao.selectRestaurant_list_all();
	}

	public void updatepermission(int res_id) {
		RestaurantDao.updatepermission_true(res_id);
		
	}

	public void updatepermission2(int res_id) {
		RestaurantDao.updatepermission_false(res_id);
	}

	public boolean insertRes(RestaurantVO res, String user_id) {
		return RestaurantDao.insertRes(res, user_id);
	}

	public List<RestaurantVO> getRes_user(String user_id) {
		return RestaurantDao.selectRestaurant_list_user(user_id);
	}

	public boolean update_Res(RestaurantVO res) {
		return RestaurantDao.update_Res(res);
		
	}

	public boolean insertMenu(int res_id, MenuVO menu) {
		return RestaurantDao.insertMenu(res_id, menu);
	}


	public List<RestaurantVO> show_Restaurant(String type) {
		return RestaurantDao.selectRestaurant_list_by_type(type);
	}

	public List<MenuVO> get_Menu_List(int res_id) {
		return RestaurantDao.select_Menu_List(res_id);
	}

	public boolean updateMenu(int res_id, MenuVO menu) {
		// menu_code를 이용하여 update
		List<MenuVO> menu_list = RestaurantDao.select_Menu_List(res_id);
		if(menu.getMenu_code() != 0) {
			//이미 있는 메뉴일경우 update
			return RestaurantDao.update_Menu(res_id, menu);
		}
		else {
			//없는 메뉴는 추가
			return RestaurantDao.insertMenu(res_id, menu);
		}
		
	}

	public boolean remove(Integer code) {
		return RestaurantDao.deleteMenu(code);
		
	}

	public String get_Menu_name(String string) {
		Integer i = Integer.parseInt(string);
		MenuVO m = RestaurantDao.select_Menu_name(i);
		return m.getMenu_name();
	}

}
