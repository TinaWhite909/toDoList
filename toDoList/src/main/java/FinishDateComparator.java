import java.util.Comparator;

public class FinishDateComparator implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2){

        return task1.getFinishDate().compareTo(task2.getFinishDate());
    }
}
