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
		reviewDao.updateRev0();
		return reviewDao.updateRevAll(); 
	}

	public List<ReportVO> getReport() {
		return reportDao.select_all_report();
	}

	public ReviewVO getRev_rep(int rev_id) {
		return reviewDao.select_review(rev_id);
	}

	public boolean insertRep(int rev_id, String reason) {
		ReviewVO rev = reviewDao.select_review(rev_id);
		return reportDao.insert_report(rev,reason);
		
	}

	public ReportVO getReport_rev(int rev_id) {
		return reportDao.select_report(rev_id);
	}

	public boolean update_rep(ReportVO rep) {
		return reportDao.update_report(rep);
		
	}

	public boolean update_rev(ReviewVO rev) {
		reviewDao.updateRev0();
		reviewDao.updateRev(rev);
		return reviewDao.updateRevAll();
		
	}

	
	
}
