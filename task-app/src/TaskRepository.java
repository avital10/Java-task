import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class TaskRepository {

    // the list of tasks currently managed by the repository.
    private List<Task> tasks = new ArrayList<>();
    private final String file = "tasks.json";
    //Constructs a new TaskRepository and loads tasks from the JSON file if it exists.
    public TaskRepository() {
        tasks = loadFromFile();
    }
    // loads tasks from the JSON file.
    // each task is expected to have "id", "title", "description", and "status" fields.

    private List<Task> loadFromFile() {
        List<Task> list = new ArrayList<>();
        File f = new File(file);
        if (!f.exists()) {
            return list;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            String id = null, title = null, description = null;
            Status status = null;

            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.startsWith("\"id\"")) {
                    id = line.split(":")[1].trim().replace("\"", "").replace(",", "");
                } else if (line.startsWith("\"title\"")) {
                    title = line.split(":")[1].trim().replace("\"", "").replace(",", "");
                } else if (line.startsWith("\"description\"")) {
                    description = line.split(":")[1].trim().replace("\"", "").replace(",", "");
                } else if (line.startsWith("\"status\"")) {
                    String s = line.split(":")[1].trim().replace("\"", "").replace(",", "");
                    status = Status.valueOf(s);
                } else if (line.equals("},") || line.equals("}")) {
                    if (id != null && title != null && description != null && status != null) {
                        list.add(new Task(id, title, description, status));
                    }
                    id = title = description = null;
                    status = null;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
    // saves the current list of tasks to the JSON file.
    // each task is written with its "id", "title", "description", and "status".
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
    // adds a new task to the repository and saves it to the file.

    public void Add(Task t) {
        tasks.add(t);
        SaveToFile();
    }

    //  updates an existing task in the repository and saves the changes to the file.
    //  the task is matched by its ID.

    public void Update(Task t) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(t.getId())) {
                tasks.set(i, t);
            }
        }
        SaveToFile();
    }
    // deletes a task from the repository and updates the file.
    //  the task is matched by its ID.

    public void Delete(Task deleteT) {
        List<Task> help = tasks;
        for (int i = 0; i < help.size(); i++) {
            if (help.get(i).getId().equals(deleteT.getId()))
                help.remove(deleteT);

        }
        SaveToFile();
    }

     // returns a task by its id. If no task is found, returns null.
    public Task GetById(String id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(id))
                return tasks.get(i);
        }
        return null;
    }
    // returns a list of all tasks in the repository.

    public List<Task> ListAll() {
        return new ArrayList<>(tasks);
    }
}




