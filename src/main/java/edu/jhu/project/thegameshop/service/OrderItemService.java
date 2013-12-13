package edu.jhu.project.thegameshop.service;

import java.util.List;

import edu.jhu.project.thegameshop.exception.OrderNotFound;
import edu.jhu.project.thegameshop.model.Orderitem;

public interface OrderItemService {
	public Orderitem create(Orderitem orderItem);
	public Orderitem delete(int orderItemId) throws OrderNotFound;
	public List<Orderitem> findAll();
	public Orderitem update(Orderitem orderItem) throws OrderNotFound;
	public Orderitem findById(int orderItemId);
	public List<Orderitem> findByOrderId(int orderId);

}
