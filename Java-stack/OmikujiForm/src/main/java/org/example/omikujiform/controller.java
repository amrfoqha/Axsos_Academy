package org.example.omikujiform;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class controller {
    @RequestMapping("/")
    public String home() {
        return "home.jsp";
    }
    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String submitForm(HttpSession session,
                             @RequestParam("number") String number,
                             @RequestParam("city") String city,
                             @RequestParam("name") String name,
                             @RequestParam("hobby") String hobby,
                             @RequestParam("living") String living,
                             @RequestParam("nice") String nice
                             ) {
        session.setAttribute("number",number);
        session.setAttribute("city",city);
        session.setAttribute("name",name);
        session.setAttribute("hobby",hobby);
        session.setAttribute("living",living);
        session.setAttribute("nice",nice);

        return "redirect:omikuji/show";
    }
    @RequestMapping("/omikuji/show")
    public String result(){

        return "result.jsp";
    }
}
