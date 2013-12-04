package edu.jhu.project.thegameshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jhu.project.thegameshop.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	
}
