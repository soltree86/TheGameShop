package edu.jhu.project.thegameshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.jhu.project.thegameshop.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	@Query("SELECT r FROM Role r WHERE r.user.username = :username")
	public Role findByUserName(@Param("username") String username);
}
