package kr.kh.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.final_project.dao.RestaurantDAO;
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

}
