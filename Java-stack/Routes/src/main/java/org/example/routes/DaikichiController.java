package org.example.routes;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DaikichiController {
    @RequestMapping("/")
    public String root(){
        return "hello";
    }
    @RequestMapping("daikichi")
    public String displayWelcome(){
        return "Welcome!";
    }
    @RequestMapping("daikichi/today")
    public String displayToday(){
        return "Today you will find luck in all your endeavors!";
    }
    @RequestMapping("daikichi/tomorrow")
    public String displayTomorrow(){
        return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
    }


}
