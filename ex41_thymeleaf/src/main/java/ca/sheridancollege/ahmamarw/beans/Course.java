package ca.sheridancollege.ahmamarw.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// Course class representing a course entity
public class Course {
    
    // Course attributes
    private Long id;         // Unique identifier for the course
    private String prefix;   // Course prefix (e.g., "COMP")
    private String code;     // Course code (e.g., "101")
    private String name;     // Course name (e.g., "Introduction to Programming")

}
