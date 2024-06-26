package ca.sheridancollege.ahmamarw.repositories;


import java.util.List;

import ca.sheridancollege.ahmamarw.beans.Course;

public interface CourseList {

    List<Course> getCourseList();

    void setCourseList(List<Course> courseList);

    void emptyList();
}
