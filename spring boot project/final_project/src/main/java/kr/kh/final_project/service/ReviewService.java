package kr.kh.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.final_project.dao.ReviewDAO;
import kr.kh.final_project.model.vo.ReviewVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReviewService {

	@Autowired
	private ReviewDAO reviewDao;

	public List<ReviewVO> getRev(int res_id) {
		return reviewDao.select_all_review(res_id);
	}
	
	
}
