package com.example.product_entity.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.product_entity.model.User;
import com.example.product_entity.repository.UserPRepository;
import com.example.product_entity.service.UserSrvice;
import com.example.product_entity.utility.ResponseStructure;
@Service
public class UserImpl implements UserSrvice{
	private UserPRepository userRepository;

	private ResponseStructure<User> responceStructre;
	
	
	public UserImpl(UserPRepository userRepository, ResponseStructure<User> responceStructre) {
		
		this.userRepository = userRepository;
		this.responceStructre = responceStructre;
	}


	@Override
	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User uniqUser = userRepository.save(user);
		
		return ResponseEntity.ok(responceStructre.setStatuscode(HttpStatus.OK.value())
				.setData(uniqUser)
				.setMessage("saved data"));
	}

}
