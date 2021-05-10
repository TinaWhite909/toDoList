package com.github.tinawhite909.todolist;

import com.github.tinawhite909.todolist.bean.Task;
import com.github.tinawhite909.todolist.comparator.FinishDateComparator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<Task> list = new ArrayList<>();

    public void addTask(Task task) {
        if (task.getFinishDate() != null && task.getTaskDescription() != null) {
            list.add(task);
        }
    }

    public void removeTask(Task task) {
        list.remove(task);
    }

    public List<Task> getTaskByDate(LocalDate finishDate) {
        List<Task> taskByDate = new ArrayList<>();
        for (Task task : list) {
            if (finishDate.equals(task.getFinishDate())) {
                taskByDate.add(task);
            }
        }
        return taskByDate;
    }

    public int returnSizeList() {
        return list.size();
    }

    public List<Task> getAllTasks() {
        List<Task> newList = new ArrayList<>(list);
        newList.sort(new FinishDateComparator());

        return newList;
    }


}
