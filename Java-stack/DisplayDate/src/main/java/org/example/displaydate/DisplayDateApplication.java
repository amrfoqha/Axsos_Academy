package org.example.displaydate;

import jakarta.websocket.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@Controller
public class DisplayDateApplication {

	public static void main(String[] args) {
		SpringApplication.run(DisplayDateApplication.class, args);
	}
	@RequestMapping("/")
	public String index(Model model) {



		return "page1.jsp";
	}@RequestMapping("/date")
	public String date(Model model) {

		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("EEEE, MMM dd, YYYY");
		date.toString();
		model.addAttribute("date",dateFormat.format(date));

		return "page2.jsp";
	}@RequestMapping("/time")
	public String time(Model model) {

		Date date=new Date();
		DateFormat dateFormat=new SimpleDateFormat("h:mm a");
		date.toString();
		model.addAttribute("time",dateFormat.format(date));

		return "page3.jsp";
	}

}
