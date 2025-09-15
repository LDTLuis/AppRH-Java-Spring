package com.AppRH.AppRH.controllers;

import com.AppRH.AppRH.repository.CandidatoRepository;
import com.AppRH.AppRH.repository.DependenteRepository;
import com.AppRH.AppRH.repository.FuncionarioRepository;
import com.AppRH.AppRH.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BuscaController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private DependenteRepository dependenteRepository;

    @Autowired
    private CandidatoRepository candidatoRepository;

    // 1. Método GET para exibir a página inicial e os resultados da busca
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView abrirIndex() {
        ModelAndView modelAndView = new ModelAndView("index");
        // Os resultados da busca (adicionados como flash attributes)
        // estarão disponíveis aqui automaticamente para o Thymeleaf.
        return modelAndView;
    }

    // 2. Método POST para processar a busca e redirecionar
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String buscarIndex(@RequestParam("buscar") String buscar, @RequestParam("nome") String nome, RedirectAttributes attributes) {

        String mensagem = "Resultados da busca por '" + buscar + "'";

        if(nome.equals("nomeFuncionario")) {
            attributes.addFlashAttribute("funcionarios", funcionarioRepository.finByNomesFuncionarios(buscar));
        } else if(nome.equals("nomeDependente")) {
            attributes.addFlashAttribute("dependentes", dependenteRepository.finByNomesDependentes(buscar));
        } else if(nome.equals("nomeCandidatos")) { // Atenção: Verifique se o valor no HTML é "nomeCandidatos"
            attributes.addFlashAttribute("candidatos", candidatoRepository.finByCandidatos(buscar));
        } else if(nome.equals("tituloVaga")) {
            attributes.addFlashAttribute("vagas", vagaRepository.finByVagas(buscar));
        } else {
            attributes.addFlashAttribute("funcionarios", funcionarioRepository.finByNomesFuncionarios(buscar));
            attributes.addFlashAttribute("dependentes", dependenteRepository.finByNomesDependentes(buscar));
            attributes.addFlashAttribute("candidatos", candidatoRepository.finByCandidatos(buscar));
            attributes.addFlashAttribute("vagas", vagaRepository.finByVagas(buscar));
        }

        attributes.addFlashAttribute("mensagem", mensagem);

        // 3. Redireciona para o método GET, evitando o reenvio do formulário
        return "redirect:/";
    }
}