package kr.kh.final_project.service;

import org.springframework.beans.factory.annotation.Autowired;
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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO user = userDao.selectUser(username);
		System.out.println(1);
		System.out.println(username);
		return user == null ? null : new CustomUser(user);
	}

}