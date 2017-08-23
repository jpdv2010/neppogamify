package br.com.neppogamify.neppogamify.controller;

import br.com.neppogamify.neppogamify.model.CargoFuncionario;
import br.com.neppogamify.neppogamify.model.Funcionario;
import br.com.neppogamify.neppogamify.model.Projeto;
import br.com.neppogamify.neppogamify.model.Verificator;
import br.com.neppogamify.neppogamify.repository.Funcionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
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
        mv.addObject(new Funcionario());
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(@Validated Funcionario funcionario,Errors errors){
        ModelAndView mv=new ModelAndView("home");
        if(errors.hasErrors()){
            mv.setViewName("CadastroFuncionario");
            return mv;
        }
        funcionarios.save(funcionario);
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

    @RequestMapping(value="/verificar",method = RequestMethod.POST)
    public ModelAndView verifica(Verificator verificator){
        ModelAndView mv=new ModelAndView("CadastroFuncionario");
        List<Funcionario> allFuncionarios=funcionarios.findAll();
        for(Funcionario f:allFuncionarios){
            if(f.getEmail()==verificator.getEmailVerify() && f.getPassword()==verificator.getPasswordVerify()){
                mv.setViewName("HomeFuncionario");
                mv.addObject("funcionario",f);
            }else{
                mv.setViewName("home");
            }
        }
        return mv;
    }




    @ModelAttribute("allCargosFuncionario")
    public List<CargoFuncionario> allCargosFuncionario(){
        return Arrays.asList(CargoFuncionario.values());
    }
}
