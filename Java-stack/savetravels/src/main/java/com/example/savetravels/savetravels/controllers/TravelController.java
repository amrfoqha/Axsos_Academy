package com.example.savetravels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.savetravels.models.Travel;
import com.example.savetravels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class TravelController {
    
    private final TravelService travelService;

    public TravelController(TravelService travelService) {
        this.travelService = travelService;
    }
    @GetMapping("/")
    public String index(@ModelAttribute("travel") Travel travel, Model model) {
        model.addAttribute("travels", travelService.allRecords());
        return "home.jsp";
    }
    @PostMapping("/travels")
    public String createTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result,Model model) {
        if (result.hasErrors()) {
        model.addAttribute("travels", travelService.allRecords());
            return "home.jsp";
        }
        travelService.createTravel(travel);
        return "redirect:/";
    }
    @GetMapping("/travels/edit/{id}")
    public String showUpdateTravel(@PathVariable("id") Long id, Model model) {
        Travel travel = travelService.get(id);
        model.addAttribute("travel", travel);
        return "editTravel.jsp";
    }
    @PostMapping("/edit/{id}")
    public String editTravel(@PathVariable("id") Long id, @Valid @ModelAttribute("travel") Travel travel,
            BindingResult result) {
        if (result.hasErrors()) {
            return "editTravel.jsp";
        }
        System.out.println("\n\n\n\n\n\n\n\n\nUpdating travel with ID: " + travel.getId());
        travelService.updateTravel(travel, id);
        return "redirect:/";
    }
    @GetMapping("/travels/delete/{id}")
    public String deleteTravel(@PathVariable("id") Long id) {
        travelService.deleteTravel(id);
        return "redirect:/";
    }
    @GetMapping("/travel/{id}")
    public String showTravelDetails(@PathVariable("id") Long id, Model model) {
        Travel travel = travelService.get(id);
        model.addAttribute("travel", travel);
        return "travel.jsp";
    }
}
