package kr.kh.final_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.kh.final_project.model.vo.RestaurantVO;
import kr.kh.final_project.service.RestaurantService;


@Controller
public class ResController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping("/res/detail/{res_id}")
	public String detail(Model model,@PathVariable int res_id) {
		model.addAttribute("res_id", res_id);
		RestaurantVO res = restaurantService.getRes(res_id);
		model.addAttribute("res", res);
		System.out.println(res);
		return "/res/detail";
	}
	
}
