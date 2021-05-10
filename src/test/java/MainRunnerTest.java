import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainRunnerTest {

    @Test
    void firstTest() throws Exception{
        //Course mytest = new Course(1,"1","1");
        List<Course> testList = new ArrayList<Course>();
        Student testboy = new Student("testmail", "testboy","testpass",testList);
        //Assertions.assertEquals(1,1);
        Assertions.assertEquals("testboy",testboy.getsName());
    }
}