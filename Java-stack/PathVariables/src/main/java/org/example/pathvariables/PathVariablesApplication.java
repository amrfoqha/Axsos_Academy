package org.example.pathvariables;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PathVariablesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PathVariablesApplication.class, args);
	}


}
