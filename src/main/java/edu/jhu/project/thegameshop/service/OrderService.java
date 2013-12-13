package edu.jhu.project.thegameshop.service;

import java.util.List;

import edu.jhu.project.thegameshop.exception.OrderNotFound;
import edu.jhu.project.thegameshop.model.Order;

public interface OrderService {
	public Order create(Order order);
	public Order delete(int orderId) throws OrderNotFound;
	public List<Order> findAll();
	public Order update(Order order) throws OrderNotFound;
	public Order findById(int orderId);
	public List<Order> findByUserName(String username);
}
