package edu.jhu.project.thegameshop.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name = "Address")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer addressId;

	private String city;

	private String state;

	private String street1;

	private String street2;

	private String zip;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="address1")
	private List<User> users1;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="address2")
	private List<User> users2;

	public Address() {
	}

	public int getAddressId() {
		return this.addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet1() {
		return this.street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return this.street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public List<User> getUsers1() {
		return this.users1;
	}

	public void setUsers1(List<User> users1) {
		this.users1 = users1;
	}

	public List<User> getUsers2() {
		return this.users2;
	}

	public void setUsers2(List<User> users2) {
		this.users2 = users2;
	}

}