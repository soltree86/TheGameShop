package edu.jhu.project.thegameshop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.jhu.project.thegameshop.exception.AddressNotFound;
import edu.jhu.project.thegameshop.model.Address;
import edu.jhu.project.thegameshop.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Resource
	private AddressRepository addressRepository;
	
	public Address create(Address address) {
		return addressRepository.save(address);
	}

	public Address delete(int addressId) throws AddressNotFound {
		Address deleted = addressRepository.findOne(addressId);
		
		if(deleted == null)
			throw new AddressNotFound();
		
		addressRepository.delete(deleted);
		return deleted;
	}

	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	public Address update(Address address) throws AddressNotFound {
		Address updated = addressRepository.findOne(address.getAddressId());
		
		if(updated == null)
			throw new AddressNotFound();
		
		updated.setCity(address.getCity());
		updated.setOrders(address.getOrders());
		updated.setState(address.getState());
		updated.setStreet1(address.getStreet1());
		updated.setStreet2(address.getStreet2());
		updated.setZip(address.getZip());
		updated.setUsers1(address.getUsers1());
		updated.setUsers2(address.getUsers2());
		
		addressRepository.save(updated);
		
		return updated;
	}

	public Address findById(int addressId) {
		return addressRepository.findOne(addressId);
	}

}
