package kr.kh.final_project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.final_project.model.util.CustomUser;
import kr.kh.final_project.model.vo.RestaurantVO;
import kr.kh.final_project.model.vo.Search_historyVO;
import kr.kh.final_project.service.Restaurantservice;
import kr.kh.final_project.service.UserService;

@Controller
public class MapController {
	
	@Autowired
	private Restaurantservice restaurantService;
	
	@Autowired
	private UserService userService;
	
	@Value("${project.kakao.appkey}")
	private String kakaoAppKey;
	
	
	@GetMapping("/map/mainmap")
	public String mainmap(Model model, @AuthenticationPrincipal CustomUser userDatails) {
		model.addAttribute("apikey",kakaoAppKey);
		if(userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			//해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		List<RestaurantVO> list = restaurantService.show_Restaurant();
		model.addAttribute("list", list);
		
		return "/map/mainmap";
		
	}
	
	@ResponseBody
	@PostMapping("/map/mainmap")
	public Map<String, Object> mainMapPost(){
		List<RestaurantVO> list = restaurantService.show_Restaurant();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return map;
	}
	
	@GetMapping("/map/searchmap")
	public String searchmap(String search, Model model , @AuthenticationPrincipal CustomUser userDatails) {
		model.addAttribute("apikey",kakaoAppKey);
		search = search.trim();
		if(search == null || search == "") {
			String say = "잘못된 주소입니다.";
			String link = "/map/mainmap";
			model.addAttribute("say",say);
			model.addAttribute("link",link);
			return "/message";
		}
		//로그인 했으면 db에 검색목록 저장
		if(userDatails != null) {
			String username = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(username);
			model.addAttribute("sh", sh);
			if(userService.insert_SH(username,search)) {
				System.out.println("성공");
			}
		}
		model.addAttribute("search",search);
		return "/map/searchmap";
	}
	
	@ResponseBody
	@PostMapping("/map/searchmap")
	public Map<String, Object> searchmapPost(){
		List<RestaurantVO> list = restaurantService.show_Restaurant();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return map;
	}
	

	@GetMapping("/map/category/{type}")
	public String typemap(Model model,@PathVariable String type, @AuthenticationPrincipal CustomUser userDatails) {
		model.addAttribute("apikey",kakaoAppKey);
		if(userDatails != null) {
			System.out.println(userDatails.getMember().getUser_id());
			//해당 사용자의 최근 검색어를 가져와서 뿌림
			String User_id = userDatails.getMember().getUser_id();
			List<Search_historyVO> sh = userService.get_SH(User_id);
			model.addAttribute("sh", sh);
		}
		List<RestaurantVO> list = restaurantService.show_Restaurant(type);
		model.addAttribute("list", list);
		
		return "/map/category";
		
	}
	
	@ResponseBody
	@PostMapping("/map/category")
	public Map<String, Object> typeMapPost(@RequestParam("text") String category){
		String category_name= restaurantService.get_category(category);
		if(category_name == null) {
			System.out.println("카테고리에 없어서 전체 목록으로");
			List<RestaurantVO> list = restaurantService.show_Restaurant();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);
			return map;
		}
		List<RestaurantVO> list = restaurantService.show_Restaurant(category_name);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		return map;
	}
	
}
