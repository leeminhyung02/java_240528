package kr.kh.final_project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import kr.kh.final_project.model.vo.UserVO;
import kr.kh.final_project.model.vo.ValidVO;
import kr.kh.final_project.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

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
	

	
}
