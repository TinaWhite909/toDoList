import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class TaskListTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("Code executes before each method");
        Task task1 = new Task();
        Date date = new Date();
        task1.setStartDate(date);
        task1.setTaskDescription("to play");
        task1.setFinishDate(date.setDate(date.getDay()+3));

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addDescription() {
    }

    @Test
    public void removeDescription() {
    }

    @Test
    public void getTaskByDate() {
    }

    @Test
    public void getAllTasks() {
    }
}