package com.yash.pbapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yash.pbapp.model.User;
import com.yash.pbapp.service.UserService;

@Controller
public class PageController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value= {"/user/dashboard"})
	public String userDashboard(Model model) {
		
		return "User-Dashboard";
	}
	
	@RequestMapping(value= {"/admin/dashboard"})
	public String adminDashboard(Model model) {
		List<User> fetchedusers = userService.findAll();
		model.addAttribute("fetchedUsers", fetchedusers);
		return "Admin-Dashboard";
	}

}
