package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseService implements CourseDAO {

    @Override
    public List<Course> getAllCourses() throws SQLException {
        /*
        –This method takes no
        parameter and returns
        every Course in the
        table.
         */
        List<Course> retval = new ArrayList<>();
        final String URL = "jdbc:mariadb://localhost/DAVIDS_DATABASE_5_5_2021";
        final String USER = "root";
        final String PASS = "root";

        Connection conn = DriverManager.getConnection(URL,USER,PASS);

        String selectSQL = "SELECT * FROM course;";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(selectSQL);
        while(result.next())
        {
            //loop start
            int id = result.getInt("id");
            String name = result.getString("name");
            String instructor = result.getString("instructor");
            retval.add(new Course(id,name,instructor));
        }
        conn.close();
        return retval;
    }
}
