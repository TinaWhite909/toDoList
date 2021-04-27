import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskList {
    private ArrayList<Task> list = new ArrayList<>();

    public void addDescription(Task task) {
        list.add(task);
    }

    public void removeDescription(Task task) {
        list.remove(task);
    }

    public List<Task> getTaskByDate(Date finishDate) {
        List<Task> taskByDate = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (finishDate.equals(list.get(i).getFinishDate())) {
                taskByDate.add(list.get(i));
            }
        }
        return taskByDate;
    }
    public List<Task> getAllTasks(){
        List<Task> allTasks= new ArrayList<>();
        for (Task i : list) {
            allTasks.add(i);
        }
        return allTasks;
    }

}
