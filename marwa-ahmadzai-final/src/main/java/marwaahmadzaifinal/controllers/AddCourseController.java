package marwaahmadzaifinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import marwaahmadzaifinal.database.DatabaseAccess;

@Controller
public class AddCourseController {

    @Autowired
    private DatabaseAccess databaseAccess;

    @GetMapping("/add-course")
    public String showAddCourseForm() {
        return "add-course"; // Return the name of the HTML template for adding a course
    }

    @PostMapping("/add-course")
    public String addCourse(@RequestParam("studentId") Long studentId, 
                            @RequestParam("courseName") String courseName,
                            @RequestParam("grade") Long grade) {
        // Add the new course to the database
        databaseAccess.addCourse(studentId, courseName, grade);
        return "redirect:/"; // Redirect back to the index page after adding the course
    }
    
    @PostMapping("/save-course")
    public String saveCourse(@RequestParam("studentId") Long studentId, 
                             @RequestParam("courseName") String courseName,
                             @RequestParam("grade") Long grade) {
        // Add the new course to the database
        databaseAccess.addCourse(studentId, courseName, grade);
        return "redirect:/"; // Redirect back to the index page after adding the course
    }
}
