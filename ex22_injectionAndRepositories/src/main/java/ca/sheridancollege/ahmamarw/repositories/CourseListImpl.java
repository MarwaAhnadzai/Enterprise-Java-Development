package ca.sheridancollege.ahmamarw.repositories;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;

import ca.sheridancollege.ahmamarw.beans.Course;

@Component
public class CourseListImpl implements CourseList {

    private List<Course> courseList = new CopyOnWriteArrayList<>();

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
}
