package edu.jhu.project.thegameshop.service;

import java.util.List;

import edu.jhu.project.thegameshop.exception.AddressNotFound;
import edu.jhu.project.thegameshop.model.Address;

public interface AddressService {
	public Address create(Address address);
	public Address delete(int addressId) throws AddressNotFound;
	public List<Address> findAll();
	public Address update(Address address) throws AddressNotFound;
	public Address findById(int addressId);
}
