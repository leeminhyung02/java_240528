package java_hotel.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java_hotel.dao.MemberDAO;
import java_hotel.dao.ReservationDAO;
import java_hotel.model.vo.ReservationVO;

public class ReservationServiceImp implements ReservationService {

	private ReservationDAO reservationDao;
	
	public ReservationServiceImp() {
		String resource = "java_hotel/config/mybatis-config.xml";
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			reservationDao = session.getMapper(ReservationDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ReservationVO reservation(Date startdate, Date enddate, int rv_room_num, String mb_id) {
		ReservationVO res = reservationDao.selectRes(startdate,enddate,rv_room_num);
		return null;
	} 
	 
}
