package edu.jhu.project.thegameshop.service;

import java.util.List;

import edu.jhu.project.thegameshop.exception.UserNotFound;
import edu.jhu.project.thegameshop.model.User;

public interface UserService {
	public User create(User user);
	public User delete(String email) throws UserNotFound;
	public List<User> findAll();
	public User update(User user) throws UserNotFound;
	public User findById(String username);
}
