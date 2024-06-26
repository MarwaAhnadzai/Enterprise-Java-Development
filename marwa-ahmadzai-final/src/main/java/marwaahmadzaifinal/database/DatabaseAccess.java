package marwaahmadzaifinal.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import marwaahmadzaifinal.beans.Course;
import marwaahmadzaifinal.beans.Student;

@Component
public class DatabaseAccess {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    // Method to retrieve all students from the database
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
    }

    // Method to retrieve a student by ID from the database
    public Student getStudentById(Long studentId) {
        String sql = "SELECT * FROM students WHERE id = :studentId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("studentId", studentId);
        try {
            return jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Student.class));
        } catch (Exception e) {
            // Handle the case where no student with the given ID is found
            return null;
        }
    }

    // Method to add a course for a student to the database
    public void addCourse(Long studentId, String courseName, Long grade) {
        String sql = "INSERT INTO courses (studentId, name, grade) VALUES (:studentId, :courseName, :grade)";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("studentId", studentId);
        params.addValue("courseName", courseName);
        params.addValue("grade", grade);
        jdbcTemplate.update(sql, params);
    }

    // Method to retrieve all courses for a student from the database
    public List<Course> getCoursesForStudent(Long studentId) {
        String sql = "SELECT * FROM courses WHERE studentId = :studentId";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("studentId", studentId);
        return jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Course.class));
    }

    // Method to retrieve a student by name from the database
    public Student getStudentByName(String studentName) {
        String sql = "SELECT * FROM students WHERE name = :studentName";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("studentName", studentName);
        try {
            return jdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Student.class));
        } catch (Exception e) {
            // Handle the case where no student with the given name is found
            return null;
        }
    }
}


