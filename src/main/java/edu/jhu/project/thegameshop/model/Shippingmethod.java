package edu.jhu.project.thegameshop.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the shippingmethod database table.
 * 
 */
@Entity
@Table(name = "Shippingmethod")
public class Shippingmethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int shippingMethodId;

	private String description;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="shippingmethod")
	private List<Order> orders;

	public Shippingmethod() {
	}
	
	public Shippingmethod(int id, String description) {
		this.shippingMethodId = id;
		this.description = description;
	}

	public int getShippingMethodId() {
		return this.shippingMethodId;
	}

	public void setShippingMethodId(int shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}