package kr.kh.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.final_project.dao.ReportDAO;
import kr.kh.final_project.dao.ReviewDAO;
import kr.kh.final_project.model.vo.ReportVO;
import kr.kh.final_project.model.vo.ReviewVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReviewService {

	@Autowired
	private ReviewDAO reviewDao;

	@Autowired
	private ReportDAO reportDao;
	
	public List<ReviewVO> getRev(int res_id) {
		return reviewDao.select_all_review(res_id);
	}

	public boolean insertRev(ReviewVO review) {
		review.setScore(review.getScore()*2);
		reviewDao.insertRev(review);
		return reviewDao.updateRevAll();  
	}

	public List<ReportVO> getReport() {
		return reportDao.select_all_report();
	}

	public ReviewVO getRev_rep(int rev_id) {
		return reviewDao.select_review(rev_id);
	}
	
	
}
