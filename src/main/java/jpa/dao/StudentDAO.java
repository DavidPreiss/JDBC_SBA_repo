package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudents() throws SQLException;
    Student getStudentsByEmail(String sEmail) throws SQLException;

    static boolean validateStudent(String sEmail, String sPassword) throws SQLException {
        return false;
    }

    static void registerStudentToCourse(String sEmail, int cId) throws SQLException {

    }

    static List<Course> getStudentCourses(String sEmail) throws SQLException {
        return null;
    }
}
