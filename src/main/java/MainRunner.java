import java.net.ConnectException;
import java.sql.*;
import java.util.Scanner;

public class MainRunner
{
    public static void main(String[] args) throws SQLException
    {

        System.out.println("\t MAIN START");

        //main start

        final String URL = "jdbc:mariadb://localhost/DAVIDS_DATABASE_5_5_2021";
        final String USER = "root";
        final String PASS = "root";
        Connection conn = DriverManager.getConnection(URL,USER,PASS);
        System.out.println(conn.isValid(1000));

        Scanner scanner = new Scanner(System.in);
        boolean repeat1 = true; //repeats the main menu
        while (repeat1)
        {

            //Greet the user
            System.out.println("Hello welcome to the address book!");
            //present Main Menu options
            System.out.println("(A)dd - (P)rint All - (S)earch - (E)xit");
            //read user input
            String userInput = scanner.nextLine().toLowerCase(); //ignore case
            if (userInput.equals(""))userInput = " "; //change empty strings to a single space to avoid exception
            char usrInChar = userInput.charAt(0); // read the first character for ease of use
            System.out.println("userInput: "+userInput); //print back what the user typed for confirmation
            switch (usrInChar)
            {

                case 'e': //exit
                {
                    repeat1 = false;
                    //setting repeat1 to false ends the outermost loop and thus ends the program
                    System.out.println("Goodbye!");
                    break;
                }
                case 'a': //exit
                {
                    repeat1 = false;
                    //setting repeat1 to false ends the outermost loop and thus ends the program
                    Statement mystate = conn.createStatement();
                    mystate.executeQuery(userAddStudent());
                    break;
                }

                default:
                {
                    System.out.println("invalid input");
                    break;
                }


            }
        }



        String satanString =
        "insert into student values ('cjaulme9@bing.com', 'Cahra Jaulme', 'FnVklVgC6r6');";

        String killString =
                "delete from student where name = 'Cahra Jaulme';";

        String runstring = killString;

        Statement mystate = conn.createStatement();
        //mystate.executeQuery(runstring);

        String selectSQL = "SELECT * FROM student;";
        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(selectSQL);
        int counter = 0;
        while(result.next())
        {
            //loop start
            String name = result.getString("name");
            String password = result.getString("password");
            String email = result.getString("email");
            System.out.printf("%-20s  | %-20s | %-10s \n",name,password,email);
            counter++;
        }
        System.out.println(counter+" total students");

        selectSQL = "SELECT * FROM course;";
        result = stmt.executeQuery(selectSQL);
        counter = 0;
        while(result.next())
        {
            //loop start
            String name = result.getString("name");
            String id = result.getString("id");
            String instructor = result.getString("instructor");
            System.out.printf("%-20s  | %-20s | %-10s \n",name,id,instructor);
            counter++;
        }
        System.out.println(counter+" total courses");

        conn.close();
        System.out.println("\t MAIN END");

    }
    //main end

    private static String userAddStudent()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input new Email: ");
        String email = scanner.nextLine();
        System.out.print("input new Name: ");
        String name = scanner.nextLine();
        System.out.print("input new Password: ");
        String password = scanner.nextLine();
        //String torun = buildStudent(email,name,password);
        return "insert into student values ('"+email+"', '"+name+"', '"+password+"');";
    }

    private static String buildStudent(String email, String name, String password) {

        return "insert into student values ('"+email+"', '"+name+"', '"+password+"');";

    }
}
