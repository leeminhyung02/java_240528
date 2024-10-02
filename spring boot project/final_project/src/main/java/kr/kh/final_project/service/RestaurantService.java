package kr.kh.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.final_project.dao.RestaurantDAO;
import kr.kh.final_project.model.vo.RestaurantVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RestaurantService {

	@Autowired
	private RestaurantDAO RestaurantDao;

	public List<RestaurantVO> show_Restaurant() {
		return RestaurantDao.selectRestaurant_list();
	}

	public RestaurantVO getRes(int res_id) {
		return RestaurantDao.selectRestaurant(res_id);
	}

}
