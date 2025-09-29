// Caminho: src/main/java/com/AppRH/AppRH/service/DataInitializer.java

package com.AppRH.AppRH.service;

import com.AppRH.AppRH.models.Role;
import com.AppRH.AppRH.models.Usuario;
import com.AppRH.AppRH.repository.RoleRepository;
import com.AppRH.AppRH.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if (roleRepository.findByNomeRole("ROLE_ADMIN") == null) {
            Role adminRole = new Role();
            adminRole.setNomeRole("ROLE_ADMIN");
            roleRepository.save(adminRole);
        }
        if (roleRepository.findByNomeRole("ROLE_USER") == null) {
            Role userRole = new Role();
            userRole.setNomeRole("ROLE_USER");
            roleRepository.save(userRole);
        }

        if (usuarioRepository.findByLogin("admin") == null) {
            Role adminRole = roleRepository.findByNomeRole("ROLE_ADMIN");
            Role userRole = roleRepository.findByNomeRole("ROLE_USER");

            Usuario admin = new Usuario();
            admin.setLogin("admin");
            admin.setSenha(passwordEncoder.encode("admin123"));
            admin.setRoles(Arrays.asList(adminRole, userRole));
            usuarioRepository.save(admin);
        }
    }

}