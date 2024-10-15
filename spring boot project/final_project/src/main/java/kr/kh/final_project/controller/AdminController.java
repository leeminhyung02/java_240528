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
		List<ReportVO> Rep_List = reviewService.getReport();
		List<ReportVO> Rep_List2 = new ArrayList<ReportVO>();
		//임시
		for(ReportVO rep : Rep_List) {
			ReviewVO rev = reviewService.getRev_rep(rep.getRev_id());
			rep.setRev_content(rev.getContent());
			Rep_List2.add(rep);
		}
		model.addAttribute("rep", Rep_List2);
		return "/admin/rev";
	}
	
	@GetMapping("/admin/rep/{rev_id}")
	public String adminrep(@PathVariable int rev_id) {
		return "/admin/rep";
	}
	
	@GetMapping("/admin/user")
	public String adminuser() {
		return "/admin/user";
	}
	
}
