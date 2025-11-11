package org.example.ninjagoldgame;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@SpringBootApplication
@Controller
public class NinjaGoldGameApplication {
    ArrayList<String> activities = new ArrayList<String>();
    SimpleDateFormat formatter = new SimpleDateFormat("MMMMM dd yyyy h:mm a");
    Date date;

    public static void main(String[] args) {
        SpringApplication.run(NinjaGoldGameApplication.class, args);
    }

    @RequestMapping("/")
    public String home(HttpSession session) {
        if (session.getAttribute("balance") == null) {
            session.setAttribute("balance", 0);
        }
        if (session.getAttribute("activities") == null) {
            session.setAttribute("activities", new ArrayList<String>());
        }
        int balance = (int) session.getAttribute("balance");
    if (balance <= -50) {
        return "redirect:/jail";
    
    }
        return "home.jsp";
    }

    @RequestMapping("/gold")
    public String calculateGold(@RequestParam(value = "hidden") String hidden, HttpSession session) {

        Random rand = new Random();
        if (hidden.equals("farm")) {
            int gold = rand.nextInt(11) + 10;
            date = new Date();
            activities.add("You entered a farm and earned " + gold + " gold." + " (" + formatter.format(date) + ")");
            session.setAttribute("activities", activities);
            session.setAttribute("balance", (int) session.getAttribute("balance") + gold);
        }

        else if (hidden.equals("Cave")) {
            int gold = rand.nextInt(6) + 5;
            date = new Date();
            activities.add("You entered a cave and earned " + gold + " gold." + " (" + formatter.format(date) + ")");
            session.setAttribute("activities", activities);
            session.setAttribute("balance", (int) session.getAttribute("balance") + gold);

        }

        else if (hidden.equals("House")) {
            int gold = rand.nextInt(3) + 5;
            date = new Date();
            activities.add("You entered a house and earned " + gold + " gold." + " (" + formatter.format(date) + ")");
            session.setAttribute("activities", activities);
            session.setAttribute("balance", (int) session.getAttribute("balance") + gold);

        }

        else if (hidden.equals("Quest")) {
            int gold = rand.nextInt(101) - 50;
            date = new Date();
            session.setAttribute("balance", (int) session.getAttribute("balance") + gold);
            if (gold >= 0) {
                activities.add(
                        "You completed a quest and earned " + gold + " gold." + " (" + formatter.format(date) + ")");

            } else {
                activities.add("You failed a quest and lost " + Math.abs(gold) + " gold." + " ("
                        + formatter.format(date) + ")");
            }
            session.setAttribute("activities", activities);
        } else if (hidden.equals("Spa")) {
            int gold = -(rand.nextInt(16) + 5);

            date = new Date();
            session.setAttribute("balance", (int) session.getAttribute("balance") + gold);

            activities.add(
                    "You failed a Spa and lost " + Math.abs(gold) + " gold." + " (" + formatter.format(date) + ")");
            session.setAttribute("activities", activities);
        }

        return "redirect:/";
    }

    @RequestMapping("/jail")
    public String jail() {
        return "jail.jsp";
    }

    @RequestMapping("/flush")
    public String flush(HttpSession session) {
        session.setAttribute("balance", null);
        session.setAttribute("activities", null);
        activities.clear();
        return "redirect:/";
    }
}
