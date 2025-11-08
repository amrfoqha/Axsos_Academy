package org.example.pathvariables;


import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping("daikichi/travel/{city}")
    public String displayTravel (@PathVariable("city") String city){
        return "Congratulations! You will soon travel to "+city;
    }
    @RequestMapping("daikichi/lotto/{num}")
    public String displayTravel (@PathVariable("num") int num){
        if (num%2==0)
            return "You will take a grand journey in the near future but be wary of tempting offers.";
            return "You have enjoyed the fruits of your labor, but now is a great time to spend time with family and friends.";
    }




}
