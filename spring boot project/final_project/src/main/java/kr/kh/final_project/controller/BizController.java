package kr.kh.final_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kr.kh.final_project.model.util.CustomUser;
import kr.kh.final_project.model.vo.RestaurantVO;
import kr.kh.final_project.model.vo.ReviewVO;
import kr.kh.final_project.service.Restaurantservice;
import kr.kh.final_project.service.ReviewService;


@Controller
public class BizController {

	@Autowired
	private Restaurantservice restaurantService;
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/biz/de")
	public String biz() {
		return "/biz/de";
	}
	
	@GetMapping("/biz/reg")
	public String regesterbiz() {
		
		return "/biz/reg";
	}
	
	@PostMapping("/biz/reg")
	public String regesterbizPost(RestaurantVO res, @AuthenticationPrincipal CustomUser userDatails) {
		String User_id = userDatails.getMember().getUser_id();
		if(restaurantService.insertRes(res, User_id)) {
		}
		return "/biz/de";
	}
	
	@GetMapping("/biz/manage")
	public String managebiz(Model model,@AuthenticationPrincipal CustomUser userDatails) {
		String User_id = userDatails.getMember().getUser_id();
		List<RestaurantVO> res_list = restaurantService.getRes_user(User_id);
		model.addAttribute("res_list", res_list);
		return "/biz/manage";
	}
	
	@GetMapping("/biz/manage_detail/{res_id}")
	public String managebiz_detail(Model model, @PathVariable int res_id) {
		RestaurantVO res = restaurantService.getRes(res_id);
		model.addAttribute("res", res);
		return "/biz/manage_detail";
	}
	@GetMapping("/biz/show_rev/{res_id}")
	public String show_rev(Model model, @PathVariable int res_id) {
		List<ReviewVO> rev_list = reviewService.getRev(res_id);
		model.addAttribute("rev_list", rev_list);
		return "/biz/show_rev";
	}
	
	@GetMapping("/biz/report/{rev_id}")
	public String reportbiz(Model model, @PathVariable int rev_id) {
		ReviewVO rev = reviewService.getRev_rep(rev_id);
		model.addAttribute("rev", rev);
		return "/biz/report";
	}
	
	@PostMapping("/biz/report/{rev_id}")
	public String postreport_rev(Model model) {
		String link = "/map/mainmap";
		String say = "말";
		model.addAttribute("say",say);
		model.addAttribute("link",link);
		return "/message";
	}
	
	
	@GetMapping("/biz/addmenu/{res_id}")
	public String addmenu(Model model, @PathVariable int res_id) {
		
		return "/biz/addmenu";
	}
	@GetMapping("/biz/chbanner/{res_id}")
	public String chbanner(Model model, @PathVariable int res_id) {
		
		return "/biz/chbanner";
	}
	
	@GetMapping("/biz/report_list")
	public String reportbiz_list() {
		return "/biz/report_list";
	}
}
