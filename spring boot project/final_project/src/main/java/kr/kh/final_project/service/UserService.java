package kr.kh.final_project.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.final_project.dao.ReportDAO;
import kr.kh.final_project.dao.Search_historyDAO;
import kr.kh.final_project.dao.UserDAO;
import kr.kh.final_project.model.vo.FavoritesVO;
import kr.kh.final_project.model.vo.Report_manageVO;
import kr.kh.final_project.model.vo.Search_historyVO;
import kr.kh.final_project.model.vo.UserVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

	@Autowired
	UserDAO userDao;

	@Autowired
	Search_historyDAO search_historyDao;

	@Autowired
	ReportDAO reportDao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public boolean signup_user(UserVO user) {
		String pw = passwordEncoder.encode(user.getUser_pw());
		user.setUser_pw(pw);
		return userDao.signup(user);
	}

	public boolean insert_SH(String username, String search) {
		Search_historyVO s_h = search_historyDao.is_searched(username, search);
		search = search.trim();
		if (s_h == null) {
			return search_historyDao.insert_SH(username, search);
		}
		if (search.equals(s_h.getS_history())) {
			search_historyDao.update_SH(username, search);
			return true;
		}
		return search_historyDao.insert_SH(username, search);
	}

	public boolean insert_fav(String username, int res_id) {
		return userDao.insert_fav(username, res_id);
	}

	public List<Search_historyVO> get_SH(String user_id) {
		return userDao.select_SH(user_id);
	}

	public boolean is_fav(String username, int res_id) {
		List<FavoritesVO> fav_list = userDao.get_fav(username);
		for (FavoritesVO fav : fav_list) {
			if (fav.getRes_id() == res_id && fav.getUser_id().equals(username)) {
				return true;
			}
		}
		return false;
	}

	public boolean delete_fav(String username, int res_id) {
		return userDao.delete_fav(username, res_id);
	}

	public List<FavoritesVO> get_favlist(String username) {
		return userDao.get_fav(username);
	}

	public boolean caution(String user_id) {
		// 현재 경고 스택을 가져오고 업데이트
		List<Report_manageVO> rep_manage = reportDao.select_Report_manage();
		UserVO user = userDao.selectUser(user_id);
		user.setUser_report(user.getUser_report() + 1);
		if (userDao.update_report(user)) {
		}
		for (Report_manageVO rep_m : rep_manage) {
			System.out.println(user.getUser_report());
			if (user.getUser_report() == rep_m.getReport_stack()) {
				// 유저를 해당일 만큼 정지
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, rep_m.getReport_date());
				Date date = cal.getTime();
				System.out.println(date);
				user.setUser_freeze(date);
			}
		}
		return userDao.updatecaution(user);
	}

}
