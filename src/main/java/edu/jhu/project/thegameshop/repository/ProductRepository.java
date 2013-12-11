package edu.jhu.project.thegameshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.jhu.project.thegameshop.model.Product;
import edu.jhu.project.thegameshop.model.Role;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.name = :name")
	public Product findByProductName(@Param("name") String name);
	
	@Query("SELECT p FROM Product p WHERE p.name like :name")
	public List<Product> findByLikeProductName(@Param("name") String name);
	
	@Query("SELECT p FROM Product p JOIN p.productTypes pt WHERE p.isConsole = 1 and pt.description like :type")
	public List<Product> findConsoleByLikeType(@Param("type") String type);
	
	@Query("SELECT p FROM Product p JOIN p.productTypes pt WHERE p.isConsole = 0 and pt.description like :type")
	public List<Product> findPCByLikeType(@Param("type") String type);
}
