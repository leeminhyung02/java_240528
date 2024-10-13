package kr.kh.study.controller;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.study.dao.PostDAO;

@Controller
public class HomeController {
	
	@Autowired
	PostDAO postDao;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String home() {
		System.out.println(postDao.count());
		String str = "abc";
		String enc = passwordEncoder.encode(str);
		System.out.println("암호화 안된 문자열 : " + str);
		System.out.println("암호화 된 문자열 : " + enc);
		System.out.println("암호화된 문자열 == abc : "+ passwordEncoder.matches("abc",enc));
		System.out.println("암호화된 문자열 == abd : "+ passwordEncoder.matches("abd",enc));
		//메일 전송 테스트
//		mailSend("mi087033@gmail.com", "메일 테스트", "전송이 잘 됐습니다.");
		return "/home";
	}
	@GetMapping("/post/list")
	public String postList() {
		return "/home";
	}
	@GetMapping("/post/detail")
	public String postDetail() {
		return "/home";
	}
	@GetMapping("/post/insert")
	public String postInsert() {
		return "/home";
	}
	public boolean mailSend(String to, String title, String content) {

	    String setfrom = "mi087033@gmail.com";
	   try{
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper
	            = new MimeMessageHelper(message, true, "UTF-8");

	        messageHelper.setFrom(setfrom);// 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(to);// 받는사람 이메일
	        messageHelper.setSubject(title);// 메일제목은 생략이 가능하다
	        messageHelper.setText(content, true);// 메일 내용

	        mailSender.send(message);
	        return true;
	    } catch(Exception e){
	        e.printStackTrace();
	        return false;
	    }
	}
}
