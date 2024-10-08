package kr.kh.final_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.kh.final_project.model.vo.RestaurantVO;
import kr.kh.final_project.model.vo.ReviewVO;
import kr.kh.final_project.service.Restaurantservice;
import kr.kh.final_project.service.ReviewService;


@Controller
public class ResController {
	
	@Autowired
	private Restaurantservice restaurantService;
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/res/detail/{res_id}")
	public String detail(Model model,@PathVariable int res_id) {
		//음식점 정보를 가져옴
		RestaurantVO res = restaurantService.getRes(res_id);
		//해당 음식점의 리뷰정보(리스트)를 가져옴
		List<ReviewVO> rev = reviewService.getRev(res_id);
		System.out.println(rev);
		model.addAttribute("res", res);
		model.addAttribute("rev", rev);
		System.out.println(res);
		return "/res/detail";
	}
		
}
