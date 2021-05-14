package com.github.tinawhite909.todolist;

import com.github.tinawhite909.todolist.bean.Task;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();

        String filename = "taskList";
        TaskList taskList = new TaskList();

        Task task1 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 2, 12), "task1");
        Task task2 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 3, 12), "task2");
        Task task3 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 3, 12), "task3");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);
        try {
            WriteToFile.writeToFile(taskList, filename);
            taskList = ReadFile.readFile(filename);
            printTaskList.printTaskList(taskList);
        }
        catch (IOException | ParseException e){
            logger.error(e.getMessage());
        }
    }

    public static String getStringDateFormat(LocalDate startDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String simpleDate = startDate.format(formatter);
        return simpleDate;
    }

    public static LocalDate getDateFormat(String simpleDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(simpleDate);
        LocalDate lDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return lDate;
    }

}

