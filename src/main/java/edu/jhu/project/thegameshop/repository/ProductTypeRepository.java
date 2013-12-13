package edu.jhu.project.thegameshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.jhu.project.thegameshop.model.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer>{

	@Query("SELECT p FROM ProductType p WHERE p.product.productId = :productId")
	public List<ProductType> selectByProductId(@Param("productId") int productId);
}
