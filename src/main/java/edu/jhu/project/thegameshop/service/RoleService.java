package edu.jhu.project.thegameshop.service;

import java.util.List;

import edu.jhu.project.thegameshop.exception.RoleNotFound;
import edu.jhu.project.thegameshop.model.Role;

public interface RoleService {
	public Role create(Role role);
	public Role delete(int id) throws RoleNotFound;
	public List<Role> findAll();
	public Role update(Role role) throws RoleNotFound;
	public Role findById(int id);
	public Role findByUserName(String username);
}
