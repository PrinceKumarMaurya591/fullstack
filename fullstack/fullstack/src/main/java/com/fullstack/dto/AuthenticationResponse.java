package com.fullstack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class AuthenticationResponse {
    private String token;
    private String userName;

    public AuthenticationResponse() {
        // Default constructor
    }

    public static AuthenticationResponseBuilder builder() {
        return new AuthenticationResponseBuilder();
    }

    public String getToken() {
        return token;
    }

    public String getUserName() {
        return userName;
    }

    public static class AuthenticationResponseBuilder {
        private String token;
        private String userName;

        public AuthenticationResponseBuilder token(String token) {
            this.token = token;
            return this;
        }

        public AuthenticationResponseBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public AuthenticationResponse build() {
            AuthenticationResponse response = new AuthenticationResponse();
            response.token = this.token;
            response.userName = this.userName;
            return response;
        }
    }
    
    // Other getters, setters, and methods as needed
}
