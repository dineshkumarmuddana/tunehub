package com.tunehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.entities.Users;
import com.tunehub.services.UsersService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersController {
	@Autowired
	UsersService service;

	@PostMapping("/register")
	public String addusers(@ModelAttribute Users user) {
		boolean userStatus = service.emailExists(user.getEmail());
		if (userStatus == false) {
			System.out.println("User is added");
			service.addUser(user);
		} else {
			System.out.println("User is already exist");
		}
		return "home";

	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {

		if (service.validateUser(email, password) == true) {
			session.setAttribute(email, email);
			String role = service.getRole(email);
			if (role.equals("Admin")) {
				return "admin_home";
			} else {
				return "customer_home";
			}
		} else {
			return "login";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

}
