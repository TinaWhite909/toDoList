package com.github.tinawhite909.todolist;

import com.github.tinawhite909.todolist.bean.Task;
import com.github.tinawhite909.todolist.exception.TaskIOException;
import com.github.tinawhite909.todolist.file.TaskFileManager;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

public class App {
    private final static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();

        TaskList taskList = new TaskList();

        Task task1 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 2, 12), "task1");
        Task task2 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 3, 12), "task2");
        Task task3 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 3, 12), "task3");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        String filename = "taskList";
        TaskFileManager tfm = new TaskFileManager(filename);
        TaskList newList;
//        try {
            tfm.writeToFile(taskList.getAllTasks());
            newList = new TaskList(tfm.readFromFile());
            tfm.printTaskList(taskList.getAllTasks());
//        } catch (TaskIOException e) {
//            logger.error(e.getMessage());
//        }
    }

}

