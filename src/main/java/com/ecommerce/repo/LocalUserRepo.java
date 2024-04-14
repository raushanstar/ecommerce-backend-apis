package com.ecommerce.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.model.LocalUser;

public interface LocalUserRepo extends JpaRepository<LocalUser, Long> {

	Optional<LocalUser> findByUsernameIgnoreCase(String username);

	Optional<LocalUser> findByEmailIgnoreCase(String email);
}
