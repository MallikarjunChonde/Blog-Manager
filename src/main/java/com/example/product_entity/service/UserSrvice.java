package com.example.product_entity.service;

import org.springframework.http.ResponseEntity;

import com.example.product_entity.model.User;
import com.example.product_entity.utility.ResponseStructure;

public interface UserSrvice {

	ResponseEntity<ResponseStructure<User>> saveUser(User user);

}
