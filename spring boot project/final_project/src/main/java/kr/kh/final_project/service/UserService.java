package kr.kh.final_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.final_project.dao.UserDAO;
import kr.kh.final_project.model.vo.UserVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
 
	@Autowired
	UserDAO userDao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public boolean signup_user(UserVO user) {
		String pw = passwordEncoder.encode(user.getUser_pw());
		user.setUser_pw(pw);
		return userDao.signup(user);
	}
}
