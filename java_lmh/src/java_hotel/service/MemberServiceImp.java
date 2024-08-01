package java_hotel.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java_hotel.dao.MemberDAO;
import java_hotel.model.vo.CustomerVO;


public class MemberServiceImp implements MemberService{

	private MemberDAO memberDao;
	
	public MemberServiceImp() {
		String resource = "java_hotel/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public CustomerVO loginmember(String mb_id, String mb_password) {
		CustomerVO user = memberDao.selectMember(mb_id);
		if(user == null) {
			//로그인 실패
			return null;
		}
		if(user.getMb_password().equals(mb_password)) {
			//로그인 성공
			return user;
		}
		//로그인 실패
		return null;
	}

	@Override
	public boolean Register(String mb_id, String mb_password, String mb_name, String mb_email) {
		CustomerVO user = memberDao.selectMember(mb_id);
		if(user != null) {
			return false;
		}
//		String idRegex = "^\\w{6,13}$";
//		if(!Pattern.matches(idRegex, mb_id)) {
//			return false;
//		}
//		//비번이 정규 표현식에 맞지 않으면 false를 리턴
//		String pwRegex = "^[a-zA-Z0-9!@#$]{6,15}$";
//		if(!Pattern.matches(pwRegex, mb_password)) {
//			return false;
//		}
		return memberDao.insertMember(mb_id,mb_password,mb_name,mb_email);
	}

	@Override
	public boolean update(CustomerVO loginmember, CustomerVO newUser) {
		if (loginmember == null || newUser == null) {
			return false;
		}
		loginmember = memberDao.selectMember(loginmember.getMb_id());
		CustomerVO dbuser = memberDao.selectMember(newUser.getMb_id());
		if(dbuser != null && !loginmember.equals(dbuser)) {
			return false;
		}
		newUser.setMb_no(loginmember.getMb_no());
		return memberDao.updateMember(newUser);
	}

	@Override
	public CustomerVO refresh(String mb_id) {

		return memberDao.selectMember(mb_id);
	}

	@Override
	public boolean deleteMember(CustomerVO loginmember) {
		if(loginmember == null) {
			return false;
		}
		return memberDao.deleteMember(loginmember.getMb_id());
	}


	
}
