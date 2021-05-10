package com.github.tinawhite909.todolist.bean;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TaskTest {
    private static final Logger logger = LoggerFactory.getLogger(TaskTest.class);

    @Test
    public void checkEquals() {
        Task task1 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 2, 12), "task1");
        Task task2 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 2, 12), "task1");

        assertEquals(task1, task2);
    }

    @Test
    public void checkEquals1() {
        Task task1 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 2, 12), "task1");
        Task task2 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 2, 12), "task1");

        assertEquals(task1, task2);
    }
}