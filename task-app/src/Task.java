public class Task {
    // Defining class variables
    private String Id;
    private String Title;
    private String Description;
    private Status status;

    //  Constructor action for the Task class
    public Task(String id, String title, String description, Status status) {
        Id = id;
        Title = title;
        Description = description;
        this.status = status;
    }

    // Returns a unique identifier for the task.
    public String getId() {
        return Id;
    }
    // Update a unique task ID

    public void setId(String id) {
        Id = id;
    }

    // Return title
    public String getTitle() {
        return Title;
    }

    // Update title
    public void setTitle(String title) {
        Title = title;
    }
    //  Return Description

    public String getDescription() {
        return Description;
    }
    // Update Description

    public void setDescription(String description) {
        Description = description;
    }
    // Return Status

    public Status getStatus() {
        return status;
    }

    // Update Status

    public void setStatus(Status status) {
        this.status = status;
    }

    //Overriding print operation
    public String toString() {
        return "Task{" + "id=" + Id + ", title='" + Title + '\'' + ", status=" + status + '}';
    }
}

