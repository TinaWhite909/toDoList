package com.github.tinawhite909.todolist;

import com.github.tinawhite909.todolist.bean.Task;

public class printTaskList {
    public static void printTaskList(TaskList taskList) {
        for (Task task : taskList.getAllTasks()) {
            App.logger.info(App.getStringDateFormat(task.getStartDate()) + " "
                    + App.getStringDateFormat(task.getFinishDate()) + " "
                    + task.getTaskDescription());
        }
    }
}
