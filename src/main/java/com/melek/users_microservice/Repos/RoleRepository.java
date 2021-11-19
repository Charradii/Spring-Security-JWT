package com.melek.users_microservice.Repos;

import com.melek.users_microservice.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByRole(String Role);
    
}