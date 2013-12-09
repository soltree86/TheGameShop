package edu.jhu.project.thegameshop.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.jhu.project.thegameshop.dto.ProductDTO;
import edu.jhu.project.thegameshop.model.Product;
import edu.jhu.project.thegameshop.model.ProductType;

public class ProductConversionUtil {

	public static Product productDTOToProduct(ProductDTO dto) throws IOException {
		Product product = new Product();
		
		product.setName(dto.getName());
		product.setDescription(dto.getDescription());
		product.setEnabled(dto.getEnabled());
		product.setImage(dto.getFile().getBytes());
		product.setPrice(dto.getPrice());
		product.setQuantity(dto.getQuantity());
		
		return product;
	}
	
}
