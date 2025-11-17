package com.example.onetoone.controllers;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.onetoone.models.Passport;
import com.example.onetoone.models.Person;
import com.example.onetoone.services.PassportService;
import com.example.onetoone.services.PersonService;

import jakarta.validation.Valid;


@Controller
public class TestController {

    
    private PersonService personService;
    private PassportService passportService;


    public TestController(PersonService personService , PassportService passportService) {
        this.personService = personService;
        this.passportService = passportService;
    }


    @GetMapping("/")
    public String index(@ModelAttribute("person") Person person, Model model) {
        
        model.addAttribute("persons", personService.getAllPerson());
        return "index.jsp";
    }
    @PostMapping("/person/new")
    public String CreatePerson(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("persons", personService.getAllPerson());
            return "index.jsp";
        }
        personService.add(person);

        return "redirect:/";
    }
    @GetMapping("/passport/{id}")
    public String showPassport(@PathVariable("id") Long id, Model model,@ModelAttribute("passport") Passport passport) {
        model.addAttribute("person", personService.getById(id));
        return "showPassport.jsp";
    }

    @PostMapping("/passport/new/{id}")
    public String CreatePassport(@Valid @ModelAttribute("passport") Passport passport,
             BindingResult result,
             Model model, @PathVariable("id") Long id) {
        if (result.hasErrors()) {
            model.addAttribute("person", personService.getById(id));
            return "showPassport.jsp";
        }
        Person person = personService.getById(id);
        person.setPassport(passport);
        passportService.add(passport);

        return "redirect:/";
    }


}
