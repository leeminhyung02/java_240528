package kr.kh.final_project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.final_project.model.vo.FavoritesVO;
import kr.kh.final_project.model.vo.Search_historyVO;
import kr.kh.final_project.model.vo.UserVO;

public interface UserDAO {

	boolean signup(@Param("user") UserVO user);

	UserVO selectUser(@Param("user_id")String user_id);

	boolean insert_fav(@Param("User_id")String User_id, @Param("res_id")int res_id);

	List<Search_historyVO> select_SH(@Param("User_id")String User_id);

	List<FavoritesVO> get_fav(@Param("User_id")String User_id);

	
}
