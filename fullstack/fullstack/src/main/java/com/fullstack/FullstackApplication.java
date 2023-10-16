package com.fullstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FullstackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullstackApplication.class, args);
	}

//	@Bean
//    public WebMvcConfigurer corsFilter() {
//	 return new WebMvcConfigurer() {
//	@Override
//	public void addCorsMappings(CorsRegistry reg) {
//		reg.addMapping("/**").allowedOrigins("*");
//	}
//	 };
// }
	
	
	
	@Bean
	public WebMvcConfigurer corsFilter() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**").allowedOrigins("http://localhost:3000");
//	                    .allowedOrigins("http://localhost:3000") // Update with your frontend's origin
//	                    .allowedMethods("GET", "POST", "PUT", "DELETE")

	        }
	    };
	}

	
}
