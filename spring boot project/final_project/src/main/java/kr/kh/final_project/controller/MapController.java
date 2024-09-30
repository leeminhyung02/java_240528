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
import kr.kh.final_project.service.RestaurantService;

@Controller
public class MapController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	
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
}
