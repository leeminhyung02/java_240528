package kr.kh.final_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {

	@GetMapping("/admin/de")
	public String admin() {
		return "/admin/de";
	}
	
}
