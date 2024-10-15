package kr.kh.final_project.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.final_project.model.util.CustomUser;
import kr.kh.final_project.model.vo.FavoritesVO;
import kr.kh.final_project.model.vo.RestaurantVO;
import kr.kh.final_project.model.vo.ReviewVO;
import kr.kh.final_project.service.Restaurantservice;
import kr.kh.final_project.service.ReviewService;
import kr.kh.final_project.service.UserService;

@Controller
public class ResController {

	@Autowired
	private Restaurantservice restaurantService;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private UserService userService;

	@GetMapping("/res/detail/{res_id}")
	public String detail(Model model, @PathVariable int res_id, @AuthenticationPrincipal CustomUser userDatails) {
		RestaurantVO res = restaurantService.getRes(res_id);
		List<ReviewVO> rev = reviewService.getRev(res_id);
		String username = userDatails.getMember().getUser_id();
		boolean result = false;
		if (userService.is_fav(username, res_id)) {
			result = true;
		}
		model.addAttribute("result", result);
		model.addAttribute("res", res);
		model.addAttribute("rev", rev);
		return "/res/detail";
	}

	@GetMapping("/res/rev/{res_id}")
	public String writereview(Model model, @PathVariable int res_id) {
		model.addAttribute("res_id", res_id);
		return "/res/rev";
	}

	@PostMapping("/res/rev/{res_id}")
	public String writereviewPost(ReviewVO review, @PathVariable int res_id) {
		review.setRes_id(res_id);
		if (reviewService.insertRev(review)) {
		}
		return "/map/mainmap";
	}

	@GetMapping("/res/fav/{res_id}")
	public String fav(Model model, @PathVariable int res_id, @AuthenticationPrincipal CustomUser userDatails) {
		String username = userDatails.getMember().getUser_id();
		boolean isfav = userService.is_fav(username, res_id);
		if (isfav) {
			if (userService.delete_fav(username, res_id)) {
			}
		} else{
			if (userService.insert_fav(username, res_id)) {
			}
		}
		model.addAttribute("result", isfav);
		model.addAttribute("res_id", res_id);
		return "/res/fav";
	}
	
	@GetMapping("/res/favList")		
	public String favList(Model model, @AuthenticationPrincipal CustomUser userDatails) {
		String username = userDatails.getMember().getUser_id();
		List<FavoritesVO> Fav_list = userService.get_favlist(username);
		List<RestaurantVO> Res_list = new ArrayList<RestaurantVO>();
		for(FavoritesVO fav : Fav_list) {
			RestaurantVO res = restaurantService.getRes(fav.getRes_id());
			Res_list.add(res);
		}
		model.addAttribute("Res_list", Res_list);
		model.addAttribute("Fav_List", Fav_list);
		return "/res/favList";
	}
	
}
