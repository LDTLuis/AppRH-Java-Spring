package com.AppRH.AppRH.controllers;

import com.AppRH.AppRH.repository.CandidatoRepository;
import com.AppRH.AppRH.repository.DependenteRepository;
import com.AppRH.AppRH.repository.FuncionarioRepository;
import com.AppRH.AppRH.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

    @GetMapping("/")
    public ModelAndView abrirIndex(
            @RequestParam(value = "buscar", required = false) String buscar,
            @RequestParam(value = "nome", required = false) String nome
    ) {
        ModelAndView modelAndView = new ModelAndView("index");

        if (buscar != null && nome != null) {
            String mensagem = "Resultados da busca por '" + buscar + "'";
            modelAndView.addObject("mensagem", mensagem);

            switch (nome) {
                case "nomeFuncionario" -> modelAndView.addObject("funcionarios", funcionarioRepository.finByNomesFuncionarios(buscar));
                case "nomeDependente" -> modelAndView.addObject("dependentes", dependenteRepository.finByNomesDependentes(buscar));
                case "nomeCandidato" -> modelAndView.addObject("candidatos", candidatoRepository.finByCandidatos(buscar));
                case "tituloVaga" -> modelAndView.addObject("vagas", vagaRepository.finByVagas(buscar));
                case "todos" -> {
                    modelAndView.addObject("funcionarios", funcionarioRepository.finByNomesFuncionarios(buscar));
                    modelAndView.addObject("dependentes", dependenteRepository.finByNomesDependentes(buscar));
                    modelAndView.addObject("candidatos", candidatoRepository.finByCandidatos(buscar));
                    modelAndView.addObject("vagas", vagaRepository.finByVagas(buscar));
                }
            }
        }

        return modelAndView;
    }
}
