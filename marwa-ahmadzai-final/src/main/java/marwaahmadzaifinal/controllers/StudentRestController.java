package marwaahmadzaifinal.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentRestController {

    @PostMapping("/api/students/{studentId}/courses")
    public ResponseEntity<String> addCourse(
            @PathVariable Long studentId,
            @RequestParam String courseName,
            @RequestParam Long courseId) {
        
        // Your implementation here
        
        return ResponseEntity.ok("Course added successfully");
    }

    // Other REST controller methods...
}
