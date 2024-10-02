package kr.kh.final_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.kh.final_project.model.vo.RestaurantVO;
import kr.kh.final_project.model.vo.ReviewVO;
import kr.kh.final_project.service.RestaurantService;
import kr.kh.final_project.service.ReviewService;


@Controller
public class ResController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/res/detail/{res_id}")
	public String detail(Model model,@PathVariable int res_id) {
		RestaurantVO res = restaurantService.getRes(res_id);
		List<ReviewVO> rev = reviewService.getRev(res_id);
		System.out.println(rev);
		model.addAttribute("res", res);
		
		System.out.println(res);
		return "/res/detail";
	}
	
}
