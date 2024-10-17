package kr.kh.final_project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.final_project.model.vo.ReportVO;
import kr.kh.final_project.model.vo.Report_manageVO;
import kr.kh.final_project.model.vo.ReviewVO;

public interface ReportDAO {

	List<ReportVO> select_all_report();

	boolean insert_report(@Param("rev")ReviewVO rev, @Param("reason")String reason);

	ReportVO select_report(@Param("rev_id")int rev_id);

	boolean update_report(@Param("rep")ReportVO rep);

	List<Report_manageVO> select_Report_manage();

}
