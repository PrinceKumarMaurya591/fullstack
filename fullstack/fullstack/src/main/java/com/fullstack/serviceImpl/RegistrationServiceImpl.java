package com.fullstack.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fullstack.entity.Registration;
import com.fullstack.repository.RegistrationRepository;
import com.fullstack.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    
   
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    
    @Override
    public Registration register(Registration registration) {
        // Add validation logic if needed
    	registration.setPassword(passwordEncoder.encode(registration.getPassword()));
        return registrationRepository.save(registration);
    }
}