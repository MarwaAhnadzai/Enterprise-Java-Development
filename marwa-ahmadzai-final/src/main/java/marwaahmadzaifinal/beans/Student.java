package marwaahmadzaifinal.beans;

import java.util.List;

public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private List<Course> courses; // Assuming a student can have multiple courses

    // Constructors
    public Student() {
    }

    public Student(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Method to get the full name of the student
    public String getName() {
        return firstName + " " + lastName;
    }
}
