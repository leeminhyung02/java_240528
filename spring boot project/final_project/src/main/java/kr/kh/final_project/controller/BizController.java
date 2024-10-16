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
import kr.kh.final_project.model.vo.ReportVO;
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
	public String regesterbizPost(Model model, RestaurantVO res, @AuthenticationPrincipal CustomUser userDatails) {
		String User_id = userDatails.getMember().getUser_id();
		String say = "등록에 실패했습니다.";
		String link = "/biz/de";
		if(restaurantService.insertRes(res, User_id)) {
			say = "등록하였습니다";
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
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
	public String postreport_rev(Model model, String reason,@PathVariable int rev_id) {
		String link = "/map/mainmap";
		String say = "신고처리를 못했습니다.";
		System.out.println(reason);
		if(reviewService.insertRep(rev_id, reason)) {
			ReviewVO rev = reviewService.getRev_rep(rev_id);
			rev.set_report(true);
			if(reviewService.update_rev(rev)) {
				say = "신고처리를 했습니다.";
				
			}
		}
		model.addAttribute("say",say);
		model.addAttribute("link",link);
		return "/message";
	}
	
	
	@GetMapping("/biz/addmenu/{res_id}")
	public String addmenu(Model model, @PathVariable int res_id) {
		RestaurantVO res = restaurantService.getRes(res_id);
		model.addAttribute("res", res);
		return "/biz/addmenu";
	}
	@PostMapping("/biz/addmenu/{res_id}")
	public String post_addmenu(Model model, @PathVariable int res_id, String res_info) {
		String link = "/biz/de";
		String say = "메뉴 변경을 못했습니다.";
		RestaurantVO res = restaurantService.getRes(res_id);
		res.setRes_info(res_info);
		if(restaurantService.update_Res(res)) {
			say = "메뉴를 변경했습니다.";
		}
		model.addAttribute("say",say);
		model.addAttribute("link",link);
		return "/message";
	}
	
	
	@GetMapping("/biz/chbanner/{res_id}")
	public String chbanner(Model model, @PathVariable int res_id) {
		RestaurantVO res = restaurantService.getRes(res_id);
		model.addAttribute("res", res);
		return "/biz/chbanner";
	}
	@PostMapping("/biz/chbanner/{res_id}")
	public String post_chbanner(Model model, @PathVariable int res_id, String res_banner) {
		String link = "/biz/de";
		String say = "배너 변경을 못했습니다.";
		RestaurantVO res = restaurantService.getRes(res_id);
		res.setRes_banner(res_banner);
		if(restaurantService.update_Res(res)) {
			say = "배너를 변경했습니다.";
		}
		model.addAttribute("say",say);
		model.addAttribute("link",link);
		return "/message";
	}
	
	@GetMapping("/biz/report_list")
	public String reportbiz_list(Model model, @AuthenticationPrincipal CustomUser userDatails) {
		String User_id = userDatails.getMember().getUser_id();
		List<ReportVO> rep_list_all = reviewService.getReport();
		List<ReportVO> rep_list = new ArrayList<ReportVO>();
		for(ReportVO rep : rep_list_all) {
			ReviewVO rev = reviewService.getRev_rep(rep.getRev_id());
			RestaurantVO res = restaurantService.getRes(rev.getRes_id());
			if(res.getUser_id().equals(User_id)) {
				rep_list.add(rep);
			}
		}
		model.addAttribute("rep_list", rep_list);
		return "/biz/report_list";
	}
}
