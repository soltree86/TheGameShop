package edu.jhu.project.thegameshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.jhu.project.thegameshop.model.Orderitem;

public interface OrderItemRepsitory extends JpaRepository<Orderitem, Integer> {
	@Query("SELECT o FROM Orderitem o WHERE o.order.orderId = :orderId")
	public List<Orderitem> findByOrderId(@Param("orderId") int orderId);
}
