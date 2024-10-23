package kr.kh.final_project.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.kh.final_project.dao.UserDAO;
import kr.kh.final_project.model.util.CustomUser;
import kr.kh.final_project.model.vo.UserVO;

@Service
public class UserDetailservice implements UserDetailsService{

	@Autowired
	UserDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DisabledException{
		UserVO user = userDao.selectUser(username);
		Date date = new Date();
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		if(user.getUser_freeze() == null) {
			return user == null ? null : new CustomUser(user);
		}
		else if(user.getUser_freeze().after(date)) {
			throw new DisabledException(username);
		}
		return user == null ? null : new CustomUser(user);
	}

}