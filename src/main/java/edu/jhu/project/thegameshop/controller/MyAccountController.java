package edu.jhu.project.thegameshop.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.jhu.project.thegameshop.dto.ProductDTO;
import edu.jhu.project.thegameshop.model.Order;
import edu.jhu.project.thegameshop.model.Orderitem;
import edu.jhu.project.thegameshop.model.User;
import edu.jhu.project.thegameshop.service.OrderItemService;
import edu.jhu.project.thegameshop.service.OrderService;
import edu.jhu.project.thegameshop.service.ProductService;
import edu.jhu.project.thegameshop.service.UserService;
import edu.jhu.project.thegameshop.util.ProductConversionUtil;

@Controller
@RequestMapping(value="/myAccount")
public class MyAccountController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String myAccountInformation(Model m, Principal p) {
		List<Order> orderList = orderService.findByUserName(p.getName());
		
		User user = userService.findById(p.getName());
		
		m.addAttribute("orderList", orderList);
		m.addAttribute("user", user);
		
		return "account/myAccount";
	}
	
	@RequestMapping(value="/history/{id}", method = RequestMethod.GET)
	public String orderHistoryDetail(@PathVariable int id, Model m) throws IOException {
		List<Orderitem> list = orderItemService.findByOrderId(id);
		Order order = orderService.findById(id);
		
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		
		for(Orderitem o : list) {
			ProductDTO dto = ProductConversionUtil.productToProductDTO(productService.findById(o.getProductId()));
			dto.setNumItems(o.getQuantity());
			productList.add(dto);
		}
		
		m.addAttribute("productList", productList);
		m.addAttribute("order", order);
		
		return "account/orderDetail";
	}
	
}
