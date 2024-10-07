package kr.kh.final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.final_project.model.vo.UserVO;
import kr.kh.final_project.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/user/signup")
	public String signup() {
		return "/user/signup";
	}
	
	@PostMapping("/user/signup")
	public String signupPost(UserVO user) {
		if(userService.signup_user(user)) {
			return "/map/mainmap";
		}
		return "/user/signup";
	}
	
	@GetMapping("/user/login")
	public String login() {
		return "/user/login";
	}

}
