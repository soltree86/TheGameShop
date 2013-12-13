package edu.jhu.project.thegameshop.controller;


import java.math.BigDecimal;
import java.security.Principal;
import java.util.Date;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.jhu.project.thegameshop.dto.CheckOutDTO;
import edu.jhu.project.thegameshop.dto.ProductDTO;
import edu.jhu.project.thegameshop.model.Address;
import edu.jhu.project.thegameshop.model.Cart;
import edu.jhu.project.thegameshop.model.Order;
import edu.jhu.project.thegameshop.model.Orderitem;
import edu.jhu.project.thegameshop.model.Shippingmethod;
import edu.jhu.project.thegameshop.service.AddressService;
import edu.jhu.project.thegameshop.service.OrderItemService;
import edu.jhu.project.thegameshop.service.OrderService;
import edu.jhu.project.thegameshop.util.MailUtilWithAuth;
import edu.jhu.project.thegameshop.util.ProductConversionUtil;

@Controller
@Scope("request")
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	private Cart cart;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderItemService orderItemService;
		
	@RequestMapping(method = RequestMethod.GET)
	public String checkOut(Model m) {
		m.addAttribute("checkOutDTO", new CheckOutDTO());
		return "checkout/checkout";
	}
	
	@Transactional(rollbackFor=Exception.class)
	@RequestMapping(value="/confirm", method = RequestMethod.POST)
	public String confirmation(@Valid CheckOutDTO checkOutDTO, BindingResult result, Model m, Principal principal) throws MessagingException {
		if (result.hasErrors()) {
			m.addAttribute("message","Invalid Input");
			return "checkout/checkout";
		}
		
		//Create Address
		Address address = ProductConversionUtil.addressDTOToAddress(checkOutDTO.getShip());
		address = addressService.create(address);
		
		//Create Order
		Order order = new Order();
		order.setUsername(principal.getName());
		order.setAddress(address);
		order.setOrderDt(new Date());
		String description = "";
		for(ProductDTO dto : cart.getItemList()){
			description += dto.getName() + ",";
		}
		description = description.substring(0, description.length() - 1);
		if(description.length() > 30) {
			description = description.substring(0, 30);
			description += "....";
		}
		order.setDescription(description);
		order.setCost(cart.getTotalCost());
		String methodDesc = "";
		if(checkOutDTO.getShippingMethodId() == 1) {
			methodDesc = "Fedex";
		} else if(checkOutDTO.getShippingMethodId() == 2) {
			methodDesc = "UPS";
		} else{
			methodDesc = "USPS";
		}
		order.setShippingmethod(new Shippingmethod(checkOutDTO.getShippingMethodId(), methodDesc));
		
		order = orderService.create(order);
		
		for(ProductDTO dto : cart.getItemList()) {
			orderItemService.create(new Orderitem(dto.getId(), order, dto.getNumItems()));
		}
		MailUtilWithAuth mailUtil = new MailUtilWithAuth();
		String emailMessage = "Your order has been shipped. Total Cost : $" + cart.getTotalCost() + ". Please login to your My Account to check the order information.";
		
		mailUtil.sendMail(principal.getName(), "admin@thegameshop.com", "TheGameShop - Order Confirmation", emailMessage);
		
		//remove the cart from the session
		cart = new Cart();
		return "checkout/confirmation";
	}
	
}
