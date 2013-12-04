package edu.jhu.project.thegameshop.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id @Email @Size(min=6, max=40) 
	private String username;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String lastName;
	
	private String creditCardId;

	private int enabled;

	@Size(min=6, max=40) 
	private String password;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="BillingAddressId")
	private Address address1;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="ShippingAddressId")
	private Address address2;

	@OneToMany(mappedBy="user")
	private List<Role> roles;
	
	public User() {
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress1() {
		return this.address1;
	}

	public void setAddress1(Address address1) {
		this.address1 = address1;
	}

	public Address getAddress2() {
		return this.address2;
	}

	public void setAddress2(Address address2) {
		this.address2 = address2;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCreditCardId() {
		return creditCardId;
	}

	public void setCreditCardId(String creditCardId) {
		this.creditCardId = creditCardId;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
