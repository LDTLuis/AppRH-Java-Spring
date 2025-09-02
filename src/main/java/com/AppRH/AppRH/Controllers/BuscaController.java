package com.AppRH.AppRH.Controllers;

import com.AppRH.AppRH.Repository.CandidatoRepository;
import com.AppRH.AppRH.Repository.DependenteRepository;
import com.AppRH.AppRH.Repository.FuncionarioRepository;
import com.AppRH.AppRH.Repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView abrirIndex() {

        ModelAndView modelAndView1 = new ModelAndView("index");

        return modelAndView1;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView buscarIndex(@RequestParam("buscar") String buscar, @RequestParam("nome") String nome) {

        ModelAndView modelAndView = new ModelAndView("index");

        String mensagem = "Resultados da busca por " + buscar;

        if(nome.equals("nomeFuncionario")) {

            modelAndView.addObject("funcionarios", funcionarioRepository.finByNomesFuncionarios(buscar));
            
        } else if(nome.equals("nomeDependente")) {

            modelAndView.addObject("dependentes", dependenteRepository.finByNomesDependentes(buscar));
            
        } else if(nome.equals("nomeCandidatos")) {

            modelAndView.addObject("candidatos", candidatoRepository.finByCandidatos(buscar));

        } else if(nome.equals("tituloVaga")) {

            modelAndView.addObject("vagas", vagaRepository.finByVagas(buscar));

        } else {

            modelAndView.addObject("funcionarios", funcionarioRepository.finByNomesFuncionarios(buscar));
            modelAndView.addObject("dependentes", dependenteRepository.finByNomesDependentes(buscar));
            modelAndView.addObject("candidatos", candidatoRepository.finByCandidatos(buscar));
            modelAndView.addObject("vagas", vagaRepository.finByVagas(buscar));

        }

        modelAndView.addObject("mensagem", mensagem);

        return modelAndView;
    }
    
    



}
