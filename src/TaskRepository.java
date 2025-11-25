import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();
    private final String file = "tasks.json";

    private void SaveToFile() {
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println("[");
            for (int i = 0; i < tasks.size(); i++) {
                Task t = tasks.get(i);
                pw.println("  {");
                pw.println("    \"id\": \"" + t.getId() + "\",");
                pw.println("    \"title\": \"" + t.getTitle() + "\",");
                pw.println("    \"description\": \"" + t.getDescription() + "\",");
                pw.println("    \"status\": \"" + t.getStatus() + "\"");
                pw.print("  }");
                if (i < tasks.size() - 1) pw.println(",");
                else pw.println();
            }
            pw.println("]");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Add(Task t) {
        tasks.add(t);
        SaveToFile();
    }

    public void Update(Task t) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(t.getId())) {
                tasks.set(i, t);

            }

        }
        SaveToFile();
    }

    public void Delete(Task deleteT) {
        List<Task> help = tasks;
        for (int i = 0; i < help.size(); i++) {
            if (help.get(i).getId().equals(deleteT.getId()))
                help.remove(deleteT);

        }
        SaveToFile();
    }

    //public void delete(Task deleteT){
    //     tasks.removeIf(t -> t.getId().equals(deleteT.getId()));
    //   saveToFile();
    public Task GetById(String id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(id))
                return tasks.get(i);
        }
        return null;
    }

    public List<Task> ListAll() {
        return new ArrayList<>(tasks); //
    }
}

