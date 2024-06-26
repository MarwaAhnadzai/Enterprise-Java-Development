package ca.sheridancollege.ahmamarw.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.ahmamarw.beans.Course;
import ca.sheridancollege.ahmamarw.repositories.CourseList;

@Controller
public class CourseController {

    private final CourseList courseList;

    public CourseController(CourseList courseList) {
        this.courseList = courseList;
    }

    @GetMapping("/")
    public String index(Model model) {
        System.out.println("Clearing List");
        courseList.emptyList();
        return "index";
    }

    @PostMapping("/processForm")
    public String processForm(
            @RequestParam Long id,
            @RequestParam String prefix,
            @RequestParam int code,
            @RequestParam String name
    ) {
        Course course = new Course(id, prefix, code, name);
        courseList.getCourseList().add(course);

        System.out.println("***");
        for (Course c : courseList.getCourseList()) {
            System.out.println(c);
        }

        return "redirect:/";
    }
}
