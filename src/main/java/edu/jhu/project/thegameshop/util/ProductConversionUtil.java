package edu.jhu.project.thegameshop.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.jhu.project.thegameshop.dto.ProductDTO;
import edu.jhu.project.thegameshop.dto.ProductJsonDTO;
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
		
		return product;
	}
	
	public static ProductJsonDTO productToJsonObject(Product product) {
		return new ProductJsonDTO(product.getProductId(), product.getPrice().longValue(), product.getDescription(),
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
	
}
