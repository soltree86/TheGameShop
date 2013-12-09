package edu.jhu.project.thegameshop.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.jhu.project.thegameshop.dto.FileUploadForm;
import edu.jhu.project.thegameshop.dto.ProductDTO;
import edu.jhu.project.thegameshop.model.Product;
import edu.jhu.project.thegameshop.model.ProductType;
import edu.jhu.project.thegameshop.service.ProductService;
import edu.jhu.project.thegameshop.service.ProductTypeService;
import edu.jhu.project.thegameshop.util.ProductConversionUtil;

@Controller
@RequestMapping("/admin/**")
public class AdminController{

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductTypeService productTypeService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String admin(ModelMap model, Principal principal ) {
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Admin Console");

		return "admin/admin";
	}
	
	@RequestMapping(value="/addProductPage", method = RequestMethod.GET)
	public String getAddPage(Model m) {
		m.addAttribute("productDTO", new ProductDTO());
		//List<String> genreList = getGenreList();
		//m.addAttribute("genreList", genreList);
		
		return "admin/addProduct";
	}
	
	@RequestMapping(value="/addProduct", method = RequestMethod.POST)
	public String addProduct(@Valid ProductDTO productDTO, BindingResult result, Model m) throws Exception {
		if (result.hasErrors()) {
			m.addAttribute("message","Invalid Input");
			return "admin/addProduct";
		}
		
		Product product = ProductConversionUtil.productDTOToProduct(productDTO);
		
		Product created = productService.create(product);
		
		List<ProductType> ptList = new ArrayList<ProductType>();
		for(String s : productDTO.getGenreList()) {
			ptList.add(new ProductType(created, s));
		}
		ptList.add(new ProductType(created, productDTO.getCategory()));
		product.setProductTypes(ptList);
		
		productTypeService.deleteList(product.getProductId());
		productTypeService.createList(ptList);
		
		return "hello";
	}
	
	@RequestMapping(value="/addProductImage", method = RequestMethod.POST)
	public String addProductImage(@ModelAttribute("uploadForm") FileUploadForm uploadForm, Model m) throws Exception {
		m.addAttribute("message", "Product is successfully Created");
		return "hello";
	}
}
