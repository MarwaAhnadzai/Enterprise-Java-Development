package ca.sheridancollege.ahmamarw.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.ahmamarw.beans.Student;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index(Model model) {
		return "index";
	}
	
	@PostMapping("/formPost") // HTTP POST to http:localhost:8080/formPost
	public String formPost(
			@RequestParam String firstName, 
			@RequestParam String lastName,
			@RequestParam String email,
			@RequestParam Long studentNumber,
			@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate birthday) {
		
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setStudentNumber(studentNumber);
		student.setBirthday(birthday);
		
		System.out.println(student);
		
		return "working";
	}
	
}
