package edu.jhu.project.thegameshop.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the orderitem database table.
 * 
 */
@Entity
@Table(name = "orderitem")
public class Orderitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int orderItemId;

	private int productId;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="OrderId")
	private Order order;

	private int quantity;
	
	public Orderitem() {
	}
	
	public Orderitem(int productId, Order order, int quantity) {
		this.productId = productId;
		this.order = order;
		this.quantity = quantity;
	}

	public int getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}