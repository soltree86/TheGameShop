package edu.jhu.project.thegameshop.model;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.jhu.project.thegameshop.dto.ProductDTO;

@Component
@Scope("session")
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<ProductDTO> itemList;

	@Digits(integer=6, fraction=2) @DecimalMax("1000.00") @DecimalMin("1.00")
	private BigDecimal totalCost;
	
	public List<ProductDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ProductDTO> itemList) {
		this.itemList = itemList;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
