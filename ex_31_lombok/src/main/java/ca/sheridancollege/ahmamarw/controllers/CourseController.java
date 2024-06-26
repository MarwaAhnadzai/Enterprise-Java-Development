package ca.sheridancollege.ahmamarw.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.ahmamarw.beans.Course;
import ca.sheridancollege.ahmamarw.repositories.CourseList;

@RestController
public class CourseController {

    private final CourseList courseList;

    public CourseController(CourseList courseList) {
        this.courseList = courseList;
    }

    @PostMapping("/processForm")
    public String processForm(
            @RequestParam Long id,
            @RequestParam String prefix,
            @RequestParam String code,
            @RequestParam String name
    ) {
        Course course = Course.builder()
                .id(id)
                .prefix(prefix)
                .code(code)
                .name(name)
                .build();
        courseList.getCourseList().add(course);

        System.out.println("***");
        for (Course c : courseList.getCourseList()) {
            System.out.println(c);
        }

        return "redirect:/";
    }
}
