package com.example.studentroster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.studentroster.models.Dorm;
import com.example.studentroster.models.Student;
import com.example.studentroster.services.DormService;
import com.example.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    DormService dormService;
    @Autowired
    StudentService studentService;

    @GetMapping("/dorms")
    public String index(Model model) {
        model.addAttribute("dorms", dormService.getAllDorms());
        return "index.jsp";
    }

    @GetMapping("/dorms/new")
    public String newDorm(@ModelAttribute("dorm") Dorm dorm) {

        return "newdorm.jsp";
    }
    @PostMapping("/dorms/new")
    public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult result) {
        if (result.hasErrors()) {
            return "newdorm.jsp";
        } else {
            dormService.createDorm(dorm);
            return "redirect:/dorms";
        }
    }
    @GetMapping("/students/new")
    public String newStudent(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("dorms", dormService.getAllDorms());
        return "newstudent.jsp";
    }
    @PostMapping("/students/new")
    public String createStudent(@Valid @ModelAttribute("student") Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("dorms", dormService.getAllDorms());
            return "newstudent.jsp";
        }
        studentService.save(student);
        return "redirect:/dorms";
    }
    @GetMapping("/dorms/{id}")
    public String showDorm(@PathVariable("id") Long id, Model model) {
        Dorm dorm = dormService.findDormById(id);
        model.addAttribute("dorm", dorm);
        return "showdorm.jsp";
    }
    @GetMapping("/dorms/{dormId}/remove/{studentId}")
    public String removeStudent(@PathVariable("dormId") Long dormId, @PathVariable("studentId") Long studentId, Model model) {
        Student student = studentService.findStudentById(studentId);
        if (student != null) {
            student.setDorm(null);
            studentService.save(student);
        }
        return "redirect:/dorms/"+dormId+"/remove/"+studentId;
    }
}
