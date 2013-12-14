package edu.jhu.project.thegameshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@RequestMapping(method = RequestMethod.GET)
	public String aboutUs(Model m) {
		
		return "company/aboutUs";
	}
	
	@RequestMapping(value="/vision",method = RequestMethod.GET)
	public String vision(Model m) {
		
		return "company/vision";
	}
	
	@RequestMapping(value="/news",method = RequestMethod.GET)
	public String news(Model m) {
		
		return "company/news";
	}
	
	@RequestMapping(value="/location",method = RequestMethod.GET)
	public String location(Model m) {
		
		return "company/location";
	}
	
	@RequestMapping(value="/contactUs",method = RequestMethod.GET)
	public String contactUs(Model m) {
		
		return "company/contactUs";
	}
}
