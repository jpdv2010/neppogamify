package br.com.neppogamify.neppogamify.controller;

import br.com.neppogamify.neppogamify.model.CargoFuncionario;
import br.com.neppogamify.neppogamify.model.Funcionario;
import br.com.neppogamify.neppogamify.model.Projeto;
import br.com.neppogamify.neppogamify.repository.Funcionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by joaop on 16/08/2017.
 */
@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private Funcionarios funcionarios;

    @RequestMapping("/novo")
    public ModelAndView novo(){

        ModelAndView mv=new ModelAndView("CadastroFuncionario");
        //mv.addObject("allCargosFuncionario", CargoFuncionario.values());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(Funcionario funcionario){
        funcionarios.save(funcionario);
        ModelAndView mv=new ModelAndView("home");
        mv.addObject("mensagem","Cadastrado com sucesso!");
        return mv;
    }

    @RequestMapping("/ranking")
    public ModelAndView ranking() {
        List<Funcionario> allFuncionarios =funcionarios.findAll();
        ModelAndView mv=new ModelAndView("ranking");
        mv.addObject("funcionarios",allFuncionarios);
        return mv;
    }




    @ModelAttribute("allCargosFuncionario")
    public List<CargoFuncionario> allCargosFuncionario(){
        return Arrays.asList(CargoFuncionario.values());
    }
}
