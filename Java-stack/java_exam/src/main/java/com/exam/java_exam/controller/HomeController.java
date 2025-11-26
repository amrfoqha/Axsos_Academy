package com.exam.java_exam.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.java_exam.model.Task;
import com.exam.java_exam.model.LoginUser;
import com.exam.java_exam.model.User;
import com.exam.java_exam.service.TaskService;
import com.exam.java_exam.service.userService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private userService userService;
    @Autowired
    private TaskService taskService;

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
        taskService.updateOverdueTasks((User) session.getAttribute("loggedInUser"));
        model.addAttribute("tasks", taskService.getUserTasks((User) session.getAttribute("loggedInUser")));
        return "dashboard.jsp";
    }
    @GetMapping("/dashboard/inprogress")
    public String inprogress(HttpSession session, Model model) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/";
        }
        model.addAttribute("user", session.getAttribute("loggedInUser"));
        taskService.updateOverdueTasks((User) session.getAttribute("loggedInUser"));
        model.addAttribute("tasks", taskService.getInprogressTasks((User) session.getAttribute("loggedInUser")));
        return "dashboard.jsp";
    }
    @GetMapping("/dashboard/done")
    public String done(HttpSession session, Model model) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/";
        }
        model.addAttribute("user", session.getAttribute("loggedInUser"));
        taskService.updateOverdueTasks((User) session.getAttribute("loggedInUser"));
        model.addAttribute("tasks", taskService.getDoneTasks((User) session.getAttribute("loggedInUser")));
        return "dashboard.jsp";
    }
    @GetMapping("/dashboard/important")
    public String important(HttpSession session, Model model) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/";
        }
        model.addAttribute("user", session.getAttribute("loggedInUser"));
        taskService.updateOverdueTasks((User) session.getAttribute("loggedInUser"));
        model.addAttribute("tasks", taskService.getImportantTasks((User) session.getAttribute("loggedInUser")));
        return "dashboard.jsp";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
    @GetMapping("/tasks/new")
    public String newTask(@ModelAttribute("task") Task task, Model model, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/";
        }
        model.addAttribute("user", session.getAttribute("loggedInUser"));
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        model.addAttribute("toDay", sdf.format(new Date()));
        return "new_task.jsp";
    }
    @PostMapping("/tasks/new")
    public String createTask(@Valid @ModelAttribute("task") Task task, BindingResult result, HttpSession session,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", session.getAttribute("loggedInUser"));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            model.addAttribute("toDay", sdf.format(new Date()));
            return "new_task.jsp";
        }

        taskService.createTask(task, (User) session.getAttribute("loggedInUser"));
        return "redirect:/dashboard";
    }
    @GetMapping("/toggleImportance/{id}")
    public String toggleImportance(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/";
        }
        taskService.toggleImportance(id, (User) session.getAttribute("loggedInUser"));
        return "redirect:/dashboard";
    }
    @GetMapping("/task/{id}")
    public String task(@PathVariable("id") Long id, HttpSession session, Model model) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/";
        }
        model.addAttribute("user", session.getAttribute("loggedInUser"));
        model.addAttribute("task", taskService.getTaskById(id));
        return "task.jsp";
    }
    @GetMapping("/toggelInProgress/{id}")
    public String toggleInProgress(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/";
        }
        taskService.toggleInProgress(id, (User) session.getAttribute("loggedInUser"));
        return "redirect:/dashboard";
    }
    @GetMapping("/toggelDone/{id}")
    public String toggleDone(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/";
        }
        taskService.toggleDone(id, (User) session.getAttribute("loggedInUser"));
        return "redirect:/dashboard";
    }
    @GetMapping("/editTask/{id}")
    public String editTask(@ModelAttribute("task") Task task, @PathVariable("id") Long id, HttpSession session,
            Model model) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/";
        }
        model.addAttribute("user", session.getAttribute("loggedInUser"));
        model.addAttribute("task", taskService.getTaskById(id));
        return "edit_task.jsp";
    }
    @PostMapping("/editTask/{id}")
    public String updateTask(@Valid @ModelAttribute("task") Task task, BindingResult result, @PathVariable("id") Long id,
            HttpSession session, Model model) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/";
        }
        if (result.hasErrors()) {
            model.addAttribute("user", session.getAttribute("loggedInUser"));
            model.addAttribute("task", taskService.getTaskById(id));
            return "edit_task.jsp";
        }
        taskService.updateTask(task, id, (User) session.getAttribute("loggedInUser"));
        return "redirect:/dashboard";
    }
    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("loggedInUser") == null) {
            return "redirect:/";
        }
        taskService.deleteTask(id, (User) session.getAttribute("loggedInUser"));
        return "redirect:/dashboard";
    }
}
