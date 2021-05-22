package springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User1;
import springmvc.service.UserService;

@Controller
public class ContactController {

	@Autowired
	private UserService userService;
	
	
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	@ModelAttribute
	public void commonDataForModel(Model model) {
		model.addAttribute("desc","Student Form");
		
	}
	
	
	@RequestMapping("/contact")
	public String showForm(Model model) {
		//model.addAttribute("desc","Student Form");
		return "contact";
	}
	
//	@RequestMapping(path="/processform", method=RequestMethod.POST)
//	public String handleform(HttpServletRequest request) {
//
//		String email = request.getParameter("email");
//		System.out.println("user email :"+email);
//		return "";
//	}
//
//	@RequestMapping(path="/processform", method=RequestMethod.POST)
//	public String handleform(
//		@RequestParam(name="email",required = false) String userEmail
//		,@RequestParam("name") String userName,
//		@RequestParam("password") String userPassword,Model model) {
//		System.out.println("user email "+userEmail);
//		System.out.println("user name "+userName);
//		System.out.println("user password "+userPassword);
//		
//		//process
//		model.addAttribute("name",userName);
//		model.addAttribute("email",userEmail);
//		model.addAttribute("password",userPassword);
//		
//		
//		return "success";
//	}
    
//	@RequestMapping(path="/processform", method=RequestMethod.POST)
//	public String handleform(
//		@RequestParam(name="email",required = false) String userEmail
//		,@RequestParam("name") String userName,
//		@RequestParam("password") String userPassword,Model model) {
//		
//		User1 user=new User1();
//		user.setName(userName);
//		user.setEmail(userEmail);
//		user.setPassword(userPassword);
//		
//		System.out.println(user);
//		
//		model.addAttribute("user",user);
//		
//		//process
////		model.addAttribute("name",userName);
////		model.addAttribute("email",userEmail);
////		model.addAttribute("password",userPassword);
////		
//		
//		return "success";
//	}

	@RequestMapping(path="/processform", method=RequestMethod.POST)
	public String handleform(@ModelAttribute User1 user ,Model model) {
		
		System.out.println(user);
		this.userService.createUser(user);
		model.addAttribute("user",user);
		
		//process
		
		
		return "success";
	}

}
