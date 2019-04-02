package com.yash.pbapp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yash.pbapp.command.LoginCommand;
import com.yash.pbapp.exception.BlockedUserException;
import com.yash.pbapp.exception.UserNotFoundException;
import com.yash.pbapp.model.User;
import com.yash.pbapp.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/index" })
	public String index(ModelMap model) {
		LoginCommand command = new LoginCommand();
		model.addAttribute("command", command);
		return "index";
	}

	@RequestMapping(value = { "/registration" })
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
	public String authenticate(@ModelAttribute("command") LoginCommand command, RedirectAttributes redir,HttpSession session) {
		User loggedInUser = null;
		try {
			loggedInUser = userService.authenticate(command.getLoginname(), command.getPassword());
			if (loggedInUser == null) {
				redir.addFlashAttribute("errmsg", "Invalid credential, Check your loginname or password");
				return "redirect:/index";
			} else {
				return redirectAccordingToRole(redir, session, loggedInUser);		
			}			
		} catch (BlockedUserException e) {
			redir.addFlashAttribute("errmsg", e.getMessage());
			return "redirect:/index";
		}
	}

	private String redirectAccordingToRole(RedirectAttributes redir, HttpSession session, User loggedInUser) {
		if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
			setSession(loggedInUser,session);
			return "redirect:/user/dashboard";
		} else if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
			setSession(loggedInUser,session);
			return "redirect:./admin/dashboard";
		} else {
			redir.addFlashAttribute("errmsg", "Invalid Role");
			return "redirect:/index";
		}
	}

	private void setSession(User loggedInUser, HttpSession session) {
		session.setAttribute("user", loggedInUser);
		session.setAttribute("userRole", loggedInUser.getRole());
		session.setAttribute("userId", loggedInUser.getId());	
	}
	
	@RequestMapping("/logout")
	public String logout(RedirectAttributes redir,HttpSession session) {
		session.invalidate();
		redir.addFlashAttribute("errmsg", "You are Logged Out");
		return "redirect:/index";
	}
	
	@RequestMapping("/registrationProcess")
	public String registrationProcess(@Valid @ModelAttribute("user") User user,BindingResult result,RedirectAttributes redir) {
		
		if(result.hasErrors()) {
			return "registration";
		}
		userService.register(user);
		redir.addFlashAttribute("errmsg", "Now You can Login Now");
		return "redirect:/index";
	}
	
	@RequestMapping("/admin/listUser")
	public String listUser(Model model) {
		List<User> users = userService.findAll();
		model.addAttribute("users",users);
		return "listUser";
	}
	

	@RequestMapping("/admin/delete")
	public String delete(@RequestParam("id") Integer id) {
		System.out.println(id);
		userService.delete(id);
		return "redirect:./dashboard";
	}
	
	@RequestMapping("/admin/deleteSelected")
	public String deleteSelected(@RequestParam(required=false,name="id") String[] ids) {
		System.out.println(ids.length);
		for(int i=0;i<ids.length;i++) {
			userService.delete(Integer.parseInt(ids[i]));
		}
		return "redirect:./dashboard";	
	}
	
}
