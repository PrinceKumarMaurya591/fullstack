package com.fullstack.serviceImpl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstack.entity.RevokedToken;
import com.fullstack.repository.RevokedTokenRepository;
import com.fullstack.service.TokenRevocationService;

@Service
public class TokenRevocationServiceImpl implements TokenRevocationService {

	
	  @Autowired
	    private RevokedTokenRepository revokedTokenRepository;

	    @Override
	    public void revokeToken(String token) {
	        // Remove the "Bearer " prefix if it exists
	        if (token.startsWith("Bearer ")) {
	            token = token.substring(7);
	        }

	        RevokedToken revokedToken = new RevokedToken();
	        revokedToken.setToken(token);
	        revokedToken.setRevokedAt(LocalDateTime.now());
	        revokedTokenRepository.save(revokedToken);
	    }

	    @Override
	    public boolean isTokenRevoked(String token) {
	        // Remove the "Bearer " prefix if it exists
	        if (token.startsWith("Bearer ")) {
	            token = token.substring(7);
	        }

	        return revokedTokenRepository.existsByToken(token);
	    }
	
	
	
        
}


