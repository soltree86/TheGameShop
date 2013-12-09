package edu.jhu.project.thegameshop.model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the producttype database table.
 * 
 */
@Entity
@Table(name = "producttype")
public class ProductType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int productTypeId;

	private String description;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;

	public ProductType(){
	}
	
	public ProductType(Product product, String description) {
		this.product = product;
		this.description = description;
	}

	public int getProductTypeId() {
		return this.productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}