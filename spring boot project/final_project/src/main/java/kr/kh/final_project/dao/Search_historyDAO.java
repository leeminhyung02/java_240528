package kr.kh.final_project.dao;

import kr.kh.final_project.model.vo.Search_historyVO;

public interface Search_historyDAO {

	boolean insert_SH(String username, String search);

	Search_historyVO is_searched(String username, String search);

	void update_SH(String username, String search);


	
}
