package kr.kh.final_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.kh.final_project.model.vo.RestaurantVO;
import kr.kh.final_project.service.Restaurantservice;


@Controller
public class AdminController {

	@Autowired
	private Restaurantservice restaurantService;
	
	@GetMapping("/admin/de")
	public String admin() {
		return "/admin/de";
	}
	
	@GetMapping("/admin/res")
	public String adminres(Model model) {
		List<RestaurantVO> resList = restaurantService.getRes_per_no();
		model.addAttribute("resList",resList);
		return "/admin/res";
	}
	@GetMapping("/admin/res2")
	public String adminres2(Model model) {
		List<RestaurantVO> resList = restaurantService.getResall();
		model.addAttribute("resList",resList);
		return "/admin/res2";
	}
	
	@GetMapping("/admin/rev")
	public String adminrev() {
		return "/admin/rev";
	}
	
	@GetMapping("/admin/user")
	public String adminuser() {
		return "/admin/user";
	}
	
	@GetMapping("/admin/per/{res_id}")
	public String permission(Model model, @PathVariable int res_id) {
		restaurantService.updatepermission(res_id);
		return "/admin/de";
	}
	@GetMapping("/admin/per2/{res_id}")
	public String permission2(Model model, @PathVariable int res_id) {
		restaurantService.updatepermission2(res_id);
		return "/admin/de";
	}
}
