package com.AppRH.AppRH.service;

import com.AppRH.AppRH.repository.RoleRepository;
import com.AppRH.AppRH.repository.UsuarioRepository;
import com.AppRH.AppRH.models.Role;
import com.AppRH.AppRH.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Cria a ROLE_ADMIN se não existir
        if (roleRepository.findByNomeRole("ROLE_ADMIN") == null) {
            Role adminRole = new Role();
            adminRole.setNomeRole("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }

        // Cria a ROLE_USER se não existir
        if (roleRepository.findByNomeRole("ROLE_USER") == null) {
            Role userRole = new Role();
            userRole.setNomeRole("ROLE_USER");
            roleRepository.save(userRole);
        }

        // Cria um usuário ADMIN padrão se não existir
        if (usuarioRepository.findByLogin("admin") == null) {
            Usuario admin = new Usuario();
            admin.setLogin("admin");
            admin.setSenha(passwordEncoder.encode("admin")); // Defina uma senha forte em produção!
            admin.setRoles(Arrays.asList(roleRepository.findByNomeRole("ROLE_ADMIN")));
            usuarioRepository.save(admin);
        }
    }
}