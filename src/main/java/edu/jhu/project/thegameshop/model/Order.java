package edu.jhu.project.thegameshop.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int orderId;

	private BigDecimal cost;

	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date orderDt;

	private String username;

	//bi-directional many-to-one association to Shippingmethod
	@ManyToOne
	@JoinColumn(name="ShippingMethodId")
	private Shippingmethod shippingmethod;

	//bi-directional many-to-one association to Orderitem
	@OneToMany(fetch = FetchType.EAGER, mappedBy="order")
	private List<Orderitem> orderitems;
	
	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="ShippingAddressId")
	private Address address;

	public Order() {
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getCost() {
		return this.cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getOrderDt() {
		return this.orderDt;
	}

	public void setOrderDt(Date orderDt) {
		this.orderDt = orderDt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Shippingmethod getShippingmethod() {
		return this.shippingmethod;
	}

	public void setShippingmethod(Shippingmethod shippingmethod) {
		this.shippingmethod = shippingmethod;
	}

	public List<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}