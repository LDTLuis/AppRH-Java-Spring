package com.AppRH.AppRH.controllers;

import com.AppRH.AppRH.repository.DependenteRepository;
import com.AppRH.AppRH.repository.FuncionarioRepository;
import com.AppRH.AppRH.models.Dependente;
import com.AppRH.AppRH.models.Funcionario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private DependenteRepository dependenteRepository;


    // Cadastrar Funcionario
    @RequestMapping(value="/cadastrarFuncionario", method = RequestMethod.GET)
    public String form() {
        return "funcionario/formFuncionario";
    }

    @RequestMapping(value = "/cadastrarFuncionario", method = RequestMethod.POST)
    public String form(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes) {

        if(result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/cadastrarFuncionario";
        }

        funcionarioRepository.save(funcionario);
        attributes.addFlashAttribute("mensagem", "Funcionário cadastrado com sucesso!");
        return "redirect:/cadastrarFuncionario";
    }

    // Listar Funcionario
    @RequestMapping("/funcionarios")
    public ModelAndView listaFuncionario() {
        ModelAndView modelAndView = new ModelAndView("funcionario/listaFuncionario");

        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
        modelAndView.addObject("funcionarios", funcionarios);
        return modelAndView;
    }

    // Listar Dependentes
    @RequestMapping(value = "/dependentes/{id}", method = RequestMethod.GET)
    public ModelAndView dependentes(@PathVariable("id") long id) {

        Funcionario funcionario = funcionarioRepository.findById(id);
        ModelAndView modelAndView = new ModelAndView("funcionario/dependentes");

        modelAndView.addObject("funcionarios", funcionario);

        // Lista baseada por funcionário
        Iterable<Dependente> dependentes = dependenteRepository.findByFuncionario(funcionario);
        modelAndView.addObject("dependentes", dependentes);

        return modelAndView;
    }

    // Adicionar Dependentes
    @RequestMapping(value="/dependentes/{id}", method = RequestMethod.POST)
    public String dependentesPost(@PathVariable("id") long id, Dependente dependentes, BindingResult result,
                                  RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/dependentes/{id}";
        }

        if (dependenteRepository.findByCpfDependente(dependentes.getCpfDependente()) != null) {
            attributes.addFlashAttribute("mensagem_erro", "CPF duplicado");
            return "redirect:/dependentes/{id}";
        }

        Funcionario funcionario = funcionarioRepository.findById(id);
        dependentes.setFuncionario(funcionario);
        dependenteRepository.save(dependentes);
        attributes.addFlashAttribute("mensagem", "Dependente adicionado com sucesso");
        return "redirect:/dependentes/{id}";
    }

        // Deletar Funcionário
    @RequestMapping("deletarFuncionario")
    public String deletarFuncionario(long id) {

        Funcionario funcionario = funcionarioRepository.findById(id);
        funcionarioRepository.delete(funcionario);

        return "redirect:/funcionarios";
    }

    // Métodos para Atualizar Funcionário
    // Formulário edição de funcionário
    @RequestMapping(value = "/editar-funcionario", method = RequestMethod.GET)
    public ModelAndView editarFuncionario(long id ) {

        Funcionario funcionario = funcionarioRepository.findById(id);
        ModelAndView modelAndView = new ModelAndView("funcionario/update-funcionario");
        modelAndView.addObject("funcionario", funcionario);

        return modelAndView;
    }

    // Update Funcionário
    @RequestMapping(value = "/editar-funcionario", method = RequestMethod.POST)
    public String updateFuncionario(@Valid Funcionario funcionario, BindingResult result, RedirectAttributes attributes) {

        funcionarioRepository.save(funcionario);
        attributes.addFlashAttribute("success", "Funcionário alterado com sucesso!");

        long idLong = funcionario.getId();
        String id = "" + idLong;

        return "redirect:/dependentes/" + id;
    }

    // Deletar Dependente
    @RequestMapping("/deletarDependente")
    public String deletarDependente(String cpf) {

        Dependente dependente = dependenteRepository.findByCpfDependente(cpf);

        Funcionario funcionario = dependente.getFuncionario();
        String codigo = "" + funcionario.getId();

        dependenteRepository.delete(dependente);

        return "redirect:/dependentes/" + codigo;
    }

}
