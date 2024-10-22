package kr.kh.final_project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.final_project.model.vo.FavoritesVO;
import kr.kh.final_project.model.vo.Report_manageVO;
import kr.kh.final_project.model.vo.Search_historyVO;
import kr.kh.final_project.model.vo.UserVO;

public interface UserDAO {

	boolean signup(@Param("user") UserVO user);

	UserVO selectUser(@Param("user_id")String user_id);

	boolean insert_fav(@Param("User_id")String User_id, @Param("res_id")int res_id);

	List<Search_historyVO> select_SH(@Param("User_id")String User_id);

	List<FavoritesVO> get_fav(@Param("User_id")String User_id);

	boolean delete_fav(@Param("User_id")String User_id, @Param("res_id")int res_id);

	boolean updatecaution(@Param("user")UserVO user);

	boolean update_report(@Param("user")UserVO user);

	boolean signup_biz(@Param("user")UserVO user);

	UserVO selectUser_id(@Param("value")String value);

	UserVO selectUser_email(@Param("value")String value);

	

	
}
