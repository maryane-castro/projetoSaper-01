package com.educaagenda.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import com.educaagenda.backend.enums.RoleNames;

@Entity
public class Role implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    RoleNames role;
    /*
      ROLE_ADMIN,
      ROLE_ORGANIZADOR,
      ROLE_ACADEMICO
     */

    @Override
    public String getAuthority() {
        return role.toString();
    }
    
}
