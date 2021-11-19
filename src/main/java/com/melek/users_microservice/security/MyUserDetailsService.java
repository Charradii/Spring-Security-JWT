package com.melek.users_microservice.security;

import java.util.ArrayList;
import java.util.List;

import com.melek.users_microservice.entities.user;
import com.melek.users_microservice.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        user user = userService.findByUsername(username);
        if(user==null)
            throw new UsernameNotFoundException("Username not found.");
        List<GrantedAuthority> auths = new ArrayList<>();

        user.getRoles().forEach(role -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(role.getRole());
            auths.add(authority);
        });
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),auths);
    }
}