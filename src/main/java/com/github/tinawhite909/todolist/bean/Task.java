package com.github.tinawhite909.todolist.bean;

import java.time.LocalDate;

public class Task {
    private LocalDate startDate;
    private LocalDate finishDate;
    private String taskDescription;

    public Task(LocalDate startDate, LocalDate finishDate, String taskDescription) {
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.taskDescription = taskDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;

        Task task = (Task) o;

        if (!getFinishDate().equals(task.getFinishDate())) return false;
        return getTaskDescription().equals(task.getTaskDescription());
    }

    @Override
    public int hashCode() {
        int result = getFinishDate().hashCode();
        result = 31 * result + getTaskDescription().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "startDate=" + startDate +
                ", finishDate=" + finishDate +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
