package edu.jhu.project.thegameshop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.jhu.project.thegameshop.exception.ProductNotFound;
import edu.jhu.project.thegameshop.model.ProductType;
import edu.jhu.project.thegameshop.repository.ProductTypeRepository;

@Service
public class ProductTypeServiceImpl implements ProductTypeService{
	
	@Resource
	private ProductTypeRepository productTypeRepository; 
	
	
	@Transactional
	public ProductType create(ProductType productType) {
		return productTypeRepository.save(productType);
	}

	@Transactional
	public void createList(List<ProductType> productTypeList) {
		for(ProductType productType : productTypeList) {
			productTypeRepository.save(productType);
		}
	}
	
	@Transactional(rollbackFor=ProductNotFound.class)
	public ProductType delete(int productTypeId) throws ProductNotFound {
		ProductType deleted = productTypeRepository.findOne(productTypeId);
		if(deleted == null)
			throw new ProductNotFound();

		productTypeRepository.delete(deleted);
		return deleted;
	}

	public List<ProductType> findAll() {
		return productTypeRepository.findAll();
	}

	@Transactional(rollbackFor=ProductNotFound.class)
	public ProductType update(ProductType productType) throws ProductNotFound {
		ProductType updated = productTypeRepository.findOne(productType.getProductTypeId());
		if(updated == null)
			throw new ProductNotFound();
		
		productTypeRepository.save(updated);
		return null;
	}

	public ProductType findById(int productTypeId) {
		return null;
	}

	@Transactional(rollbackFor=ProductNotFound.class)
	public void deleteList(int productId) {
		List<ProductType> list = productTypeRepository.selectByProductId(productId);
		for(ProductType pt : list) {
			productTypeRepository.delete(pt.getProductTypeId());
		}
		
	}

}
