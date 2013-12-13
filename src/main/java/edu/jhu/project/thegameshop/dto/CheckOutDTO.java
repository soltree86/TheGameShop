package edu.jhu.project.thegameshop.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

public class CheckOutDTO {

	@Min(1) @Max(3)
	private int shippingMethodId;
	
	@NotEmpty
	private String cardType;
	
	@NotEmpty
	private String cardNumber;
	
	@Min(1) @Max(12)
	private int month;
	
	@Min(2001) @Max(2020)
	private int year;
	
	private AddressDTO ship = new AddressDTO();
	
	private AddressDTO bill = new AddressDTO();
	
	
	public int getShippingMethodId() {
		return shippingMethodId;
	}

	public void setShippingMethodId(int shippingMethodId) {
		this.shippingMethodId = shippingMethodId;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public AddressDTO getShip() {
		return ship;
	}

	public void setShip(AddressDTO ship) {
		this.ship = ship;
	}

	public AddressDTO getBill() {
		return bill;
	}

	public void setBill(AddressDTO bill) {
		this.bill = bill;
	}
}
