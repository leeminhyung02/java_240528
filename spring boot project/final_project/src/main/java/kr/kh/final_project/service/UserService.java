package kr.kh.final_project.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import kr.kh.final_project.controller.MailController;
import kr.kh.final_project.dao.ReportDAO;
import kr.kh.final_project.dao.Search_historyDAO;
import kr.kh.final_project.dao.UserDAO;
import kr.kh.final_project.model.vo.FavoritesVO;
import kr.kh.final_project.model.vo.Mail;
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
	MailService mailService;
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public boolean signup_user(UserVO user) {
		user.setUser_pw(set_pwEncoder(user.getUser_pw()));
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
				//정지 메일 보내기(user)
				Context context = new Context();
				context.setVariable("user", user);
				String htmlTemplate = templateEngine.process("mail/user_freeze", context);
				Mail mail = new Mail();
				mail.setTitle("계정이 정지당했습니다.");
				mail.setTo(user.getUser_email());
				//테스트용 이메일
				mail.setTo("mi087033@gmail.com");
				mail.setContent(htmlTemplate);
				mailService.mailSend(mail);
			}
		}
		return userDao.updatecaution(user);
	}

	public boolean signup_biz(UserVO user) {
		String pw = passwordEncoder.encode(user.getUser_pw());
		user.setUser_pw(pw);
		return userDao.signup_biz(user); 
		
	}

	public Map<String, String> validate(Errors errors) {
		Map<String, String> valRes = new HashMap<>();
		
		for(FieldError error : errors.getFieldErrors()) {
			String validkeyname = String.format("%s", error.getField());
			valRes.put(validkeyname, error.getDefaultMessage());
		}
		return valRes;
	}

	public boolean check_is_in(String value) {
		UserVO vo = userDao.selectUser(value);
		if(vo == null) {
			return true;
		}
		return !(vo.getUser_id().equals(value));
	}

	public boolean check_is_in_email(String value) {
		UserVO vo = userDao.selectUser_email(value);
		if(vo == null) {
			return true;
		}
		return !(vo.getUser_email().equals(value));
	}

	public List<UserVO> get_freeze_user() {
		return userDao.selectUser_by_freeze();
	}

	public String set_temp_pw(String user_name) {
		//임시 비밀번호 설정하고 그 임시비밀번호 리턴
		String temp_pw = RandomStringUtils.randomAlphanumeric(10);
		System.out.println("암호화전"+temp_pw);
		UserVO user = userDao.selectUser_name(user_name);
		if(user == null) {
			return null;
		}
		String pw = passwordEncoder.encode(temp_pw);
		user.setUser_pw(pw);
		System.out.println("암호화후"+pw);
		if(!userDao.update_pw(user)) {
			return null;
		}
		return temp_pw;
	}

	public UserVO get_user(String user_id) {
		UserVO user = userDao.selectUser(user_id);
		if(user == null) {
			return null;
		}
		return user;
	}

	public String set_pwEncoder(String pw) {
		return passwordEncoder.encode(pw);
	}
	public boolean check_pw(String input_pw,String user_pw) {
		return passwordEncoder.matches(input_pw, user_pw);
	}

	public boolean updatePW(UserVO user) {
		return userDao.update_pw(user);
	}

	public boolean updateName(UserVO user) {
		return userDao.update_name(user);
	}

}
