package com.github.tinawhite909.todolist.file;

import com.github.tinawhite909.todolist.bean.Task;
import com.github.tinawhite909.todolist.exception.TaskIOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class TaskFileManager {
    private final static Logger LOGGER = LoggerFactory.getLogger(TaskFileManager.class);
    private final String filename;

    public TaskFileManager(String filename) {
        this.filename = filename;
    }

    public void printTaskList(List<Task> taskList) {
        for (Task task : taskList) {
            LOGGER.info(getStringDateFormat(task.getStartDate()) + " "
                    + getStringDateFormat(task.getFinishDate()) + " "
                    + task.getTaskDescription());
        }
    }

    public List<Task> readFromFile() {
        List<Task> taskList = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(filename))) {
            String line = "";
            while (scan.hasNextLine()) {
                Task task = new Task(null, null, null);
                line = scan.nextLine();
                String[] arr = line.split(",");
                task.setStartDate(getDateFormat(arr[0]));
                task.setFinishDate(getDateFormat(arr[1]));
                task.setTaskDescription(arr[2]);
                taskList.add(task);
            }
        } catch (FileNotFoundException | ParseException fnfe) {
            fnfe.printStackTrace();
            throw new TaskIOException("Read from file " + filename + " exception.", fnfe);
        }
        return taskList;
    }

    public void writeToFile(List<Task> taskList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (Task task : taskList) {
                writer.append(getStringDateFormat(task.getStartDate()))
                        .append(",")
                        .append(getStringDateFormat(task.getFinishDate()))
                        .append(",")
                        .append(task.getTaskDescription());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new TaskIOException("Write to file " + filename + " exception.", e);
        }
    }

    private String getStringDateFormat(LocalDate startDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String simpleDate = startDate.format(formatter);
        return simpleDate;
    }

    private LocalDate getDateFormat(String simpleDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(simpleDate);
        LocalDate lDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return lDate;
    }
}
