package edu.jhu.project.thegameshop.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.jhu.project.thegameshop.exception.UserNotFound;
import edu.jhu.project.thegameshop.model.User;
import edu.jhu.project.thegameshop.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserRepository userRepository;
	
	@Transactional
	public User create(User user) {
		User createdUser = user;
		return userRepository.save(createdUser);
	}
	
	@Transactional(rollbackFor=UserNotFound.class)
	public User delete(String email) throws UserNotFound {
		User deletedUser = userRepository.findOne(email);
		
		if(deletedUser == null)
			throw new UserNotFound();
			
		userRepository.delete(deletedUser);
		return deletedUser;
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	
	@Transactional(rollbackFor=UserNotFound.class)
	public User update(User user) throws UserNotFound {
		User updatedUser = userRepository.findOne(user.getUsername());
		
		if(updatedUser == null)
			throw new UserNotFound();
			
		updatedUser.setAddress1(user.getAddress1());
		updatedUser.setAddress2(user.getAddress2());
		updatedUser.setRoles(user.getRoles());
		updatedUser.setCreditCardId(user.getCreditCardId());
		updatedUser.setEnabled(user.getEnabled());
		updatedUser.setPassword(user.getPassword());
		
		userRepository.save(updatedUser);
		return updatedUser;
	}

	public User findById(String username) {
		return userRepository.findOne(username);
	}

}
