package com.melek.users_microservice.Repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.melek.users_microservice.entities.user;


public interface UserRepository extends JpaRepository<user , Long> {
    user findByUsername(String name);
    
}