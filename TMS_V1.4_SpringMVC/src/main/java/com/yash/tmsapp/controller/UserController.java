package com.yash.tmsapp.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yash.tmsapp.domain.User;
import com.yash.tmsapp.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	private static int count=2;

	@RequestMapping(value = "/UserAuthentication.ds")
	public String authentication() {
		User user = new User();
		user.setId(1);
		user.setName("Savinay Sinha");
		user.setLoginName("savinaysinha");
		user.setPassword("savinay123");
		user.setEmail("savinaysinha@yahoo.com");
		user.setPhone("9914360114");
		user.setRole(2);
		user.setStatus(1);
		userService.register(user );
		return "UserAuthentication";
	}
	
	@RequestMapping(value="/UserRegistration.ds")
	public String userRegistration() {
		return "UserRegistration";
		
	}

	@RequestMapping(value = "/signIn.ds", method=RequestMethod.POST)
	public String userLogin(@RequestParam String loginName, @RequestParam String password, HttpSession session,
			Model model) {
		
		User loggedInUser = userService.authenticate(loginName, password);
		session.setAttribute("loggedInUser", loggedInUser);
		session.setAttribute("loggedInUserId", loggedInUser.getId());
		session.setAttribute("loggedInUseRole", loggedInUser.getRole());
		return "redirect:/UserDashboard.ds";
	}

	@RequestMapping(value = "/addUser.ds", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user,Model model) {
		
		user.setRole(UserService.ROLE_BUSINESS);
		user.setStatus(UserService.STATUS_ACTIVE);
		user.setId(count++);
		userService.register(user);
		model.addAttribute("user", user);
		return "UserAuthentication";
	}
	
	@RequestMapping(value="/logout.ds",method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "UserAuthentication";
	}
	
	
}
