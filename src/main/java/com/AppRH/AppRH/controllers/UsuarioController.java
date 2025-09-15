package com.AppRH.AppRH.controllers;

import com.AppRH.AppRH.repository.RoleRepository; // IMPORTAR
import com.AppRH.AppRH.repository.UsuarioRepository;
import com.AppRH.AppRH.models.Role; // IMPORTAR
import com.AppRH.AppRH.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays; // IMPORTAR

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RoleRepository roleRepository; // ADICIONAR

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/cadastrar-usuario")
    public String formCadastro() {
        return "usuario/formUsuario";
    }

    @PostMapping("/cadastrar-usuario")
    public String cadastrarUsuario(Usuario usuario, RedirectAttributes attributes) {

        if (usuarioRepository.findByLogin(usuario.getLogin()) != null) {
            attributes.addFlashAttribute("mensagem_erro", "Erro: Usuário já cadastrado!");
            return "redirect:/cadastrar-usuario";
        }

        // Criptografa a senha
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        // Atribui a permissão padrão de USER
        Role roleUser = roleRepository.findByNomeRole("ROLE_USER");
        usuario.setRoles(Arrays.asList(roleUser)); // ADICIONAR

        usuarioRepository.save(usuario);

        attributes.addFlashAttribute("mensagem_sucesso", "Usuário cadastrado com sucesso!");
        return "redirect:/login";
    }
}