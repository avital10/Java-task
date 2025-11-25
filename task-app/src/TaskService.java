import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class TaskService {
    private TaskRepository repository;
// constructive action
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }
    //changing the status of an action to done and updating

    public void markAsDone(String taskId) {
        Task task = repository.GetById(taskId);
        if (task != null) {
            task.setStatus(Status.DONE);
            repository.Update(task);
        }
    }
    // returns tasks whose title or description contains the given text
    public List<Task> search(String text) {
        List<Task> result = new ArrayList<>();
        List<Task> allTasks = repository.ListAll(); //
        text = text.toLowerCase(); //
        for (int i = 0; i < allTasks.size(); i++) {
            Task t = allTasks.get(i);
            if (t.getTitle().toLowerCase().contains(text) ||
                    t.getDescription().toLowerCase().contains(text)) {
                result.add(t);
            }
        }

        return result;
    }
    // returns all tasks sorted by status

    public List<Task> listSortedByStatus() {
        List<Task> tasks = repository.ListAll();
        tasks.sort(Comparator.comparing(Task::getStatus));
        return tasks;
    }
}
