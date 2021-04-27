import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

public class TaskListTest {
    TaskList taskList;

    @Before
    public void setUp() throws Exception {
        taskList = new TaskList();
        Task task1=new Task(LocalDate.of(2021,4,23),LocalDate.of(2022,2,12),"task1");
        Task task2=new Task(LocalDate.of(2021,4,23),LocalDate.of(2022,2,12),"task1");
        Task task3=new Task(LocalDate.of(2021,4,23),LocalDate.of(2022,2,12),"task1");
        Task task4=new Task(LocalDate.of(2021,4,23),LocalDate.of(2022,2,12),"task1");
        Task task5=new Task(LocalDate.of(2021,4,23),LocalDate.of(2022,2,12),"task1");

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldAddTaskToEmptyList() {
        Task task3=new Task(LocalDate.of(2021,4,23),LocalDate.of(2022,2,12),"task1");


    }

    @Test
    public void shouldRemoveTask() {
    }

    @Test
    public void getTaskByDate() {
    }

    @Test
    public void getAllTasks() {
    }
}