package edu.jhu.project.thegameshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String getLoginPage() {
		return "login/login";
	}
	
	@RequestMapping(value="/denied", method = RequestMethod.GET)
	public String getLogoutPage() {
		return "login/denied";
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public String getLoginPage(Model m) {
		
		m.addAttribute("message", "Invalid username or password.");
		
		return "login/login";
	}
}
