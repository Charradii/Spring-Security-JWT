package com.melek.users_microservice.repos;

import com.melek.users_microservice.entities.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long>{
    Role findByRole(String role);
}