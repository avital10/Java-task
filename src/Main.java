public class Main {
    public static void main(String[] args) {
        TaskRepository repo = new TaskRepository();
        Task t1 = new Task("1", "ללמוד Java", "לסיים את תרגיל המטלה", Status.NEW);
        Task t2 = new Task("2", "לכתוב דוח", "לכתוב דוח שבועי", Status.IN_PROGRESS);
        repo.Add(t1);
        repo.Add(t2);
        System.out.println("כל המשימות אחרי הוספה:");
        for (Task t : repo.ListAll()) {
            System.out.println(t);
        }
        t1.setStatus(Status.DONE);
        repo.Update(t1);
        System.out.println("\nכל המשימות אחרי עדכון:");
        for (Task t : repo.ListAll()) {
            System.out.println(t);
        }
        repo.Delete(t2);

        System.out.println("\nכל המשימות אחרי מחיקה:");
        for (Task t : repo.ListAll()) {
            System.out.println(t);
        }

        System.out.println("\nבדיקה getById:");
        Task check = repo.GetById("1");
        if (check != null) {
            System.out.println(check);
        } else {
            System.out.println("לא נמצאה משימה עם id 1");
        }
    }
}
