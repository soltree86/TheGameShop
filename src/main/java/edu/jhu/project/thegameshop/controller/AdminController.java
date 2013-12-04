package edu.jhu.project.thegameshop.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(method = RequestMethod.GET)
	public String admin(ModelMap model, Principal principal ) {
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Admin Console");

		return "admin/admin";
	}
}
