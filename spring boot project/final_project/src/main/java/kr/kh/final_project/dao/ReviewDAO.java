package kr.kh.final_project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.final_project.model.vo.ReviewVO;

public interface ReviewDAO {

	List<ReviewVO> select_all_review(int res_id);

	boolean insertRev(@Param("review")ReviewVO review);

	ReviewVO select_review(int rev_id);

	boolean updateRevAll();

	
}
