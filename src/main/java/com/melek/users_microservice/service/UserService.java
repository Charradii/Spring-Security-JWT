package com.melek.users_microservice.service;

import com.melek.users_microservice.entities.Role;
import com.melek.users_microservice.entities.User;



public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
}