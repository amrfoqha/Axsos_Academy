package com.example.studentroster.controllers;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
    // @RequestMapping("/error")
    // public String handleError() {
    //     // Return a view name for your 404 page, or redirect
    //     return "redirect:/dorms";  // Or "error/404" for a custom page
    // }
}
