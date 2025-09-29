package com.AppRH.AppRH.controllers;

import com.AppRH.AppRH.repository.CandidatoRepository;
import com.AppRH.AppRH.repository.VagaRepository;
import com.AppRH.AppRH.models.Candidato;
import com.AppRH.AppRH.models.Vaga;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class VagaController {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private CandidatoRepository candidatoRepository;

    // Cadastrar Vagas
    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.GET)
    public String form() {
        return "vaga/formVaga";
    }

    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.POST)
    public String form(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/cadastrarVaga";
        }

        vagaRepository.save(vaga);
        attributes.addFlashAttribute("mensagem", "Vaga cadastrada com sucesso!");

        return "redirect:/vagas";
    }

    // Listar Vagas
    @RequestMapping("/vagas")
    public ModelAndView listaVagas() {

        ModelAndView modelAndView = new ModelAndView("vaga/listaVaga");
        Iterable<Vaga> vagas = vagaRepository.findAll();
        modelAndView.addObject("vagas", vagas);

        return modelAndView;
    }

    @RequestMapping(value = "/vaga/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesVaga(@PathVariable("codigo") long codigo) {

        Vaga vaga = vagaRepository.findByCodigo(codigo);
        ModelAndView modelAndView = new ModelAndView("vaga/detalhesVaga");
        modelAndView.addObject("vaga", vaga);

        Iterable<Candidato> candidatos = candidatoRepository.findByVaga(vaga);
        modelAndView.addObject("candidatos", candidatos);
        modelAndView.addObject("candidato", new Candidato());

        return modelAndView;
    }

    // Deletar Vaga
    @RequestMapping("/deletarVaga")
    public String deletarVaga(long codigo) {
        Vaga vaga = vagaRepository.findByCodigo(codigo);
        vagaRepository.delete(vaga);

        return "redirect:/vagas";
    }

    // Adicionar Candidato
    @RequestMapping(value = "/vaga/{codigo}/candidato", method = RequestMethod.POST)
    public String detalhesVagaPost(@PathVariable("codigo") long codigo, @Valid Candidato candidato,
                                   BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/vaga/{codigo}";
        }

        // RG Duplicado
        if (candidatoRepository.findByRg(candidato.getRg()) != null) {
            attributes.addFlashAttribute("mensagem_erro", "RG já cadastrado.");
            return "redirect:/vaga/{codigo}";
        }

        Vaga vaga = vagaRepository.findByCodigo(codigo);
        candidato.setVaga(vaga);
        candidatoRepository.save(candidato);
        attributes.addFlashAttribute("mensagem", "Candidato adicionado com sucesso!");
        return "redirect:/vaga/{codigo}";
    }

    // Deletar Candidato pelo RG
    @RequestMapping("/deletarCandidato/{rg}")
    public String deletarCandidato(@PathVariable("rg") String rg) {

        Candidato candidato = candidatoRepository.findByRg(rg);

        if (candidato == null) {
            return "redirect:/vagas";
        }

        Vaga vaga = candidato.getVaga();
        long codigo = vaga.getCodigo();

        candidatoRepository.delete(candidato);

        return "redirect:/vaga/" + codigo;
    }

    // Atualizar vaga
    // Formulário edição de vaga
    @RequestMapping(value="/editar-vaga", method = RequestMethod.GET)
    public ModelAndView editarVaga(long codigo) {
        Vaga vaga = vagaRepository.findByCodigo(codigo);
        ModelAndView modelAndView = new ModelAndView("vaga/update-vaga");

        modelAndView.addObject("vaga", vaga);

        return modelAndView;
    }

    // Update Vaga
    @RequestMapping(value = "/editar-vaga", method = RequestMethod.POST)
    public String updateVaga(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes) {

        vagaRepository.save(vaga);
        attributes.addFlashAttribute("sucess", "Vaga alterada com sucesso!");

        long codigoLong = vaga.getCodigo();
        String codigo = "" + codigoLong;

        return "redirect:/vagas"    ;
    }

}
