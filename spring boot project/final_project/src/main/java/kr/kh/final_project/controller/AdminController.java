package kr.kh.final_project.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.kh.final_project.model.vo.ReportVO;
import kr.kh.final_project.model.vo.RestaurantVO;
import kr.kh.final_project.model.vo.ReviewVO;
import kr.kh.final_project.service.Restaurantservice;
import kr.kh.final_project.service.ReviewService;


@Controller
public class AdminController {

	@Autowired
	private Restaurantservice restaurantService;
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("/admin/de")
	public String admin() {
		return "/admin/de";
	}
	
	@GetMapping("/admin/res")
	public String adminres(Model model) {
		List<RestaurantVO> resList = restaurantService.getRes_all();
		model.addAttribute("resList",resList);
		return "/admin/res";
	}
	@GetMapping("/admin/per/{res_id}")
	public String permission(Model model, @PathVariable int res_id) {
		RestaurantVO res = restaurantService.getRes(res_id);
		String say = "";
		String link = "/admin/res";
		if(res.isPermission()) {
			restaurantService.updatepermission2(res_id);
			say = "미승인처리하였습니다";
		}
		else {
			restaurantService.updatepermission(res_id);
			say = "승인처리하였습니다.";
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}
	
	@GetMapping("/admin/rev")
	public String adminrev(Model model) {
		List<ReportVO> rep_List = reviewService.getReport();
		model.addAttribute("rep", rep_List);
		return "/admin/rev";
	}

	@GetMapping("/admin/rep_delete/{rev_id}")
	public String delete_rev(Model model, @PathVariable int rev_id) {
		//false는 유지 true는 삭제
		String say = "삭제 처리했습니다.";
		String link = "/admin/res";
		ReportVO rep = reviewService.getReport_rev(rev_id); 
		rep.setRep_result(true);
		rep.setRes_state("처리 끝");
		if(reviewService.update_rep(rep)) {
			ReviewVO rev = reviewService.getRev_rep(rev_id);
			rev.setReport_result(true);
			if(reviewService.update_rev(rev)) {
			}
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}
	@GetMapping("admin/rep_non/{rev_id}")
	public String re(Model model, @PathVariable int rev_id) {
		String say = "유지 처리했습니다.";
		String link = "/admin/res";
		ReportVO rep = reviewService.getReport_rev(rev_id); 
		//false는 유지 true는 삭제
		rep.setRep_result(false);
		rep.setRes_state("처리 끝");
		if(reviewService.update_rep(rep)) {
			ReviewVO rev = reviewService.getRev_rep(rev_id);
			rev.setReport_result(false);
			if(reviewService.update_rev(rev)) {
			}
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
		
	}
	@GetMapping("/admin/user")
	public String adminuser() {
		return "/admin/user";
	}
	
}
