package com.fullstack.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "revoked_tokens")
public class RevokedToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = false)
    private LocalDateTime revokedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getRevokedAt() {
		return revokedAt;
	}

	public void setRevokedAt(LocalDateTime revokedAt) {
		this.revokedAt = revokedAt;
	}

	@Override
	public String toString() {
		return "RevokedToken [id=" + id + ", token=" + token + ", revokedAt=" + revokedAt + "]";
	}

	public RevokedToken(Long id, String token, LocalDateTime revokedAt) {
		super();
		this.id = id;
		this.token = token;
		this.revokedAt = revokedAt;
	}

	public RevokedToken() {
		super();
		// TODO Auto-generated constructor stub
	}

    // Constructors, getters, and setters
    
    
    
    
}
