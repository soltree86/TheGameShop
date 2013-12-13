package edu.jhu.project.thegameshop.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.jhu.project.thegameshop.dto.ProductDTO;
import edu.jhu.project.thegameshop.dto.ProductJsonDTO;
import edu.jhu.project.thegameshop.exception.ProductNotFound;
import edu.jhu.project.thegameshop.model.Cart;
import edu.jhu.project.thegameshop.model.Product;
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
	
	@RequestMapping(value="/shoppingCart",  method = RequestMethod.GET) 
	public String shoppingCart(Model m) {
		if(cart.getItemList() == null || cart.getItemList().size() == 0) {
			cart.setItemList(new ArrayList<ProductDTO>());
		}
		
		return "shop/shoppingCart";
	}
	
	@RequestMapping(value="/addToCart/{id}", method = RequestMethod.GET)
	public String addToCart(@PathVariable int id, Model m) throws IOException, ProductNotFound {
		Product product = productService.findById(id);
		if(product.getQuantity() - 1 >= 0) {
			product.setQuantity(product.getQuantity() - 1);
		}
		else {
			m.addAttribute("message", "Out of Stock!");
			return "shop/productDetail";
		}
		productService.update(product);
		
		ProductDTO dto = ProductConversionUtil.productToProductDTO(product);
		//Initialize num Item
		dto.setNumItems(1);
		
		//initialize session object if it is null or empty
		if(cart.getItemList() == null || cart.getItemList().size() == 0) {
			cart.setItemList(new ArrayList<ProductDTO>());
			cart.getItemList().add(dto);
		} else {
			List<ProductDTO> dtoList = cart.getItemList();
			
			boolean found = false;
			for(ProductDTO d : dtoList) {
				if(d.getId() == dto.getId()) {
					d.setNumItems(d.getNumItems() + 1);
					found = true;
					break;
				}
			}
			
			if(!found) {
				dtoList.add(dto);
			}
			cart.setItemList(dtoList);
		}
		
		BigDecimal totalCost = new BigDecimal(0);
		
		for(ProductDTO d : cart.getItemList()) {
			totalCost = totalCost.add(d.getPrice().multiply(new BigDecimal(d.getNumItems())));
		}
		
		cart.setTotalCost(totalCost);
		
		
		return "redirect:/shop/shoppingCart";
	}
	
	@RequestMapping(value="/updateCart", method = RequestMethod.POST)
	public String updateCart(@RequestParam("id") int id, @RequestParam("numItems") int numItems, Model m) throws ProductNotFound {
		Product product = productService.findById(id);
		int numItemsReturn = 0;
		BigDecimal totalCost = new BigDecimal(0);
		for(int i = 0; i < cart.getItemList().size(); i++) {
			ProductDTO dto = cart.getItemList().get(i);
			if(dto.getId() == id) {
				if(numItems == 0) {
					numItemsReturn =  dto.getNumItems();
					cart.getItemList().remove(i);
				} else {
					numItemsReturn =  dto.getNumItems();
					cart.getItemList().get(i).setNumItems(numItems);
				}
			}
		}
		int totalQuantity = product.getQuantity() + numItemsReturn - numItems;
		if(totalQuantity < 0){
			m.addAttribute("message", "We have less than " + numItems + " stock(s) for " + product.getName() + ". Please enter less quantity");
			return "shop/shoppingCart";
		}
		product.setQuantity(totalQuantity);
		
		productService.update(product);
		for(ProductDTO p : cart.getItemList()) {
			totalCost = totalCost.add(p.getPrice().multiply(new BigDecimal(p.getNumItems())));
		}
		cart.setTotalCost(totalCost);
		
		return "redirect:/shop/shoppingCart";
	}
	
	@RequestMapping(value="/remove/{id}", method = RequestMethod.GET)
	public String removeItem(@PathVariable int id, Model m) throws IOException, ProductNotFound {
		Product product = productService.findById(id);
		int numItemsReturn = 0;
		for(int i = 0; i < cart.getItemList().size(); i++) {
			ProductDTO dto = cart.getItemList().get(i);
			if(dto.getId() == id) {
				numItemsReturn =  dto.getNumItems();
				cart.getItemList().remove(i);
			}
		}
		
		product.setQuantity(product.getQuantity() + numItemsReturn);
		
		product = productService.update(product);
		m.addAttribute("product", product);
		
		return "redirect:/shop/shoppingCart";
	}
	
	@RequestMapping(value="/itemDetail/{id}", method = RequestMethod.GET)
	public String itemDetail(@PathVariable int id, Model m) throws IOException, ProductNotFound {
		Product product = productService.findById(id);
		
		m.addAttribute("product", product);
		
		return "shop/productDetail";
	}
	
}
