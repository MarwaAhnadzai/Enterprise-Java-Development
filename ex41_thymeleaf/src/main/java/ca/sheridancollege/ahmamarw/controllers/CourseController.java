package ca.sheridancollege.ahmamarw.controllers;

import ca.sheridancollege.ahmamarw.beans.Course;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class CourseController {

    // List to store Course objects
    private List<Course> courseList = new CopyOnWriteArrayList<>();

    // GET mapping for root URL ("/") to display the list of courses
    @GetMapping("/")
    public String index(Model model) {
        // Add the courseList to the model for display in the view
        model.addAttribute("courseList", courseList);
        // Return the view name "index" to display the list of courses
        return "index";
    }

    // POST mapping to handle adding a new course
    @PostMapping("/addCourse")
    public String addCourse(@RequestParam Long id,
                            @RequestParam String prefix,
                            @RequestParam String code,
                            @RequestParam String name,
                            Model model) {
        // Create a new Course object with the provided parameters
        Course course = new Course(id, prefix, code, name);
        // Add the new course to the courseList
        courseList.add(course);
        // Add the updated courseList to the model for display in the view
        model.addAttribute("courseList", courseList);
        // Return the view name "index" to display the updated list of courses
        return "index";
    }
}
