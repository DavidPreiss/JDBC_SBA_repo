package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents() throws SQLException;
    Student getStudentsByEmail(String sEmail) throws SQLException;
    boolean validateStudent(String sEmail, String sPassword) throws SQLException;
    void registerStudentToCourse(String sEmail, int cId) throws SQLException;
    List<Course> getStudentCourses(String sEmail) throws SQLException;
}
