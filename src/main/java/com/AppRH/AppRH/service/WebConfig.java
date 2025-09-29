// Caminho: src/main/java/com/AppRH/AppRH/WebConfig.java

package com.AppRH.AppRH.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Permissões Públicas
                        .requestMatchers("/login", "/cadastrar-usuario", "/bootstrap/**", "/*.css", "/*.js").permitAll()
                        .requestMatchers("/vagas").permitAll() // Lista de vagas é pública

                        // Permissões de ADMIN
                        .requestMatchers("/cadastrarVaga", "/deletarVaga", "/editarVaga/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/{id}").hasRole("ADMIN")
                        .requestMatchers("/funcionarios/**", "/cadastrarFuncionario", "/deletarFuncionario", "/editar-funcionario/**").hasRole("ADMIN")
                        .requestMatchers("/dependentes/**", "/deletarDependente").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/dependentes/**").hasRole("ADMIN")

                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());
        // A LINHA CSRF FOI REMOVIDA DAQUI

        return http.build();
    }
}