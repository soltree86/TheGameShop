package edu.jhu.project.thegameshop.dto;

import java.math.BigDecimal;

public class ProductJsonDTO {
	private int productId;

	private BigDecimal price;

	private String description;

	private int enabled;

	private String image;

	private String name;

	private int quantity;
	
	private int category;

	public ProductJsonDTO () {
		
	}
	
	public ProductJsonDTO(int productId, BigDecimal price, String description,
			int enabled, String image, String name, int quantity,
			int category) {
		super();
		this.productId = productId;
		this.price = price;
		this.description = description;
		this.enabled = enabled;
		this.image = image;
		this.name = name;
		this.quantity = quantity;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

}
