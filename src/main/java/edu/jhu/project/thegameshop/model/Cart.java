package edu.jhu.project.thegameshop.model;


import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import edu.jhu.project.thegameshop.dto.ProductDTO;

@Component
@Scope("session")
public class Cart {

	private List<ProductDTO> itemList;

	private long totalCost;
	
	public List<ProductDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ProductDTO> itemList) {
		this.itemList = itemList;
	}

	public long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(long totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
