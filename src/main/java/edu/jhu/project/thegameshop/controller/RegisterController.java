package edu.jhu.project.thegameshop.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.jhu.project.thegameshop.model.Role;
import edu.jhu.project.thegameshop.model.User;
import edu.jhu.project.thegameshop.repository.UserRepository;
import edu.jhu.project.thegameshop.service.RoleService;
import edu.jhu.project.thegameshop.service.UserService;
import edu.jhu.project.thegameshop.util.MD5HashingUtil;


@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
		
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String getRegistrationPage(Model m, HttpSession session) {
		
		String userName = (String) session.getAttribute("username");
		if(userName != null) {
			m.addAttribute("isLoggedIn", true);
		} else {
			m.addAttribute("isLoggedIn", false);
		}
		
		m.addAttribute("user", new User());
		return "registration/register";
	}
	
	@RequestMapping(value="/createUser", method = RequestMethod.POST)
	public String createUser(@Valid User user,
			BindingResult result,
			Model m) throws Exception {
		
		if (result.hasErrors())
			return "registration/register";
		
		String message = "New User "+ user.getUsername()+" was successfully created.";
		user.setEnabled(1);
		//hashing password with md5
		String hashed = MD5HashingUtil.passwordMD5(user.getPassword());
		user.setPassword(hashed);
		
		//assign role
		Role role = new Role(user, "ROLE_USER");
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		user.setRoles(roles);
		
		userService.create(user);
		
		roleService.create(role);
		
		m.addAttribute("message", message);
		return "login/login";
	}
	
	@RequestMapping(value="/cancelMemberShip", method = RequestMethod.GET)
	public String getCancelationPage(Model m, HttpSession session) {
		
		m.addAttribute("user", new User());
		m.addAttribute("message", "We need to verify the user credential again");
		return "registration/cancel";
	}
	
	@RequestMapping(value="/membershipCancellation", method = RequestMethod.POST)
	public String cancelMembership(User user, Model m) throws Exception {
		User u = userService.findById(user.getUsername());
		String hashed = MD5HashingUtil.passwordMD5(user.getPassword());
		
		if(u == null || !hashed.equals(u.getPassword())) {
			m.addAttribute("message", "Invalid username or password.");
			return "registration/cancel";
		}
		
		u.setEnabled(0);
		
		userService.update(u);
		
		m.addAttribute("message", "Successfully Canceled the Membership");
		
		return "login/login";
	}
	
}
