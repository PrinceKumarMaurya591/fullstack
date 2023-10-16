package com.fullstack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack.entity.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

Optional<Registration> findByEmail(String email);

}
