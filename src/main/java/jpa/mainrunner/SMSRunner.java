package jpa.mainrunner;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;

import java.sql.SQLException;
import java.sql.Statement;

import java.util.Scanner;

public class SMSRunner {
    public static void main(String[] args) throws SQLException {
        /*
        -This method displays and prompt the user to select one of the following with the option:
        1. Student: which allows the user to enter
        his/her email and password and check whether
        or not those credentials are valid, in order
        to log in. If the credentials are invalid the
        program should end with appropriate message to
        the student.
        If the credentials are valid, the student is
        logged in and all the classes the Student is
        registered to should be displayed. Displays
        and prompt the student to select one of the
        following two additional numeric (1 or 2)
        options that are available:
        • 1) Register to Class: Which displays all
        the courses in the database and allows
        the student to select a course in which
        the student wished to be registered to.
        If the Student is already registered in
        that course, display the message "You
        are already registered in that course!",
        otherwise, register the student to that
        course and save this result in your
        database. Also show the updated
        registered courses list for that
        student. After that end the program with
        appropriate message.
        • 2) Logout: Which ends the program with
        appropriate message.
        2. quit: which ends the program with
        appropriate message.

         */
        Scanner scanner = new Scanner(System.in);
        boolean repeat1 = true; //repeats the main menu
        while (repeat1)
        {

            //Greet the user
            System.out.println("Hello welcome to the Student Course System!");
            //present Main Menu options
            System.out.println("(1)Student (2)quit");
            //read user input
            String userInput = scanner.nextLine().toLowerCase(); //ignore case
            if (userInput.equals(""))userInput = " "; //change empty strings to a single space to avoid exception
            char usrInChar = userInput.charAt(0); // read the first character for ease of use
            System.out.println("userInput: "+userInput); //print back what the user typed for confirmation
            switch (usrInChar)
            {

                case '2': //exit
                {
                    repeat1 = false;
                    //setting repeat1 to false ends the outermost loop and thus ends the program
                    System.out.println("Goodbye!");
                    break;
                }
                case '1': //Log in
                {

                    repeat1 = false;
                    StudentLogIn();
                    break;
                }

                default:
                {
                    System.out.println("invalid input");
                    break;
                }


            }
            //end of switchcase
        }
        //end of repeat loop
    }
    //end of main

    private static void StudentLogIn() throws SQLException
    {


        Scanner scanner = new Scanner(System.in);
            //Greet the user
        System.out.println("Hello welcome to the Student Log In page!");
        //present Main Menu options
            System.out.print("Student Email: ");
            //read user input
            String userEmail = scanner.nextLine();
            System.out.print("Student Password: ");
            //read user input
            String userPass = scanner.nextLine();
            if (StudentService.validateStudent(userEmail,userPass))
            {
                UserFunction(userEmail);
            }
            else
            {
                System.out.println("Invalid Login Credentials");
            }
    }
    //end of StudentLogin

    private static void UserFunction(String userEmail) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        boolean repeat1 = true;
        while (repeat1) {
            System.out.println("Hello welcome to the Student Course System!");
            //present Main Menu options
            System.out.println("(1) Register to Class (2)Log out");
            //read user input
            String userInput = scanner.nextLine().toLowerCase(); //ignore case
            if (userInput.equals("")) userInput = " "; //change empty strings to a single space to avoid exception
            char usrInChar = userInput.charAt(0); // read the first character for ease of use
            System.out.println("userInput: " + userInput); //print back what the user typed for confirmation
            switch (usrInChar) {

                case '2': //exit
                {
                    repeat1 = false;
                    //setting repeat1 to false ends the outermost loop and thus ends the program
                    System.out.println("Logging out, GoodBye!");
                    break;
                }
                case '1': //Log in
                {
                /*
                    1) Register to Class: Which displays all
                the courses in the database and allows
                the student to select a course in which
                the student wished to be registered to.
                If the Student is already registered in
                that course, display the message "You
                are already registered in that course!",
                otherwise, register the student to that
                course and save this result in your
                database. Also show the updated
                registered courses list for that
                student. After that end the program with
                appropriate message.
                 */
                    for (Course thing : CourseService.getAllCourses()) {
                        System.out.println(thing.getcID() + ") " + thing.getcName() + " with " + thing.getcInstructorName());
                    }
                    System.out.println("pick a class to register to");
                    //read user input
                    int userClassId = scanner.nextInt();
                    StudentService.registerStudentToCourse(userEmail, userClassId);
                    System.out.println("You're registered for the following classes: ");
                    for (Course registered : StudentService.getStudentCourses(userEmail)) {
                        System.out.println(registered.getcName() + " with " + registered.getcInstructorName());
                    }
                    break;
                }

                default: {
                    System.out.println("invalid input");
                    break;
                }


            }
            //end of switchcase
        }
        //end of while loop

    }
    //end of UserFunction

}
