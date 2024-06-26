package ca.sheridancollege.ahmamarw.repositories;

import org.springframework.stereotype.Component;
import ca.sheridancollege.ahmamarw.beans.Course;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseListImpl implements CourseList {

    private List<Course> courseList = new ArrayList<>();

    @Override
    public List<Course> getCourseList() {
        return courseList;
    }

    @Override
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public void emptyList() {
        courseList.clear();
    }

    @Override
    public void addCourse(Course course) {
        courseList.add(course);
    }
}
