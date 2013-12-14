package edu.jhu.project.thegameshop.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.jhu.project.thegameshop.dto.ProductDTO;
import edu.jhu.project.thegameshop.dto.ProductJsonDTO;
import edu.jhu.project.thegameshop.exception.ProductNotFound;
import edu.jhu.project.thegameshop.model.Product;
import edu.jhu.project.thegameshop.model.ProductType;
import edu.jhu.project.thegameshop.service.ProductService;
import edu.jhu.project.thegameshop.service.ProductTypeService;
import edu.jhu.project.thegameshop.util.ProductConversionUtil;

@Controller
@RequestMapping("/admin")
public class AdminController{

	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductTypeService productTypeService;
	
	private static final String UPLOAD_DIRECTORY = "resources/imageuploads";
	
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
	public String addProduct(@Valid ProductDTO productDTO, BindingResult result, Model m, HttpServletRequest request) throws Exception {
		if (result.hasErrors()) {
			m.addAttribute("message","Invalid Input");
			return "admin/addProduct";
		}
		ServletContext servletContext = request.getServletContext();
		servletContext.getRealPath("");
		Product product = ProductConversionUtil.productDTOToProduct(productDTO);
		
		Product created = productService.create(product);
		
		if(productDTO.getFile() != null) {
			saveMultipartToDisk(servletContext, productDTO.getFile(), created);
		}
		productService.update(created);
		
		List<ProductType> ptList = new ArrayList<ProductType>();
		for(String s : productDTO.getGenreList()) {
			ptList.add(new ProductType(created, s));
		}
		product.setProductTypes(ptList);
		
		productTypeService.deleteList(created.getProductId());
		productTypeService.createList(ptList);
		
		m.addAttribute("product", created);
		m.addAttribute("message", "Product " + product.getName() + " is successfully added.");
		return "admin/productDetail";
	}
	
	@RequestMapping(value="/productList", method = RequestMethod.GET)
	public String addProductImage(Model m) throws Exception {
		return "admin/productList";
	}
	
	@RequestMapping(value="/editProductPage/{id}", method = RequestMethod.GET)
	public String getEditPage(@PathVariable int id, Model m, HttpServletRequest request) throws IOException {
		
		Product product = productService.findById(id);
		
		ProductDTO dto = ProductConversionUtil.productToProductDTO(product);
				
		m.addAttribute("productDTO", dto);
		m.addAttribute("image", product.getImage());
		
		return "admin/editProduct";
	}
	
	@RequestMapping(value="/deleteProduct/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable int id, Model m) throws IOException, ProductNotFound {
		
		Product product = productService.findById(id);
		
		for(ProductType pt : product.getProductTypes()) {
			productTypeService.delete(pt.getProductTypeId());
		}
		
		productService.delete(product.getProductId());
		
		m.addAttribute("message", "Product - " + product.getName() + " is Successfully Deleted.");
		
		return "hello";
	}
	
	
	@Transactional(rollbackFor=Exception.class)
	@RequestMapping(value="/editProduct", method = RequestMethod.POST)
	public String editProduct(@Valid ProductDTO productDTO, BindingResult result, Model m, HttpServletRequest request) throws Exception {
		if (result.hasErrors()) {
			m.addAttribute("message","Invalid Input");
			return "admin/editProduct";
		}
		ServletContext servletContext = request.getServletContext();
		Product product = ProductConversionUtil.productDTOToProduct(productDTO);
		
		if(productDTO.getFile() != null && !productDTO.getFile().getOriginalFilename().isEmpty()) {
			saveMultipartToDisk(servletContext, productDTO.getFile(), product);
		}
		
		productService.update(product);
		
		List<ProductType> ptList = new ArrayList<ProductType>();
		for(String s : productDTO.getGenreList()) {
			ptList.add(new ProductType(product, s));
		}
		product.setProductTypes(ptList);
		
		productTypeService.deleteList(product.getProductId());
		productTypeService.createList(ptList);
		Product updated = productService.findById(product.getProductId());
		m.addAttribute("product", updated);
		m.addAttribute("message", "Product " + product.getName() + " is successfully added.");
		return "admin/productDetail";
	}
	
	@RequestMapping(value="/createProductList", method = RequestMethod.POST)
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
	
	
	
	@RequestMapping(value="/createProductListTest", method = RequestMethod.GET)
	public @ResponseBody List<ProductJsonDTO> createProductList(Model m) throws Exception {
		//@RequestParam(value="input", required=true) List<String> genres
		List<Product> productList = productService.findByLikeName("World of Warcraft");
		List<ProductJsonDTO> jsonlist = ProductConversionUtil.productsToJsonObjects(productList);
		return jsonlist;
	}
	
	private String calculateDestinationDirectory(ServletContext context, Product product) {
		String result = context.getRealPath("");
		result += "/";
		result += UPLOAD_DIRECTORY;
		result += "/";
		result += product.getProductId();
		return result;
	}
	
	private String calculateDestinationPath(ServletContext context, MultipartFile file, Product product) {
		String result = this.calculateDestinationDirectory(context, product);
		result += "/";
		result += file.getOriginalFilename();
		return result;
	}
	
	private void saveMultipartToDisk(ServletContext context, MultipartFile file, Product product) throws Exception {
		File dir = new File(this.calculateDestinationDirectory(context, product));
		if(!dir.exists()) {
			dir.mkdirs();
		}
		String imageUrl = this.calculateDestinationPath(context, file, product);
		String subUrl = imageUrl.split("TheGameShop")[1];
		product.setImage(subUrl);
		File multipartFile = new File(imageUrl);
		multipartFile.delete();
		file.transferTo(multipartFile);
	}
	
}
