package java_hotel.dao;

import org.apache.ibatis.annotations.Param;

import java_hotel.model.vo.CustomerVO;

public interface MemberDAO {

	CustomerVO selectMember(@Param("mb_id")String mb_id);

	boolean insertMember(@Param("mb_id")String mb_id, @Param("mb_password")String mb_password, @Param("mb_name")String mb_name, @Param("mb_email")String mb_email);


	boolean updateMember(@Param("new")CustomerVO newUser);

	boolean deleteMember(@Param("mb_id")String mb_id);



}
