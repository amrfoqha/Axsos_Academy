package com.example.loginandregistration.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.loginandregistration.models.User;
import com.example.loginandregistration.models.UserLogin;
import com.example.loginandregistration.services.UserService;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

      @RequestMapping(value="/**")
      public String redirect() {
          return "redirect:/";
      }
    
      @GetMapping("/")
      public String landingPage(@ModelAttribute("user") User user, @ModelAttribute("userLogin") UserLogin userLogin) {
          return "home.jsp";
      }
      @PostMapping("/user/new")
      public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result,
              @ModelAttribute("userLogin") UserLogin userLogin, Model model, HttpSession httpSession) {
          User newUser = userService.createUser(user, result);
          if (result.hasErrors()) {
              return "home.jsp";
          } else {
              httpSession.setAttribute("loggedInUser", newUser);
          }

          return "redirect:/welcome";
      }
      

      @PostMapping("/user/login")
      public String loginUser(@Valid @ModelAttribute("userLogin") UserLogin userLogin,
              BindingResult result, @ModelAttribute("user") User user, HttpSession httpSession) {
                 User newUser = userService.loginUser(userLogin, result);
                 if (result.hasErrors()) {
                     return "home.jsp";
                 }
                 else {
                    httpSession.setAttribute("loggedInUser", newUser);
                    return "redirect:/welcome";
                 }
      }
      
      @GetMapping("/welcome")
      public String showWelcome(HttpSession httpSession, Model model) {
          if (httpSession.getAttribute("loggedInUser") != null) {
              model.addAttribute("user", httpSession.getAttribute("loggedInUser"));
              return "welcome.jsp";
          } else {
              return "redirect:/";
          }
      }
      
      @GetMapping("/logout")
      public String logOut(HttpSession httpSession) {
          if (httpSession.getAttribute("loggedInUser") == null) {
            return "redirect:/";
            }
          httpSession.setAttribute("loggedInUser", null);
          return "redirect:/";
      }
}
