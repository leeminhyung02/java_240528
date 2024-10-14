package kr.kh.final_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.final_project.dao.Search_historyDAO;
import kr.kh.final_project.dao.UserDAO;
import kr.kh.final_project.model.vo.FavoritesVO;
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
	private PasswordEncoder passwordEncoder;
	
	public boolean signup_user(UserVO user) {
		String pw = passwordEncoder.encode(user.getUser_pw());
		user.setUser_pw(pw);
		return userDao.signup(user);
	}

	public boolean insert_SH(String username, String search) {
		Search_historyVO s_h = search_historyDao.is_searched(username, search);
		search = search.trim();
		if(s_h == null) {
			return search_historyDao.insert_SH(username, search);
		}
		if(search.equals(s_h.getS_history())) {
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
		for(FavoritesVO fav : fav_list) {
			if(fav.getRes_id() == res_id && fav.getUser_id().equals(username)) {
				return true;
			}
		}
		return false;
	}
}
