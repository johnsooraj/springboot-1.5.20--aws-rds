package com.turing.amt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turing.amt.user.entity.UserEntity;
import com.turing.amt.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/sameImage")
	public void saveImgae() {
		
	}

	@GetMapping("/{username}")
	public UserEntity getUserByUsername(@PathVariable String username) {
		return userService.findUserByUsername(username);
	}

}
