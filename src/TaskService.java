import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskService {
    private TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void markAsDone(String taskId) {
        Task task = repository.GetById(taskId);
        if (task != null) {
            task.setStatus(Status.DONE);
            repository.Update(task);
        }
    }

    public List<Task> search(String text) {
        List<Task> result = new ArrayList<>();
        for (Task t : repository.ListAll()) {
            if (t.getTitle().toLowerCase().contains(text.toLowerCase()) ||
                    t.getDescription().toLowerCase().contains(text.toLowerCase())) {
                result.add(t);
            }
        }
        return result;
    }

    public List<Task> listSortedByStatus() {
        List<Task> tasks = repository.ListAll();
        tasks.sort(Comparator.comparing(Task::getStatus));
        return tasks;
    }
}
