import java.util.Comparator;

public class FinishDateComparator implements Comparator<Task> {
    @Override
    public int compare(Task task1, Task task2) {
        if (task1.getFinishDate().compareTo(task2.getFinishDate()) < 0) {
            return -1;
        }
        if (task1.getFinishDate().compareTo(task2.getFinishDate()) > 0) {
            return 1;
        }
        return 0;
    }
}
