package java_hotel.dao;

import org.apache.ibatis.annotations.Param;

import java_hotel.model.vo.CustomerVO;

public interface MemberDAO {

	CustomerVO selectMember(@Param("cus")CustomerVO cus);

	boolean insertMember(@Param("cus")CustomerVO cus);

	boolean updateMember(@Param("new")CustomerVO newCustomer);

	void deleteMember(@Param("cus")CustomerVO cus);

}
