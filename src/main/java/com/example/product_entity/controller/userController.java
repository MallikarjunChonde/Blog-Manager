package com.example.product_entity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_entity.model.User;
import com.example.product_entity.service.UserSrvice;
import com.example.product_entity.utility.ResponseStructure;

import jakarta.validation.Valid;
@RestController
public class userController {
	@Autowired
	private UserSrvice userService;
	@PostMapping("/users")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody @Valid User user){
		return userService.saveUser(user);
	}

}
