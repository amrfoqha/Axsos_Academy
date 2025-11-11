package org.example.ninjagold;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class NinjaGoldApplication {

    public static void main(String[] args) {
        SpringApplication.run(NinjaGoldApplication.class, args);
    }
    @RequestMapping("/")
    public String home() {
        return "index.jsp";
    }
}
