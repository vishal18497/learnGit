package springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirController {

	@RequestMapping("/one")
	public String one() {

		System.out.println("this is one ");
		return "redirect:/two";
	}
	
	@RequestMapping("/three")
	public RedirectView three() {
		RedirectView rv= new RedirectView();
		rv.setUrl("two");
		System.out.println("this is three");
		return rv;
		}
	
	
	@RequestMapping("/two")
	public String two() {
		System.out.println("this is two");
		return "contact";
	}
}
