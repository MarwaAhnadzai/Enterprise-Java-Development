-- Create table students
CREATE TABLE students (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  number BIGINT NOT NULL UNIQUE,
  name VARCHAR(128) NOT NULL
);

-- Create table courses
CREATE TABLE courses (
  id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  studentId BIGINT NOT NULL,
  name VARCHAR(128) NOT NULL,
  grade BIGINT NOT NULL,
  FOREIGN KEY (studentId) REFERENCES students(id)
);

-- Insert sample data into students table
INSERT INTO students (number, name) VALUES (1234, 'Charlie Brown');
INSERT INTO students (number, name) VALUES (4321, 'Lucy');

-- Insert sample data into courses table
INSERT INTO courses (name, grade, studentId) VALUES ('Java 1', 83, 1);
INSERT INTO courses (name, grade, studentId) VALUES ('Java 3', 92, 2);
INSERT INTO courses (name, grade, studentId) VALUES ('Databases', 78, 2);
