package kr.kh.final_project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.kh.final_project.model.vo.RestaurantVO;
import kr.kh.final_project.service.Restaurantservice;
import kr.kh.final_project.service.UserService;

@Controller
public class MapController {
	
	@Autowired
	private Restaurantservice restaurantService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/map/mainmap")
	public String mainmap(Model model) {
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
	public String searchmap(String search,boolean is_login,String username, Model model ) {
		System.out.println(search);
		search = search.trim();
		if(search == null || search == "") {
			return "/index";
		}
		//로그인 했으면 db에 검색목록 저장
		if(is_login) {
			if(userService.insert_SH(username,search)) {
				System.out.println("성공");
			}
			else {
				System.out.println("실패");
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
}
