package com.melek.users_microservice;

import javax.annotation.PostConstruct;

import com.melek.users_microservice.entities.Role;
import com.melek.users_microservice.entities.user;
import com.melek.users_microservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(scanBasePackages={"com.melek.users_microservice.Repos", "com.melek.users_microservice.service"})
public class UsersMicroserviceApplication {

	@Autowired
	UserService userService;
	
	/*@PostConstruct
	void init_users(){
		userService.addRole(new Role(null,"ADMIN"));
		userService.addRole(new Role(null,"USER"));
		
		userService.saveUser(new user(null,"admin","123",true,null));
		userService.saveUser(new user(null,"melek","123",true,null));
		userService.saveUser(new user(null,"samir","123",true,null));
		
		userService.addRoleToUser("admin","ADMIN");
		userService.addRoleToUser("admin","USER");
		userService.addRoleToUser("melek","USER");
		userService.addRoleToUser("yassine","USER");
	}*/
	@Bean
	BCryptPasswordEncoder getBCE(){
		return new BCryptPasswordEncoder();
	}
	public static void main(String[] args) {
		SpringApplication.run(UsersMicroserviceApplication.class, args);
	}
}
