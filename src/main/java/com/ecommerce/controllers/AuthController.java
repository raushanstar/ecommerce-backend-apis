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
import com.ecommerce.payloads.LoginBody;
import com.ecommerce.payloads.LoginResponse;
import com.ecommerce.payloads.RegistrationBody;
import com.ecommerce.security.JWTService;
import com.ecommerce.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	@Autowired
	  private JWTService jwtService;

	@PostMapping("/register")
	public ResponseEntity<String> registration(@RequestBody RegistrationBody registrationBody) {
		try {
			LocalUser registerUser = userService.registerUser(registrationBody);
			return new ResponseEntity<>("User Successful registered", HttpStatus.CREATED);
		} catch (UserAlreadyExistsException ex) {
			return new ResponseEntity<>("User Already registered", HttpStatus.CONFLICT);
		}
	}
	
	@PostMapping("/login")
	  public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody) {
	    String jwt = userService.loginUser(loginBody);
	    if (jwt == null) {
	      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    } else {
	      LoginResponse response = new LoginResponse();
	      response.setJwt(jwt);
	      return ResponseEntity.ok(response);
	    }
	  }

	

}
