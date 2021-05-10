import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MainRunnerTest {

    @Test
    void firstTest(){
        //jpa.entitymodels.Course mytest = new jpa.entitymodels.Course(1,"1","1");
        List<Course> testList = new ArrayList<>();
        Student testboy = new Student("testmail", "testboy","testpass",testList);
        //Assertions.assertEquals(1,1);
        Assertions.assertEquals("testboy",testboy.getsName());
    }
}