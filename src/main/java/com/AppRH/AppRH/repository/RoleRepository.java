package com.AppRH.AppRH.repository;

import com.AppRH.AppRH.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
    Role findByNomeRole(String nomeRole);
}