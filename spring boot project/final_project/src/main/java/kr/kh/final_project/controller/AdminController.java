package kr.kh.final_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kr.kh.final_project.model.util.CustomUser;
import kr.kh.final_project.model.vo.ReportVO;
import kr.kh.final_project.model.vo.RestaurantVO;
import kr.kh.final_project.model.vo.ReviewVO;
import kr.kh.final_project.model.vo.Search_historyVO;
import kr.kh.final_project.service.Restaurantservice;
import kr.kh.final_project.service.ReviewService;
import kr.kh.final_project.service.UserService;


@Controller
public class AdminController {

	@Autowired
	private Restaurantservice restaurantService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/admin/de")
	public String admin(Model model, @AuthenticationPrincipal CustomUser userDatails) {
		if(userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			//해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		return "/admin/de";
	}
	
	@GetMapping("/admin/res")
	public String adminres(Model model, @AuthenticationPrincipal CustomUser userDatails) {
		if(userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			//해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		List<RestaurantVO> resList = restaurantService.getRes_all();
		model.addAttribute("resList",resList);
		return "/admin/res";
	}
	@GetMapping("/admin/per/{res_id}")
	public String permission(Model model, @PathVariable int res_id, @AuthenticationPrincipal CustomUser userDatails) {
		if(userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			//해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
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
	public String adminrev(Model model, @AuthenticationPrincipal CustomUser userDatails) {
		if(userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			//해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		List<ReportVO> rep_List = reviewService.getReport();
		model.addAttribute("rep", rep_List);
		return "/admin/rev";
	}

	@GetMapping("/admin/rep_delete/{rev_id}")
	public String delete_rev(Model model, @PathVariable int rev_id, @AuthenticationPrincipal CustomUser userDatails) {
		if(userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			//해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
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
			//유저 경고 처리
			if(userService.caution(rev.getUser_id())) { 
				
			}
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}
	@GetMapping("admin/rep_non/{rev_id}")
	public String re(Model model, @PathVariable int rev_id, @AuthenticationPrincipal CustomUser userDatails) {
		if(userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			//해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
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
