package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

import java.util.List;

public class CourseService implements CourseDAO {

    @Override
    public List<Course> getAllCourses() {
        return null;
        /*
        –This method takes no
        parameter and returns
        every Course in the
        table.
         */
    }
}
