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
import kr.kh.final_project.model.vo.MenuListVO;
import kr.kh.final_project.model.vo.MenuVO;
import kr.kh.final_project.model.vo.ReportVO;
import kr.kh.final_project.model.vo.RestaurantVO;
import kr.kh.final_project.model.vo.ReviewVO;
import kr.kh.final_project.model.vo.Search_historyVO;
import kr.kh.final_project.service.Restaurantservice;
import kr.kh.final_project.service.ReviewService;
import kr.kh.final_project.service.UserService;

@Controller
public class BizController {

	@Autowired
	private Restaurantservice restaurantService;

	@Autowired
	private ReviewService reviewService;

	@Autowired
	private UserService userService;

	@GetMapping("/biz/de")
	public String biz(Model model, @AuthenticationPrincipal CustomUser userDatails) {
		if (userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			// 해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		return "/biz/de";
	}

	@GetMapping("/biz/reg")
	public String regesterbiz(Model model, @AuthenticationPrincipal CustomUser userDatails) {
		if (userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			// 해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		return "/biz/reg";
	}

	@PostMapping("/biz/reg")
	public String regesterbizPost(Model model, RestaurantVO res, String res_type_direct,
			@AuthenticationPrincipal CustomUser userDatails) {
		if (userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			// 해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		String User_id = userDatails.getMember().getUser_id();
		String say = "등록에 실패했습니다.";
		String link = "/biz/de";
		System.out.println(res.getRes_type());
		if (res.getRes_type().equals("direct")) {
			res.setRes_type(res_type_direct);
		}
		if (restaurantService.insertRes(res, User_id)) {
			say = "등록하였습니다";
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}

	@GetMapping("/biz/manage")
	public String managebiz(Model model, @AuthenticationPrincipal CustomUser userDatails) {
		if (userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			// 해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		String User_id = userDatails.getMember().getUser_id();
		List<RestaurantVO> res_list = restaurantService.getRes_user(User_id);
		model.addAttribute("res_list", res_list);
		return "/biz/manage";
	}

	@GetMapping("/biz/manage_detail/{res_id}")
	public String managebiz_detail(Model model, @PathVariable int res_id,
			@AuthenticationPrincipal CustomUser userDatails) {
		if (userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		List<MenuVO> menu_list = restaurantService.get_Menu_List(res_id);
		model.addAttribute("menu_list", menu_list);
		RestaurantVO res = restaurantService.getRes(res_id);
		model.addAttribute("res", res);
		return "/biz/manage_detail";
	}

	@GetMapping("/biz/show_rev/{res_id}")
	public String show_rev(Model model, @PathVariable int res_id, @AuthenticationPrincipal CustomUser userDatails) {
		if (userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			// 해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		List<ReviewVO> rev_list = reviewService.getRev(res_id);
		model.addAttribute("rev_list", rev_list);
		return "/biz/show_rev";
	}

	@GetMapping("/biz/report/{rev_id}")
	public String reportbiz(Model model, @PathVariable int rev_id, @AuthenticationPrincipal CustomUser userDatails) {
		if (userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			// 해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		ReviewVO rev = reviewService.getRev_rep(rev_id);
		model.addAttribute("rev", rev);
		return "/biz/report";
	}

	@PostMapping("/biz/report/{rev_id}")
	public String postreport_rev(Model model, String reason, @PathVariable int rev_id) {
		String link = "/map/mainmap";
		String say = "신고처리를 못했습니다.";
		System.out.println(reason);
		if (reviewService.insertRep(rev_id, reason)) {
			ReviewVO rev = reviewService.getRev_rep(rev_id);
			rev.set_report(true);
			if (reviewService.update_rev(rev)) {
				say = "신고처리를 했습니다.";

			}
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}

	@GetMapping("/biz/addmenu/{res_id}")
	public String addmenu(Model model, @PathVariable int res_id, @AuthenticationPrincipal CustomUser userDatails) {
		if (userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			// 해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		RestaurantVO res = restaurantService.getRes(res_id);
		model.addAttribute("res", res);
		return "/biz/addmenu";
	}

	@GetMapping("/biz/addmenu2/{res_id}")
	public String addmenu_test(Model model, @PathVariable int res_id,
			@AuthenticationPrincipal CustomUser userDatails) {
		if (userDatails != null) {
			// 해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		List<MenuVO> menu_list = restaurantService.get_Menu_List(res_id);
		System.out.println(menu_list);
		model.addAttribute("isNull", false);
		if (menu_list.equals(new ArrayList<MenuVO>())) {
			model.addAttribute("isNull", true);
		}
		model.addAttribute("menu_list", menu_list);
		RestaurantVO res = restaurantService.getRes(res_id);
		model.addAttribute("res", res);
		return "/biz/addmenu2";
	}

	@PostMapping("/biz/addmenu/{res_id}")
	public String post_addmenu(Model model, @PathVariable int res_id, String res_info) {
		String link = "/biz/de";
		String say = "메뉴 변경을 못했습니다.";
		RestaurantVO res = restaurantService.getRes(res_id);
		res.setRes_info(res_info);
		if (restaurantService.update_Res(res)) {
			say = "메뉴를 변경했습니다.";
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}

	@PostMapping("/biz/addmenu2/{res_id}")
	public String post_addmenu_test(Model model, @PathVariable int res_id, MenuListVO menu_list) {
		String link = "/biz/de";
		String say = "메뉴 변경을 못했습니다.";
		// 이전에 설정한 메뉴값이 있다면 이전 설정한 메뉴값 가져오기 (model)
		if (menu_list != null) {
			for (int i = 0; i < menu_list.getList().size(); i++) {
				menu_list.getList().get(i).setRes_id(res_id); // 가게 설정
				menu_list.getList().get(i).setMenu_count(i); // 메뉴 번호 설정
				MenuVO menu = menu_list.getList().get(i);
				if (restaurantService.insertMenu(res_id, menu)) {
				}
			}
		}
		System.out.println(menu_list);
		RestaurantVO res = restaurantService.getRes(res_id);
		if (restaurantService.update_Res(res)) {
			say = "메뉴를 변경했습니다.";
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}

	@PostMapping("/biz/updatemenu/{res_id}")
	public String post_updatemenu_test(Model model, @PathVariable int res_id, MenuListVO menu_list) {
		String link = "/biz/de";
		String say = "메뉴 변경을 못했습니다.";
		System.out.println(menu_list);
		// 받아온 menu_list를 update함
		int list_size = menu_list.getList().size();
		System.out.println("처음"+list_size);
		List<MenuVO>res_menu_list = restaurantService.get_Menu_List(res_id);
		List<Integer>menu_code = new ArrayList<Integer>();
		for(MenuVO m : res_menu_list) {
			menu_code.add(m.getMenu_code());
		}
		System.out.println(menu_code);
		if (menu_list != null) {
			for (int i = 0; i < menu_list.getList().size(); i++) {
				menu_list.getList().get(i).setRes_id(res_id); // 가게 설정
				menu_list.getList().get(i).setMenu_count(i); // 메뉴 번호 설정
				MenuVO menu = menu_list.getList().get(i);
				if (restaurantService.updateMenu(res_id, menu)) {
					for(int j = 0; j < menu_code.size(); j++) {
						if(menu_code.get(j) == menu.getMenu_code()) {
							menu_code.remove(j);
						}
					}
					list_size--;
				}
			}
			for(Integer code : menu_code) {
				System.out.println("남은 menu_code"+code);
				if(restaurantService.remove(code)) {
					System.out.println(code+"삭제 완료");
				}
			}
			if (list_size == 0) {
				say = "메뉴를 변경했습니다.";
			} else if (list_size != menu_list.getList().size()) {
				say = "메뉴 변경중 일부 오류가 발생했습니다.";
			}
		}
		System.out.println(list_size);
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}

	@GetMapping("/biz/chbanner/{res_id}")
	public String chbanner(Model model, @PathVariable int res_id, @AuthenticationPrincipal CustomUser userDatails) {
		if (userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			// 해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
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
		if (restaurantService.update_Res(res)) {
			say = "배너를 변경했습니다.";
		}
		model.addAttribute("say", say);
		model.addAttribute("link", link);
		return "/message";
	}

	@GetMapping("/biz/report_list")
	public String reportbiz_list(Model model, @AuthenticationPrincipal CustomUser userDatails) {
		if (userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			// 해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		String User_id = userDatails.getMember().getUser_id();
		List<ReportVO> rep_list_all = reviewService.getReport();
		List<ReportVO> rep_list = new ArrayList<ReportVO>();
		for (ReportVO rep : rep_list_all) {
			ReviewVO rev = reviewService.getRev_rep(rep.getRev_id());
			RestaurantVO res = restaurantService.getRes(rev.getRes_id());
			if (res.getUser_id().equals(User_id)) {
				rep_list.add(rep);
			}
		}
		model.addAttribute("rep_list", rep_list);
		return "/biz/report_list";
	}
}
