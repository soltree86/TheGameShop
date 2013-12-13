package edu.jhu.project.thegameshop.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.jhu.project.thegameshop.dto.AddressDTO;
import edu.jhu.project.thegameshop.dto.ProductDTO;
import edu.jhu.project.thegameshop.dto.ProductJsonDTO;
import edu.jhu.project.thegameshop.model.Address;
import edu.jhu.project.thegameshop.model.Product;
import edu.jhu.project.thegameshop.model.ProductType;

public class ProductConversionUtil {

	public static Product productDTOToProduct(ProductDTO dto) throws IOException {
		Product product = new Product();
		
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setEnabled(dto.getEnabled());
		product.setPrice(dto.getPrice());
		product.setIsConsole(dto.getCategory());
		product.setQuantity(dto.getQuantity());
		
		if(dto.getId() != 0) {
			product.setProductId(dto.getId());
		}
		
		return product;
	}
	
	public static ProductDTO productToProductDTO(Product product) throws IOException {
		
		ProductDTO dto = new ProductDTO();
		
		dto.setName(product.getName());
		dto.setDescription(product.getDescription());
		dto.setEnabled(product.getEnabled());
		dto.setPrice(product.getPrice());
		dto.setCategory(product.getIsConsole());
		dto.setQuantity(product.getQuantity());
		dto.setId(product.getProductId());
		
		List<String> genreList = new ArrayList<String>();
		
		for(ProductType pt :product.getProductTypes()) {
			genreList.add(pt.getDescription());
		}
		
		dto.setGenreList(genreList);
		
		return dto;
	}
	
	public static ProductJsonDTO productToJsonObject(Product product) {
		return new ProductJsonDTO(product.getProductId(), product.getPrice(), product.getDescription(),
				product.getEnabled(), product.getImage(), product.getName(), product.getQuantity(),
				product.getIsConsole());
	}
	
	public static List<ProductJsonDTO> productsToJsonObjects(List<Product> list) {
		List<ProductJsonDTO> jsonList = new ArrayList<ProductJsonDTO>();
		
		for(Product p : list) {
			jsonList.add(productToJsonObject(p));
		}
		
		return jsonList;
	}
	
	public static Address addressDTOToAddress(AddressDTO addressDTO) {
		Address address = new Address();
		
		address.setStreet1(addressDTO.getStreet1());
		address.setStreet2(addressDTO.getStreet2());
		address.setCity(addressDTO.getCity());
		address.setState(addressDTO.getState());
		address.setZip(addressDTO.getZip());
		
		return address;
	}
	
}
