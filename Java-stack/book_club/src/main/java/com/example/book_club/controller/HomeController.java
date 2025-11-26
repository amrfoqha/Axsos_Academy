package com.example.book_club.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.book_club.model.Task;
import com.example.book_club.model.LoginUser;
import com.example.book_club.model.User;
import com.example.book_club.service.TaskService;
import com.example.book_club.service.userService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private userService userService;
    @Autowired
    private TaskService bookService;

    @RequestMapping(value="/**")
      public String redirect() {
          return "redirect:/";
      }

    @GetMapping("/")
    public String index(@ModelAttribute("user") User user, @ModelAttribute("loginUser") LoginUser loginUser) {
        return "index.jsp";
    }
    @PostMapping("/register")
    public String register(@Valid@ModelAttribute("user") User user, BindingResult result,@ModelAttribute("loginUser") LoginUser loginUser,Model model,HttpSession session) {
        User newUser = userService.createUser(user, result);
        if (result.hasErrors()) {
            return "index.jsp";
        }
        session.setAttribute("loggedInUser", newUser);
        return "redirect:/dashboard";
    }
    @PostMapping("/login")
    public String login(@Valid@ModelAttribute("loginUser") LoginUser loginUser, BindingResult result,
            @ModelAttribute("user") User user, Model model, HttpSession session) {
        User newUser = userService.loginUser(loginUser, result);
        if (result.hasErrors()) {
            return "index.jsp";
        }
        session.setAttribute("loggedInUser", newUser);
        return "redirect:/dashboard";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/";
        }
        model.addAttribute("user", session.getAttribute("loggedInUser"));
        model.addAttribute("books", bookService.getAllBooks());
        return "dashboard.jsp";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Task book, Model model) {
        return "new_book.jsp";
    }
}
