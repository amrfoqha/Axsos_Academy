package com.example.world1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.world1.service.CitiesService;
import com.example.world1.service.CountriesService;
import com.example.world1.service.LanguagesService;

@Controller
public class HomeController {
    @Autowired
    private CountriesService countriesService;
    @Autowired
    private CitiesService citiesService;
    @Autowired
    private LanguagesService languagesService;
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("table", countriesService.Query1());
        model.addAttribute("table2", countriesService.Query2());
        model.addAttribute("table3", citiesService.Query3());
        model.addAttribute("table4", languagesService.Query4());
        model.addAttribute("table5", countriesService.Query5());
        model.addAttribute("table6", countriesService.Query6());
        model.addAttribute("table7", citiesService.Query7());
        model.addAttribute("table8", countriesService.Query8());

        return "index.jsp";
    }
}
