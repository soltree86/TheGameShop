package edu.jhu.project.thegameshop.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.jhu.project.thegameshop.dto.ProductDTO;
import edu.jhu.project.thegameshop.dto.ProductJsonDTO;
import edu.jhu.project.thegameshop.exception.ProductNotFound;
import edu.jhu.project.thegameshop.model.Cart;
import edu.jhu.project.thegameshop.model.Product;
import edu.jhu.project.thegameshop.model.ProductType;
import edu.jhu.project.thegameshop.service.ProductService;
import edu.jhu.project.thegameshop.service.ProductTypeService;
import edu.jhu.project.thegameshop.util.ProductConversionUtil;

@Controller
@Scope("request")
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private Cart cart;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductTypeService productTypeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getShopPage(Model m){
		return "shop/productList";
	}
	
	@RequestMapping(value="/getProductList", method = RequestMethod.POST)
	public @ResponseBody List<ProductJsonDTO> createProductList(@RequestBody String input, Model m) throws Exception {
		input = input.replace("\"", "");
		input = input.replace("[", "");
		input = input.replace("]", "");
		
		String []array = input.split(",");
		
		boolean isConsole = array[0].equals("Console") ? true : false;
		
		List<Product> productList = productService.findByLikeType(array[1], isConsole);
		List<ProductJsonDTO> jsonlist = ProductConversionUtil.productsToJsonObjects(productList);
		
		return jsonlist;
	}
	
	@RequestMapping(value="/addToCart/{id}", method = RequestMethod.GET)
	public String shoppingCart(@PathVariable int id, Model m) throws IOException, ProductNotFound {
		Product product = productService.findById(id);
		
		ProductDTO dto = ProductConversionUtil.productToProductDTO(product);
		dto.setNumItems(1);
		
		if(cart.getItemList() == null) 
			cart.setItemList(new ArrayList<ProductDTO>());
		
		List<ProductDTO> dtoList = cart.getItemList();
		
		boolean found = false;
		
		for(ProductDTO d : dtoList) {
			if(d.getId() == dto.getId()) {
				d.setNumItems(d.getNumItems() + 1);
				found = true;
				break;
			}
		}
		
		if(!found) 
			dtoList.add(dto);
		
		cart.setItemList(dtoList);
		
		long totalCost = 0;
		
		for(ProductDTO d : cart.getItemList()) {
			totalCost += (d.getNumItems() * d.getPrice().longValue());
		}
		
		cart.setTotalCost(totalCost);
		
		
		return "shop/shoppingCart";
	}
	
	@RequestMapping(value="/itemDetail/{id}", method = RequestMethod.GET)
	public String itemDetail(@PathVariable int id, Model m) throws IOException, ProductNotFound {
		Product product = productService.findById(id);
		
		m.addAttribute("product", product);
		
		return "shop/productDetail";
	}
	
}
