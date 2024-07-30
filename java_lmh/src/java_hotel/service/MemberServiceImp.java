package java_hotel.service;

import java.io.IOException;
import java.io.InputStream;

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

	public boolean insertMember(CustomerVO cus) {
		if(cus == null) {
			return false;
		}
		CustomerVO dbcus = memberDao.selectMember(cus);
		if(dbcus != null) {
			return false;
		}
		return memberDao.insertMember(cus);
	}

	public boolean loginmember(CustomerVO cus) {
		if(cus == null) {
			return false;
		}
		CustomerVO dbcus = memberDao.selectMember(cus);
		if(dbcus.getMb_id().equals(cus.getMb_id()) && dbcus.getMb_password().equals(cus.getMb_password())){
			return true;
		}
		return false;
	}

	public void searchmember(CustomerVO cus) {
		if(cus == null) {
			System.out.println("찾기 실패");
			return;
		}
		CustomerVO dbcus = memberDao.selectMember(cus);
		if(dbcus.getMb_id().equals(cus.getMb_id())){
			System.out.println("검색 결과:");
			System.out.println(dbcus);
			return;
		}
		System.out.println("찾기 실패");
	}

	public void updatemember(CustomerVO cus) {
		
	}

	public boolean contains(CustomerVO cus) {
		if(cus == null) {
			return false;
		}
		CustomerVO dbcus = memberDao.selectMember(cus);
		return dbcus != null;
	}
}
