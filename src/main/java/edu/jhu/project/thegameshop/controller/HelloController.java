package edu.jhu.project.thegameshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.jhu.project.thegameshop.service.UserService;

@Controller
@RequestMapping("/")
public class HelloController {
 
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		
		model.addAttribute("message", "Hello World!");
		return "hello";
	}
}