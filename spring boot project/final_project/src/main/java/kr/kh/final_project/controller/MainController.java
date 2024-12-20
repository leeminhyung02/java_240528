package kr.kh.final_project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
	
	@Value("${project.kakao.appkey}")
	private String kakaoAppKey;
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("apikey",kakaoAppKey);
		return "/map/mainmap";
	}
	
	@GetMapping("/login_message")
	public String go123() {
		return "/login_message";
	}
	
}
