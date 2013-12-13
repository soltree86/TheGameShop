package edu.jhu.project.thegameshop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.jhu.project.thegameshop.exception.OrderNotFound;
import edu.jhu.project.thegameshop.model.Orderitem;
import edu.jhu.project.thegameshop.repository.OrderItemRepsitory;

@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Resource
	private OrderItemRepsitory orderItemRepsitory;
	
	public Orderitem create(Orderitem orderItem) {
		return orderItemRepsitory.save(orderItem);
	}

	public Orderitem delete(int orderItemId) throws OrderNotFound {
		Orderitem deleted = orderItemRepsitory.findOne(orderItemId);
		
		if(deleted == null)
			throw new OrderNotFound();
		
		orderItemRepsitory.delete(deleted);
		
		return deleted;
	}

	public List<Orderitem> findAll() {
		return orderItemRepsitory.findAll();
	}

	public Orderitem update(Orderitem orderItem) throws OrderNotFound {
		Orderitem updated = orderItemRepsitory.findOne(orderItem.getOrderItemId());
		
		if(updated == null)
			throw new OrderNotFound();
		
		updated.setOrder(orderItem.getOrder());
		updated.setProductId(orderItem.getProductId());
		
		orderItemRepsitory.save(updated);
		
		return updated;
	}

	public Orderitem findById(int orderItemId) {
		return orderItemRepsitory.findOne(orderItemId);
	}

	public List<Orderitem> findByOrderId(int orderId) {
		return orderItemRepsitory.findByOrderId(orderId);
	}

}
