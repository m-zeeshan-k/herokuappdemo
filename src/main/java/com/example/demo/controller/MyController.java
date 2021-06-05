package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;

@Controller
public class MyController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping(value = "/")
	public String loadHome() {
	return "home";	
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute User user,Model m) {
		
		User user2 = userRepository.save(user);
		
		m.addAttribute("user",user2);
	return "success";	
	}
	
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String get(Model m) {
		
		List<User> users = userRepository.findAll();
		System.out.println(users);
		m.addAttribute("users",users);
	return "showUser";	
	}
	
	
}
