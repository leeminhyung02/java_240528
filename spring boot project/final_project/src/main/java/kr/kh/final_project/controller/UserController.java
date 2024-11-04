package kr.kh.final_project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import kr.kh.final_project.model.util.CustomUser;
import kr.kh.final_project.model.vo.Mail;
import kr.kh.final_project.model.vo.UserVO;
import kr.kh.final_project.model.vo.ValidVO;
import kr.kh.final_project.service.MailService;
import kr.kh.final_project.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailService mailService;

	@Autowired
	private TemplateEngine templateEngine;

	@GetMapping("/user/signup")
	public String signup() {
		return "/user/signup";
	}
	
	@PostMapping("/user/signup")
	public String signupPost(@Valid ValidVO vo, Errors errors, boolean is_biz, Model model) {
		
		if(errors.hasErrors()) {
			model.addAttribute("userVO", vo);
			System.out.println(vo);
			Map<String, String> valRes = userService.validate(errors);
			for(String key : valRes.keySet()) {
				System.out.println(key+":"+valRes.get(key));
				model.addAttribute(key, valRes.get(key));
			}
			return "/user/signup";
		}
		
		UserVO user = new UserVO();
		user.setUser_id(vo.getUser_id());
		user.setUser_pw(vo.getUser_pw());
		user.setUser_email(vo.getUser_email());
		user.setUser_name(vo.getUser_name());
		if(is_biz) {
			if(userService.signup_biz(user)) {
				String say = "회원가입을 완료했습니다.(사업자용)";
				String link = "/map/mainmap";
				model.addAttribute("say", say);
				model.addAttribute("link", link);
				return "/message";
			}
		}
		if(userService.signup_user(user)) {
			String say = "회원가입을 완료했습니다.";
			String link = "/map/mainmap";
			model.addAttribute("say", say);
			model.addAttribute("link", link);
			return "/message";
		}
		return "/user/signup";
	}
	
	@GetMapping("/user/login")
	public String login(Model model, @RequestParam(value="error", required = false) String error, @RequestParam(value = "exception", required = false) String exception){
		  model.addAttribute("error", error);
	        model.addAttribute("exception", exception);
		return "/user/login";
	}
	
	@GetMapping("/user/find_pw")
	public String find_pw() {
		return "/user/find_pw";
	}
	
	@PostMapping("/user/find_pw")
	public String postFind_pw(Model model, String User_id) {
		UserVO user = new UserVO(); 
		String say = "잘못된 아이디입니다.";
		String link = "/user/login";
		user = userService.get_user(User_id);
		if(user == null) {
			model.addAttribute("say", say);
			model.addAttribute("link", link);
			return "/message";
		}
		String user_name = user.getUser_name();
		if(user != null) {
			say = user.getUser_email()+"로 임시 비밀번호를 보냈습니다. 마이페이지에서 변경해주세요";
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
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}
	
	@GetMapping("/user/mypage")
	public String mypage(Model model, @AuthenticationPrincipal CustomUser userDatails) {
		String User_id = userDatails.getMember().getUser_id();
		UserVO user = new UserVO();
		user = userService.get_user(User_id);
		model.addAttribute("user", user);
		return "/user/mypage";
	}
	
	@GetMapping("/user/change_pw")
	public String change_pw() {
		return "/user/change_pw";
	}
	
	@PostMapping("/user/change_pw")
	public String postChange_pw(Model model, String user_pw, @AuthenticationPrincipal CustomUser userDatails) {
		String User_id = userDatails.getMember().getUser_id();
		UserVO user = userService.get_user(User_id);
		user.setUser_pw(userService.set_pwEncoder(user_pw));
		String say = "실패 했습니다 다시 시도해주세요";
		String link = "/user/mypage";
		if(userService.updatePW(user)) {
			say = "비밀번호를 재설정 했습니다.";
			link = "/map/mainmap";
			model.addAttribute("say", say);
			model.addAttribute("link", link);
			return "/message";
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}
	
	
	@GetMapping("/user/change_name")
	public String change_name() {
		return "/user/change_name";
	}
	
	@PostMapping("/user/change_name")
	public String postChange_name(Model model, String user_name, @AuthenticationPrincipal CustomUser userDatails) {
		String User_id = userDatails.getMember().getUser_id();
		UserVO user = userService.get_user(User_id);
		user.setUser_name(user_name);
		String say = "실패 했습니다 다시 시도해주세요";
		String link = "/user/mypage";
		if(userService.updateName(user)) {
			say = "이름을 재설정 했습니다.";
			link = "/map/mainmap";
			model.addAttribute("say", say);
			model.addAttribute("link", link);
			return "/message";
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}
	
	@GetMapping("/user/check_pw_by_pw")
	public String check_pw_pw() {
		return "/user/check_pw_by_pw";
	}
	
	@GetMapping("/user/check_pw_by_name")
	public String check_pw_name() {
		return "/user/check_pw_by_name";
	}
	
	@PostMapping("/user/check_pw_by_pw")
	public String postCheck_pwPw(Model model, String pw, @AuthenticationPrincipal CustomUser userDatails) {
		String User_id = userDatails.getMember().getUser_id();
		String say = "잘못된 비밀번호입니다.";
		String link = "/user/mypage";
		if(check_pw(User_id, pw)) {
			return "/user/change_pw";
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}
	
	@PostMapping("/user/check_pw_by_name")
	public String postCheck_pwName(Model model, String pw, @AuthenticationPrincipal CustomUser userDatails) {
		String User_id = userDatails.getMember().getUser_id();
		String say = "잘못된 비밀번호입니다.";
		String link = "/user/mypage";
		if(check_pw(User_id, pw)) {
			return "/user/change_name";
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}
	
	
	public boolean check_pw(String User_id, String pw) {
		UserVO user = userService.get_user(User_id);
		return userService.check_pw(pw, user.getUser_pw());
	}
	
}
