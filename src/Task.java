public class Task {
        private String Id;
        private String Title;
        private String Description;
        private Status status;

        public Task(String id, String title, String description, Status status) {
            Id = id;
            Title = title;
            Description = description;
            this.status = status;
        }

        public String getId() {
            return Id;
        }

        public void setId(String id) {
            Id = id;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            Title = title;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            Description = description;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }
        public String toString() {
            return "Task{" + "id=" + Id + ", title='" + Title + '\'' + ", status=" + status + '}';
        }
    }

