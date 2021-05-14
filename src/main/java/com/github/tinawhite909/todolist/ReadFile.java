package com.github.tinawhite909.todolist;

import com.github.tinawhite909.todolist.bean.Task;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class ReadFile {

    public static TaskList readFile(String filename) throws IOException, ParseException {
        TaskList fileTaskList = new TaskList();
        FileReader reader = new FileReader(filename);
            Scanner scan = new Scanner(reader);
            String line = "";
            while (scan.hasNextLine()) {
                Task task = new Task(null, null, null);
                line = scan.nextLine();
                String[] arr = line.split(",");
                task.setStartDate(App.getDateFormat(arr[0]));
                task.setFinishDate(App.getDateFormat(arr[1]));
                task.setTaskDescription(arr[2]);
                fileTaskList.addTask(task);
            }
            scan.close();
        return fileTaskList;
    }
}
