package kr.kh.final_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.kh.final_project.model.util.CustomUser;
import kr.kh.final_project.model.vo.RestaurantVO;
import kr.kh.final_project.model.vo.ReviewVO;
import kr.kh.final_project.service.Restaurantservice;
import kr.kh.final_project.service.ReviewService;
import kr.kh.final_project.service.UserService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
public class ResController {
	
	@Autowired
	private Restaurantservice restaurantService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/res/detail/{res_id}")
	public String detail(Model model,@PathVariable int res_id, @AuthenticationPrincipal CustomUser userDatails) {
		//음식점 정보를 가져옴
		RestaurantVO res = restaurantService.getRes(res_id);
		//해당 음식점의 리뷰정보(리스트)를 가져옴
		List<ReviewVO> rev = reviewService.getRev(res_id);
		//즐겨찾기 했는지 안했는지를 가져옴 true/false
		String username = userDatails.getMember().getUser_id();
		boolean result = false;
		if(userService.is_fav(username,res_id)) {
			result = true;
			model.addAttribute("result",result);
		}
		model.addAttribute("result",result);
		System.out.println(rev);
		model.addAttribute("res", res);
		model.addAttribute("rev", rev);
		System.out.println(res);
		return "/res/detail";
	}
	
	@GetMapping("/res/rev/{res_id}")
	public String writereview(Model model, @PathVariable int res_id) {
		model.addAttribute("res_id", res_id);
		return "/res/rev";
	}
	@PostMapping("/res/rev/{res_id}")
	public String writereviewPost(ReviewVO review,@PathVariable int res_id) {
		review.setRes_id(res_id);
		if(reviewService.insertRev(review)) {
			return "/map/mainmap";
		}
		return "/res/rev/" + res_id;
	}
	@GetMapping("/res/fav/{res_id}")
	public String fav(Model model,String username, @PathVariable int res_id) {
		if(userService.insert_fav(username, res_id)) {
			model.addAttribute("res_id", res_id);
		}
		return "/res/fav";
	}
	
}
