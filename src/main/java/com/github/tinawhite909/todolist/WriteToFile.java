package com.github.tinawhite909.todolist;

import com.github.tinawhite909.todolist.bean.Task;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    public static void writeToFile(TaskList taskList, String filename) throws IOException {
        for (Task task : taskList.getAllTasks()) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
                writer.append(App.getStringDateFormat(task.getStartDate())).append(",")
                        .append(App.getStringDateFormat(task.getFinishDate())).append(",")
                        .append(task.getTaskDescription());
                writer.newLine();
                writer.close();
        }
    }
}
