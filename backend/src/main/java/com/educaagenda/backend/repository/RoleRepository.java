package com.educaagenda.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.educaagenda.backend.enums.RoleNames;
import com.educaagenda.backend.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

    Optional<Role> findByRole(RoleNames roleOrganizador);
    
}
