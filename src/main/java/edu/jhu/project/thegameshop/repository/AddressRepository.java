package edu.jhu.project.thegameshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jhu.project.thegameshop.model.Address;

public interface AddressRepository  extends JpaRepository<Address, Integer>{

}
