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


	public List<RestaurantVO> getRes_per_no() {
		return RestaurantDao.selectRestaurant_list_no_per();
	}

	public void updatepermission(int res_id) {
		RestaurantDao.updatepermission(res_id);
		
	}

	public List<RestaurantVO> getResall() {
		return RestaurantDao.selectRestaurant_list();
	}

	public void updatepermission2(int res_id) {
		RestaurantDao.updatepermission2(res_id);
	}

}
