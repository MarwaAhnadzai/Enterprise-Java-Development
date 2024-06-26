package marwaahmadzaifinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import marwaahmadzaifinal.beans.Student;
import marwaahmadzaifinal.database.DatabaseAccess;

@Controller
public class StudentController {

    @Autowired
    private DatabaseAccess databaseAccess;

    @GetMapping("/view-courses")
    public String viewCourses(@RequestParam("student") String studentName, Model model) {
        // Retrieve the student by name from the database
        Student student = databaseAccess.getStudentByName(studentName);
        if (student != null) {
            // Add the student object to the model
            model.addAttribute("student", student);
            model.addAttribute("studentName", studentName);
            model.addAttribute("courses", databaseAccess.getCoursesForStudent(student.getId()));
            return "view-student";
        } else {
            // Handle case where student is not found
            return "student-not-found";
        }
    }

    @PostMapping("/add-student-course")
    public String addStudentCourse(@RequestParam("studentId") Long studentId, 
                                   @RequestParam("courseName") String courseName,
                                   @RequestParam("grade") Long grade) {
        // Add the new course to the database for the student
        databaseAccess.addCourse(studentId, courseName, grade);
        return "redirect:/"; // Redirect back to the index page after adding the course
    }
}



