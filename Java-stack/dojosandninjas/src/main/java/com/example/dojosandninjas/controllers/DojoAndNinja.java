package com.example.dojosandninjas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.services.DojoAndNinjaService;

import jakarta.validation.Valid;

@Controller
public class DojoAndNinja {

    @Autowired
    private final DojoAndNinjaService dojoAndNinjaService;

    public DojoAndNinja(DojoAndNinjaService dojoAndNinjaService) {
        this.dojoAndNinjaService = dojoAndNinjaService;
    }
    


    @GetMapping("/")
    public String root(@ModelAttribute("dojo") Dojo dojo, Model model) {

        model.addAttribute("dojos", dojoAndNinjaService.allDojos());
        return "index.jsp";
    }
    @PostMapping("/dojos/new")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {

        if (result.hasErrors()) {
            return "index.jsp";
        }
        dojoAndNinjaService.createDojo(dojo);
        return "redirect:/";

    }

    @GetMapping("/ninjas")
    public String formCreateNinja(@ModelAttribute("ninja") Ninja ninja,Model model) {
        model.addAttribute("dojos", dojoAndNinjaService.allDojos());
        return "ninja.jsp";
    }
    @PostMapping("/ninjas/new")
    public String CreateNinja(@Valid @ModelAttribute("ninja") Ninja ninja, Model model, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("dojos", dojoAndNinjaService.allDojos());
            return "ninja.jsp";
        }
        dojoAndNinjaService.createNinja(ninja);
        return "redirect:/ninjas";

    }
    
    @GetMapping("/dojo/{id}")
    public String getDojo(@PathVariable("id") Long id, Model model) {
        
        Dojo dojo = dojoAndNinjaService.getDojoById(id);
        if(dojo == null){
            return "NotFound.jsp";
        }
        model.addAttribute("dojo", dojo);
        
        return "dojodetails.jsp";
    }


}
