package kr.kh.final_project.dao;

import java.util.List;

import kr.kh.final_project.model.vo.ReportVO;

public interface ReportDAO {

	List<ReportVO> select_all_report();

}
