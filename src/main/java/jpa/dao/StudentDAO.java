package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents() throws SQLException;
    Student getStudentsByEmail(String sEmail);
    boolean validateStudent(String sEmail, String sPassword);
    void registerStudentToCourse(String sEmail, int cId);
    List<Course> getStudentCourses(String sEmail);
}
