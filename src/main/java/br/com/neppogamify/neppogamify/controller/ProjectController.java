package br.com.neppogamify.neppogamify.controller;

import br.com.neppogamify.neppogamify.model.Funcionario;
import br.com.neppogamify.neppogamify.model.Projeto;
import br.com.neppogamify.neppogamify.repository.Funcionarios;
import br.com.neppogamify.neppogamify.repository.Projetos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by joaop on 19/08/2017.
 */
@Controller
@RequestMapping("/projeto")
public class ProjectController {
    @Autowired
    private Projetos projetos;

    @RequestMapping("/novo")
    public ModelAndView novo(){
        ModelAndView mv=new ModelAndView("NewProject");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(Projeto projeto){
        projetos.save(projeto);
        ModelAndView mv=new ModelAndView("HomeFuncionario");
        mv.addObject("mensagem","Projeto inicializado com sucesso!");
        mv.addObject("projetos",projetos.findAll());
        return mv;
    }

    @RequestMapping("/area")
    public ModelAndView area(){
        List<Projeto> allProjetos=projetos.findAll();
        ModelAndView mv=new ModelAndView("HomeFuncionario");
        mv.addObject("projetos",allProjetos);
        return mv;
    }

}
