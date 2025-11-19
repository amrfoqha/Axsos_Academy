package com.example.burgertracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.burgertracker.models.Burger;
import com.example.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {

    private final BurgerService burgerService;

    public BurgerController(BurgerService burgerService) {
        this.burgerService = burgerService;
    }
    @GetMapping("/")
    public String index(@ModelAttribute("burger") Burger burger, Model model) {
        model.addAttribute("burgers", burgerService.allRecords());
        return "home.jsp";
    }
    @PostMapping("/burgers")
    public String createBurger(@Valid @ModelAttribute("burger") Burger burger, BindingResult result,Model model) {
        if (result.hasErrors()) {
        model.addAttribute("burgers", burgerService.allRecords());
            return "home.jsp";
        }
        burgerService.createBurger(burger);
        return "redirect:/";
    }
    @GetMapping("/burgers/edit/{id}")
    public String showUpdateBurger(@PathVariable("id") Long id, Model model) {
        Burger burger = burgerService.get(id);
        model.addAttribute("burger", burger);
        return "editBurger.jsp";
    }
    @PostMapping("/edit/{id}")
    public String editBurger(@PathVariable("id") Long id, @Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
        if (result.hasErrors()) {
            
            return "editBurger.jsp";
        }
        System.out.println("\n\n\n\n\n\n\n\n\nUpdating burger with ID: " + burger.getId());
        burgerService.updateBurger(burger, id);
        return "redirect:/";
    }
}
