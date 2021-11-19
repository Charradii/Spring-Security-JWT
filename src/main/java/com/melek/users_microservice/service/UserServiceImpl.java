package com.melek.users_microservice.service;

import com.melek.users_microservice.Repos.RoleRepository;
import com.melek.users_microservice.Repos.UserRepository;
import com.melek.users_microservice.entities.Role;
import com.melek.users_microservice.entities.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor 
@Transactional
@Service
public class UserServiceImpl implements UserService{

    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRep;

    @Autowired
    RoleRepository roleRep;

    @Override
    public user saveUser(user user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRep.save(user);
    }

    @Override
    public user findByUsername(String username) {
        return userRep.findByUsername(username);
    }

    @Override
    public Role addRole(Role role) {
        return roleRep.save(role);
    }

    @Override
    public user addRoleToUser(String username, String rolename) {
        user usr = userRep.findByUsername(username);
        Role role = roleRep.findByRole(rolename);
        usr.getRoles().add(role);
        //userRepository.save(usr)
        return usr;
    }
}