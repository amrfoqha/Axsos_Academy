package org.example.test2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Test2Application {

    public static void main(String[] args) {
        SpringApplication.run(Test2Application.class, args);
    }
    @RequestMapping("/")
    public String world(){
        return "hello world! <br><a href='/login'> go to login</a>";
    }
    @RequestMapping("/login")
    public String login(){
        return "hello world! <br><a href='/'> go to home</a>";
    }


}
