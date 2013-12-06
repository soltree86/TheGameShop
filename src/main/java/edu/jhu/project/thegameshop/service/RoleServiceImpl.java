package edu.jhu.project.thegameshop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.jhu.project.thegameshop.exception.RoleNotFound;
import edu.jhu.project.thegameshop.exception.UserNotFound;
import edu.jhu.project.thegameshop.model.Role;
import edu.jhu.project.thegameshop.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Resource
	private RoleRepository roleRepository;
	
	@Transactional
	public Role create(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Transactional(rollbackFor=RoleNotFound.class)
	public Role delete(int id) throws RoleNotFound {
		// TODO Auto-generated method stub
		Role deleted = roleRepository.findOne(id);
		if(deleted == null) 
			throw new RoleNotFound();
		
		roleRepository.delete(deleted);
		
		return deleted;
	}

	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}
	
	@Transactional(rollbackFor=RoleNotFound.class)
	public Role update(Role role) throws RoleNotFound {
		// TODO Auto-generated method stub
		Role updated = roleRepository.findOne(role.getRoleId());
		
		if(updated == null)
			throw new RoleNotFound();
		
		updated.setAuthority(role.getAuthority());
		updated.setUser(role.getUser());
		
		return roleRepository.save(updated);
	}

	public Role findById(int id) {
		// TODO Auto-generated method stub
		return roleRepository.findOne(id);
	}

	public Role findByUserName(String username) {
		// TODO Auto-generated method stub
		return roleRepository.findByUserName(username);
	}

}
