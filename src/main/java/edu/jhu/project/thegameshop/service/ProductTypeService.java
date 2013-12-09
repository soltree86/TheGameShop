package edu.jhu.project.thegameshop.service;

import java.util.List;

import edu.jhu.project.thegameshop.exception.ProductNotFound;
import edu.jhu.project.thegameshop.model.ProductType;

public interface ProductTypeService {
	public ProductType create(ProductType productType);
	public ProductType delete(int productTypeId) throws ProductNotFound;
	public List<ProductType> findAll();
	public ProductType update(ProductType productType) throws ProductNotFound;
	public ProductType findById(int productTypeId);
	public void createList(List<ProductType> productTypeList);
	public void deleteList(int productId);
}
