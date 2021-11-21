package com.melek.users_microservice;




import javax.annotation.PostConstruct;

import com.melek.users_microservice.entities.Role;
import com.melek.users_microservice.entities.User;
import com.melek.users_microservice.service.UserService;
import com.melek.users_microservice.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class UsersMicroserviceApplication {

	@Autowired
	UserService userService;
	@PostConstruct
	void init_users(){
		
	}
	@Bean
	BCryptPasswordEncoder getBCE(){
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}
}
