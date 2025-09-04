package com.AppRH.AppRH;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebConfig {

    /**
     * Este Bean substitui o antigo método "configureGlobal".
     * Ele cria usuários em memória para autenticação.
     * * @return um gerenciador de detalhes de usuário com os usuários pré-configurados.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        // Cria o usuário "arthur"
        UserDetails user = User.withUsername("arthur")
                .password("{noop}arthur") // {noop} indica que a senha não está criptografada
                .roles("USER")
                .build();

        // Cria o usuário "root"
        UserDetails admin = User.withUsername("root")
                .password("{noop}root")
                .roles("ADMIN")
                .build();

        // Retorna um gerenciador que mantém os usuários em memória
        return new InMemoryUserDetailsManager(user, admin);
    }

    /**
     * Este Bean substitui o antigo método "configure(HttpSecurity http)".
     * Ele define a cadeia de filtros de segurança, configurando as permissões de acesso HTTP.
     * * @param http o objeto HttpSecurity a ser configurado.
     * @return a cadeia de filtros de segurança construída.
     * @throws Exception se ocorrer um erro durante a configuração.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Permite acesso público aos seguintes caminhos (substitui antMatchers)
                        .requestMatchers("/vagas**", "/home**", "/*.css", "/*.js").permitAll()
                        // Exige autenticação para qualquer outra requisição
                        .anyRequest().authenticated()
                )
                // Configura o formulário de login padrão, permitindo acesso a todos
                .formLogin(form -> form.permitAll())
                // Configura o logout, permitindo acesso a todos
                .logout(logout -> logout.permitAll())
                // Desabilita a proteção CSRF (Cross-Site Request Forgery)
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}