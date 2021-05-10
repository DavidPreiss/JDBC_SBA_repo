package jpa.dao;

import jpa.entitymodels.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDAO {

    static List<Course> getAllCourses() throws SQLException {
        return null;
    }
}
