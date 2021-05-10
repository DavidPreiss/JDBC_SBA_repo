package jpa.entitymodels;

import jpa.entitymodels.Course;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String sEmail,sName,sPass;
    List<Course> sCourse;

    public Student() {

        this.sEmail = "sEmail";
        this.sName = "sName";
        this.sPass = "sPass";
        this.sCourse = new ArrayList<>();//{new jpa.entitymodels.Course()};
    }

    public Student(String sEmail, String sName, String sPass, List<Course> sCourse) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
        this.sCourse = sCourse;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }

    public List<Course> getsCourse() {
        return sCourse;
    }

    public void setsCourse(List<Course> sCourse) {
        this.sCourse = sCourse;
    }
}
