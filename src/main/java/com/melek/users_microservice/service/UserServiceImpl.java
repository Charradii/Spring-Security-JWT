package com.melek.users_microservice.service;

import java.util.List;

import javax.transaction.Transactional;

import com.melek.users_microservice.entities.Role;
import com.melek.users_microservice.entities.User;
import com.melek.users_microservice.repos.RoleRepository;
import com.melek.users_microservice.repos.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role addRole(Role role) {
        
        return roleRepository.save(role);
    }

    @Override
    public User addRoleToUser(String username, String rolename) {
        User u = userRepository.findByUsername(username);
        u.getRoles().add(roleRepository.findByRole(rolename));
        return u;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    
    
}