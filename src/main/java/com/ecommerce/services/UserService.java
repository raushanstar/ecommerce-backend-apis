package com.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.exceptions.UserAlreadyExistsException;
import com.ecommerce.model.LocalUser;
import com.ecommerce.payloads.RegistrationBody;
import com.ecommerce.repo.LocalUserRepo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserService {

	@Autowired
	private LocalUserRepo localUserRepo;

	public LocalUser registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
		if (localUserRepo.findByEmailIgnoreCase(registrationBody.getEmail()).isPresent()
				|| localUserRepo.findByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()) {
			throw new UserAlreadyExistsException();
		}
		LocalUser user = new LocalUser();
		user.setEmail(registrationBody.getEmail());
		user.setUsername(registrationBody.getUsername());
		user.setFirstName(registrationBody.getFirstName());
		user.setLastName(registrationBody.getLastName());

		user.setPassword(registrationBody.getPassword());
		return localUserRepo.save(user);
	}
}
