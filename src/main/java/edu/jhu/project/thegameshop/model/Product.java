package edu.jhu.project.thegameshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int productId;

	private BigDecimal price;

	@Lob
	private String description;

	private int enabled;

	@Lob
	private byte[] image;

	private String name;

	private int quantity;

	//bi-directional many-to-one association to Producttype
	@OneToMany(mappedBy="product")
	private List<ProductType> productTypes;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public byte[] getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<ProductType> getProductTypes() {
		return this.productTypes;
	}

	public void setProductTypes(List<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

	public ProductType addProductType(ProductType productType) {
		getProductTypes().add(productType);
		productType.setProduct(this);

		return productType;
	}

	public ProductType removeProductType(ProductType productType) {
		getProductTypes().remove(productType);
		productType.setProduct(null);

		return productType;
	}

}
