package java_hotel.service;

import java_hotel.model.vo.CustomerVO;

public interface MemberService {

	CustomerVO loginmember(String mb_id, String mb_password);

	boolean Register(String mb_id, String mb_password, String mb_name, String mb_email);


	boolean update(CustomerVO loginmember, CustomerVO newUser);

	CustomerVO refresh(String mb_id);

	boolean deleteMember(CustomerVO loginmember);

}
