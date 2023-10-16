//package com.fullstack.security;
//
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.fullstack.entity.Registration;
//import com.fullstack.repository.RegistrationRepository;
//
//
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//	private final RegistrationRepository registrationRepository;
//
//	public CustomUserDetailsService(RegistrationRepository registrationRepository) {
//		this.registrationRepository = registrationRepository;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return registrationRepository.findByEmail(username)
//				.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
//	}
//	
//	
//	
//}