package kr.kh.final_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import kr.kh.final_project.model.util.CustomUser;
import kr.kh.final_project.model.vo.Mail;
import kr.kh.final_project.model.vo.UserVO;
import kr.kh.final_project.service.MailService;
import kr.kh.final_project.service.UserService;

@Controller
public class MailController {

	@Autowired
	private MailService mailService;

	@Autowired
	private UserService userService;

	@Autowired
	private TemplateEngine templateEngine;

	@GetMapping("/mail/mailsend")
	public String SendMail(Model model, @AuthenticationPrincipal CustomUser userDatails) {
		String say = "메일을 보냈습니다.";
		String link = "/map/mainmap";
		model.addAttribute("say", say);
		model.addAttribute("link", link);

		Context context = new Context();
		context.setVariable("nickname", userDatails.getMember().getUser_id());
		String htmlTemplate = templateEngine.process("mail/mailsend", context);
		Mail mail = new Mail();
		mail.setTitle("제목");
		mail.setTo("mi087033@gmail.com");
		mail.setContent(htmlTemplate);
		mailService.mailSend(mail);
		return "/message";
	}

	// 메일 형식 테스트용
	@GetMapping("/mail/testmail")
	public String testmail(Model model, @AuthenticationPrincipal CustomUser userDatails) {

		return "/mail/test";

	}

	public void send_Freeze_mail(UserVO user) {
		// 정지 당한 유저 정보를 가져옴
		Context context = new Context();
		context.setVariable("user", user);
		String htmlTemplate = templateEngine.process("mail/user_freeze", context);
		Mail mail = new Mail();
		mail.setTitle("계정이 정지당했습니다.");
		mail.setTo("mi087033@gmail.com");
		mail.setContent(htmlTemplate);
		mailService.mailSend(mail);
	}

	@GetMapping("/mail/test1")
	// user_freeze, user_report 필요
	public String test1(Model model) {
		List<UserVO> user = userService.get_freeze_user();
		send_Freeze_mail(user.get(0));
		model.addAttribute("user", user.get(0));
		return "/mail/user_freeze";
	}

	@GetMapping("/mail/test2")
	public String test2(Model model) {
		//임시 비밀번호 를 설정하고 그걸 전송
		//로그인화면에서 비번 찾기 버튼(링크 만들고) form 태그로 가져옴(userid)
		UserVO user = new UserVO();
		user.setUser_name("admin");
		send_find_pw_Mail(user);
		return "/mail/test";
	}
	
	public void send_find_pw_Mail(UserVO user) {
		String user_name = user.getUser_name();
		String temp_pw = userService.set_temp_pw(user_name);
		if(temp_pw != null) {
			Context context = new Context();
			context.setVariable("user_name", user_name);
			context.setVariable("temp_pw", temp_pw);
			String htmlTemplate = templateEngine.process("mail/find_pw", context);
			Mail mail = new Mail();
			mail.setTitle("임시 비밀번호 입니다.");
			mail.setTo("mi087033@gmail.com");
			mail.setContent(htmlTemplate);
			mailService.mailSend(mail);
		}
	}
}
