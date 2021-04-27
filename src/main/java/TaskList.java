import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<Task> list = new ArrayList<>();

    public void addDescription(Task task) {
        if (isCorrect(task)) {
            list.add(task);
        }
        else {
            throw new IllegalArgumentException("Значения не могут быть null");
        }
    }

    public boolean isCorrect(Task task){
        return task.getFinishDate()!=null && task.getTaskDescription()!=null;
    }

    public void removeDescription(Task task) {
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

    public List<Task> getAllTasks() {
       List<Task> newList = new ArrayList<>(list);
        newList.sort(new FinishDateComparator());

        return newList;
    }



}
