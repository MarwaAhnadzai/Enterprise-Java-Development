package ca.sheridancollege.ahmamarw.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.ahmamarw.beans.Student;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.*;

@Repository
public class DatabaseAccess {

    @Autowired
    protected NamedParameterJdbcTemplate jdbc;

    public void insertStudentHardCoded() {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "INSERT INTO student(name) VALUES ('Frank')";
        int rowsAffected = jdbc.update(query, namedParameters);
        if (rowsAffected > 0)
            System.out.println("Inserted student into database.");
    }

    public void insertStudent(Student student) {
        String query = "INSERT INTO student(name) VALUES (:name)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("name", student.getName());
        int rowsAffected = jdbc.update(query, namedParameters);
        if (rowsAffected > 0)
            System.out.println("Inserted student into database.");
        
    }
	public List<Student> getStudentList()
	{ MapSqlParameterSource namedParameters =
			new
			MapSqlParameterSource();
			String query = "SELECT * FROM Student";
	return jdbc.query(query, namedParameters,
			new BeanPropertyRowMapper<Student>(Student.class));
	
	}
		
	}

