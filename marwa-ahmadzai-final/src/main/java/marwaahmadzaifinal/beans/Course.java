package marwaahmadzaifinal.beans;

public class Course {
    private Long id;
    private String name;
    private String instructor;
    private int grade; // Adding grade field

    // Constructors
    public Course() {
    }

    public Course(Long id, String name, String instructor) {
        this.id = id;
        this.name = name;
        this.instructor = instructor;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}

