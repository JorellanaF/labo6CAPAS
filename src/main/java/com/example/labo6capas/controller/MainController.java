package com.example.labo6capas.controller;

import com.example.labo6capas.domain.Contribuyente;
import com.example.labo6capas.domain.Importancia;
import com.example.labo6capas.services.ContribuyenteService;
import com.example.labo6capas.services.ImportanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ImportanciaService importanciaService;

    @Autowired
    private ContribuyenteService contribuyenteService;

    @RequestMapping("/inicio")
    private ModelAndView inicio(){
        ModelAndView mav = new ModelAndView();
        List<Importancia> importancias = null;

        try {
            importancias=importanciaService.findAll();
        }catch(Exception e) {
            e.printStackTrace();
        }

        mav.addObject("contribuyente", new Contribuyente());
        mav.addObject("importancias", importancias);
        mav.setViewName("index");

        return mav;
    }

    @RequestMapping("/procesado")
    private ModelAndView prosForm(@Valid @ModelAttribute Contribuyente contribuyente , BindingResult result){
        ModelAndView mav = new ModelAndView();

        if (result.hasErrors()){
            List<Importancia> importancias = null;

            try {
                importancias=importanciaService.findAll();
            }catch(Exception e) {
                e.printStackTrace();
            }
            mav.addObject("importancias", importancias);
            mav.setViewName("index");
        }else {
            try {
                contribuyenteService.insert(contribuyente);
            }catch(Exception e) {
                e.printStackTrace();
            }
            mav.addObject("contribuyente", new Contribuyente());
            mav.setViewName("exito");
        }

        return mav;
    }

    //Mostrar lista de Estudiante
    @RequestMapping("/listado")
    public ModelAndView listado() {
        ModelAndView mav = new ModelAndView();
        List<Contribuyente> contribuyentes = null;
        try {
            contribuyentes = contribuyenteService.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mav.addObject("contribuyentes", contribuyentes);
        mav.setViewName("listado");

        return mav;
    }

}
