package kr.kh.final_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {

	@GetMapping("/admin/de")
	public String admin() {
		return "/admin/de";
	}
	
	@GetMapping("/admin/res")
	public String adminres() {
		return "/admin/res";
	}
	
	@GetMapping("/admin/rev")
	public String adminrev() {
		return "/admin/rev";
	}
	
	@GetMapping("/admin/user")
	public String adminuser() {
		return "/admin/user";
	}
}
