package kr.kh.final_project.dao;

import org.apache.ibatis.annotations.Param;

import kr.kh.final_project.model.vo.UserVO;

public interface UserDAO {

	boolean signup(@Param("user") UserVO user);

	UserVO selectUser(@Param("user_id")String user_id);

	
}
