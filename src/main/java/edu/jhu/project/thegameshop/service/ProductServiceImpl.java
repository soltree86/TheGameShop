package edu.jhu.project.thegameshop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.jhu.project.thegameshop.exception.ProductNotFound;
import edu.jhu.project.thegameshop.model.Product;
import edu.jhu.project.thegameshop.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Resource
	private ProductRepository productRepository; 
	
	@Transactional
	public Product create(Product product) {
		Product found = productRepository.findByProductName(product.getName());
		
		if(found != null)
			product.setProductId(found.getProductId());
		
		return productRepository.save(product);
	}
	
	@Transactional(rollbackFor=ProductNotFound.class)
	public Product delete(int productId) throws ProductNotFound {
		Product deleted = productRepository.findOne(productId);

		if(deleted == null) 
			throw new ProductNotFound();
		
		productRepository.delete(deleted);
		return deleted;
	}

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Transactional(rollbackFor=ProductNotFound.class)
	public Product update(Product product) throws ProductNotFound {
		Product updated = productRepository.findOne(product.getProductId());
		if(updated == null)
			throw new ProductNotFound();
		
		updated.setDescription(product.getDescription());
		updated.setEnabled(product.getEnabled());
		updated.setImage(product.getImage());
		updated.setName(product.getName());
		updated.setPrice(product.getPrice());
		updated.setProductTypes(product.getProductTypes());
		updated.setQuantity(product.getQuantity());
		
		productRepository.save(updated);
		return null;
	}

	public Product findById(int productId) {
		// TODO Auto-generated method stub
		return productRepository.findOne(productId);
	}

	public List<Product> findByLikeName(String name) {
		String param = "%" + name + "%";
		return productRepository.findByLikeProductName(param);
	}

	public List<Product> findByLikeType(String type, boolean isConsole) {
		
		String param = "%" + type + "%"; 
		
		return isConsole ? productRepository.findConsoleByLikeType(param) : productRepository.findPCByLikeType(param);
	}
}
