package com.github.tinawhite909.todolist;

import com.github.tinawhite909.todolist.bean.Task;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TaskListTest {
    TaskList taskList;
    TaskList compliedTaskList;

    @Before
    public void setUp() throws Exception {


        taskList = new TaskList();
        Task task1 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 2, 12), "task1");
        Task task2 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 3, 12), "task2");
        Task task3 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 1, 12), "task2");

        compliedTaskList = new TaskList();
        compliedTaskList.addTask(task1);
        compliedTaskList.addTask(task2);
        compliedTaskList.addTask(task2);
        compliedTaskList.addTask(task3);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldAddTaskToEmptyList() {
        Task task3 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 2, 12), "task3");
        assertEquals(0, taskList.returnSizeList());
        taskList.addTask(task3);
        assertEquals(1, taskList.returnSizeList());
    }

    @Test
    public void shouldAddWrongTask() {
        Task task4 = new Task(LocalDate.of(2021, 3, 20), null, "task4");
        Task task41 = new Task(LocalDate.of(2021, 3, 20), LocalDate.of(2022, 2, 12), null);
        assertEquals(0, taskList.returnSizeList());
        taskList.addTask(task4);
        taskList.addTask(task41);

        assertEquals(0, taskList.returnSizeList());
    }

    @Test
    public void shouldRemoveTask() {
        assertEquals(4, compliedTaskList.returnSizeList());
        Task task1 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 2, 12), "task1");
        compliedTaskList.removeTask(task1);
        assertEquals(3, compliedTaskList.returnSizeList());
    }

    @Test
    public void shouldGetTaskByDate() {
        Task task5 = new Task(LocalDate.of(2021, 5, 23), LocalDate.of(2022, 3, 12), "task5");
        Task task6 = new Task(LocalDate.of(2020, 5, 23), LocalDate.of(2022, 3, 12), "task6");
        compliedTaskList.addTask(task5);
        compliedTaskList.addTask(task6);
        LocalDate finishDate = LocalDate.of(2022, 3, 12);

        assertEquals(4, compliedTaskList.getTaskByDate(finishDate).size());
    }


}