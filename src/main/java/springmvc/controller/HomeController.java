package springmvc.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String Home(Model model) {
		
		model.addAttribute("name","shiv gupta");
		model.addAttribute("id",142);
		
		List<String> friends=new ArrayList<String>();
		friends.add("vandana");
		friends.add("shipra");
		friends.add("chandni");
		model.addAttribute("f",friends);
		
		return "index";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
}
