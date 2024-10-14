package kr.kh.final_project.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@Value("${project.kakao.appkey}")
	private String kakaoAppKey;
	
	@GetMapping("/")
	public String main(Model model) {
		System.out.println(kakaoAppKey);
		model.addAttribute("apikey",kakaoAppKey);
		return "/map/mainmap";
	}
	
}
