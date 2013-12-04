package edu.jhu.project.thegameshop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

	@RequestMapping(method = RequestMethod.GET)
	public String admin(ModelMap model) {
		model.addAttribute("message", "Checkout Page!!");

		return "checkout/checkout";
	}
	
}
