package edu.jhu.project.thegameshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.jhu.project.thegameshop.model.Product;
import edu.jhu.project.thegameshop.model.Role;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("SELECT p FROM Product p WHERE p.name = :name")
	public Product findByProductName(@Param("name") String name);
}
