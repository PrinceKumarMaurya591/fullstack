package com.fullstack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "http://localhost:3000/dashboard")
@RestController
@RequestMapping("/auth")
public class HealthcheckController {

	@GetMapping("/health") 
	    public ResponseEntity<String> checkHealth() {
	    	System.out.println("request came for healthcheck---------");
	        return ResponseEntity.ok("Service is up and running");
	    }
	
}