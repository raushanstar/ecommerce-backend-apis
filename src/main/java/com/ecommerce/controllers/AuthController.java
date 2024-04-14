package com.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.exceptions.UserAlreadyExistsException;
import com.ecommerce.model.LocalUser;
import com.ecommerce.payloads.RegistrationBody;
import com.ecommerce.services.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody RegistrationBody registrationBody) {
		try {
			LocalUser registerUser = userService.registerUser(registrationBody);
			return new ResponseEntity<>("User Successful registered", HttpStatus.CREATED);
		} catch (UserAlreadyExistsException ex) {
			return new ResponseEntity<>("User Already registered", HttpStatus.CONFLICT);
		}
	}
}
