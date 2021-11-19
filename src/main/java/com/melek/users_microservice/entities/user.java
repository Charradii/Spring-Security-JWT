package com.melek.users_microservice.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class user {
   @Id
   @GeneratedValue (strategy=GenerationType.IDENTITY)
   private Long userId;
   @Column(unique=true)
   private String username;
   private String password;
   private Boolean enabled;
   @ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
   @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
   private List<Role> roles;
}