package edu.jhu.project.thegameshop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.jhu.project.thegameshop.exception.OrderNotFound;
import edu.jhu.project.thegameshop.model.Order;
import edu.jhu.project.thegameshop.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Resource
	private OrderRepository orderRepository;
	
	@Transactional
	public Order create(Order order) {
		return orderRepository.save(order);
	}

	@Transactional(rollbackFor=OrderNotFound.class)
	public Order delete(int orderId) throws OrderNotFound {
		Order deleted = orderRepository.findOne(orderId);
		if(deleted == null)
			throw new OrderNotFound();
		
		orderRepository.delete(deleted);
		return deleted;
	}

	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Transactional(rollbackFor=OrderNotFound.class)
	public Order update(Order order) throws OrderNotFound {
		Order updated = orderRepository.findOne(order.getOrderId());
		if(updated == null) 
			throw new OrderNotFound();
		
		updated.setCost(order.getCost());
		updated.setDescription(order.getDescription());
		updated.setOrderDt(order.getOrderDt());
		updated.setOrderitems(order.getOrderitems());
		updated.setShippingmethod(order.getShippingmethod());
		updated.setUsername(order.getUsername());
		
		orderRepository.save(updated);
		return updated;
	}

	public Order findById(int orderId) {
		return orderRepository.findOne(orderId);
	}

	public List<Order> findByUserName(String username) {
		return orderRepository.findByUserName(username);
	}

}
