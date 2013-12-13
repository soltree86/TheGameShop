package edu.jhu.project.thegameshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.jhu.project.thegameshop.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("SELECT o FROM Order o WHERE o.username = :username")
	public List<Order> findByUserName(@Param("username") String username);
}
