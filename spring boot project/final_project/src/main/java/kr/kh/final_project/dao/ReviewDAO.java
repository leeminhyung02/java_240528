package kr.kh.final_project.dao;

import java.util.List;

import kr.kh.final_project.model.vo.ReviewVO;

public interface ReviewDAO {

	List<ReviewVO> select_all_review(int res_id);

	
}