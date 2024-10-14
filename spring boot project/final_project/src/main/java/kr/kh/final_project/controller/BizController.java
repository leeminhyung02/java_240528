package kr.kh.final_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BizController {

	@GetMapping("/biz/de")
	public String biz() {
		return "/biz/de";
	}
	
}
