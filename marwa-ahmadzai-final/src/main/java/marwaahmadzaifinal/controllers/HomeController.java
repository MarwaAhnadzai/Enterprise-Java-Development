package marwaahmadzaifinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import marwaahmadzaifinal.beans.Student;
import marwaahmadzaifinal.database.DatabaseAccess;

@Controller
public class HomeController {

    @Autowired
    private DatabaseAccess databaseAccess;

    @GetMapping("/")
    public String index(Model model) {
        // Populate the model with student data for the dropdown
        model.addAttribute("students", databaseAccess.getAllStudents());
        return "index"; // return the index.html template
    }

    @GetMapping("/view-student")
    public String viewStudentCourses(@RequestParam("studentId") Long studentId, Model model) {
        // Retrieve the student and their courses from the database
        Student student = databaseAccess.getStudentById(studentId);
        if (student != null) {
            // Add the student object to the model
            model.addAttribute("student", student);
            // Add the student's name to the model
            model.addAttribute("studentName", student.getName()); // Assuming you have a getName() method in your Student class
            return "view-student"; // return the view-student.html template
        } else {
            // Handle case where student is not found
            return "student-not-found"; // Create a new HTML template for this case
        }
    }
}



