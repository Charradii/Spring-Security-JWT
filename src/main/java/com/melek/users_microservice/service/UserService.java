package com.melek.users_microservice.service;

import java.util.List;

import com.melek.users_microservice.entities.Role;
import com.melek.users_microservice.entities.User;



public interface UserService {
    User saveUser(User user);
    User findUserByUsername(String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
    List<User> findAllUsers();
}