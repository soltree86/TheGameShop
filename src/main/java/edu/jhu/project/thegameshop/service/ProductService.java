package edu.jhu.project.thegameshop.service;

import java.util.List;

import edu.jhu.project.thegameshop.exception.ProductNotFound;
import edu.jhu.project.thegameshop.model.Product;

public interface ProductService {
	public Product create(Product product);
	public Product delete(int productId) throws ProductNotFound;
	public List<Product> findAll();
	public Product update(Product product) throws ProductNotFound;
	public Product findById(int productId);
}
