package com.melek.users_microservice.service;

import com.melek.users_microservice.entities.Role;
import com.melek.users_microservice.entities.user;

public interface UserService {
    user saveUser(user user);
    user findByUsername (String username);
    Role addRole(Role role);
    user addRoleToUser(String username, String rolename);
}