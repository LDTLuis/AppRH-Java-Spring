package com.AppRH.AppRH.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.List;

@Entity
public class Role implements GrantedAuthority, Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String nomeRole;

    @ManyToMany(mappedBy = "roles")
    private List<Usuario> usuarios;

    // Getter e Setter
    public String getNomeRole() { return nomeRole; }
    public void setNomeRole(String nomeRole) { this.nomeRole = nomeRole; }

    @Override
    public String getAuthority() {
        return this.nomeRole;
    }
}