package org.example.counter;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class counterController {
    @RequestMapping("/")
    public String home(HttpSession session){
        if(session.getAttribute("count") == null){
            session.setAttribute("count",0);
        }
        int count=(int)session.getAttribute("count");
        session.setAttribute("count",count+1);

        return "home.jsp";
    }
    @RequestMapping("/counter")
    public String countPage(HttpSession session){
        if(session.getAttribute("count") == null){
            session.setAttribute("count",0);
        }

        return "count.jsp";
    }@RequestMapping("/inc3")
    public String inc3(HttpSession session){
        if(session.getAttribute("count") == null){
            session.setAttribute("count",0);
        }
        int count=(int)session.getAttribute("count");
        session.setAttribute("count",count+3);

        return "thirdPage.jsp";
    }@RequestMapping("/reset")
    public String reset(HttpSession session){

        session.setAttribute("count",0);

        return "count.jsp";
    }
}
