package com.github.tinawhite909.todolist;

import com.github.tinawhite909.todolist.bean.Task;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        String filename = "taskList";

        Task task1 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 2, 12), "task1");
        Task task2 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 3, 12), "task2");
        Task task3 = new Task(LocalDate.of(2021, 4, 23), LocalDate.of(2022, 3, 12), "task3");

        Write(task1, filename);
        Write(task2, filename);
        Write(task3, filename);

        TaskList taskList = Read(filename);
        Print(taskList);
    }


    // TODO fix method name according to convention
    // TODO use logger instead of System.out
    // TODO extract to separate class
    // TODO need to support TaskList as parameter
    public static void Write(Task task, String filename) {
        // TODO probably it is better to use BufferedWriter
        // TODO you can use chaining writer.append().append().append()
        // TODO BufferedWriter supports newLine() method instead of directly adding it
        try (FileWriter writer = new FileWriter(filename, true)) {
            writer.append(getStringDateFormat(task.getStartDate()));
            writer.append(",");
            writer.append(getStringDateFormat(task.getFinishDate()));
            writer.append(",");
            writer.append(task.getTaskDescription());
            writer.append('\n');
        } catch (IOException ex) {
            // TODO need to rethrow own exception and handle on upper level
            System.out.println(ex.getMessage());
        }
    }

    public static String getStringDateFormat(LocalDate startDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy/MM/dd");
        String simpleDate = startDate.format(formatter);
        return simpleDate;
    }

    public static LocalDate getDateFormat(String simpleDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd");
        Date date = sdf.parse(simpleDate);
        LocalDate lDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return lDate;
    }

    // TODO fix method name according to convention
    // TODO use logger instead of System.out
    // TODO extract to separate class
    public static TaskList Read(String filename) {
        TaskList fileTaskList = new TaskList();
        try (FileReader reader = new FileReader(filename)) {
            Scanner scan = new Scanner(reader);
            String line = "";
            while (scan.hasNextLine()) {
                // TODO probably need empty constructor or construct with given parameters later
                Task task = new Task(null, null, null);
                line = scan.nextLine();
                String[] arr = line.split(",");
                task.setStartDate(getDateFormat(arr[0]));
                task.setFinishDate(getDateFormat(arr[1]));
                task.setTaskDescription(arr[2]);
                fileTaskList.addTask(task);
            }
            scan.close();
        } catch (IOException | ParseException ex) {
            // TODO need to rethrow own exception and handle on upper level
            System.out.println(ex.getMessage());
        }
        return fileTaskList;
    }

    // TODO fix method name according to convention
    // TODO use logger instead of System.out
    // TODO extract to separate class
    public static void Print(TaskList taskList) {
        for (Task task : taskList.getAllTasks()) {
            System.out.println(getStringDateFormat(task.getStartDate()) + " "
                    + getStringDateFormat(task.getFinishDate()) + " "
                    + task.getTaskDescription());
        }
    }

}

