package org.example.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
	}
		@RequestMapping("/")
	public String index(@RequestParam(value = "name",required = false) String name,
						@RequestParam(value = "last_name",required = false) String last_name,
						@RequestParam(value = "times",required = false) String times){

		String str="";
		if(name == null)return "Hello Human!";

		str="Hello "+name;
		if(last_name != null)str=str.concat(last_name);
		if(times !=null){
			int num=Integer.parseInt(times);
			String newstr="";
			for (int i = 0; i < num; i++) {
				newstr=newstr.concat(str+" ");
			}
			str=newstr;
		}
		return str;
		}
}
