import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskRepository repo = new TaskRepository();

        while (true) {
            System.out.println("choose task");
            System.out.println("1. הוסף משימה");
            System.out.println("2. עדכן משימה");
            System.out.println("3. מחק משימה");
            System.out.println("4. סימון כ-DONE");
            System.out.println("5. חפש משימה לפי ID");
            System.out.println("6. הצג כל המשימות");
            System.out.println("0. יציאה");
            System.out.print("בחר אופציה: ");

            int choice = sc.nextInt();
            sc.nextLine(); // סורק את ה-enter שנשאר

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    Task t = new Task(id, title, desc, Status.NEW);
                    repo.Add(t);
                    System.out.println("משימה נוספה!");
                    break;

                case 2:
                    System.out.print("ID של המשימה לעדכון: ");
                    String updateId = sc.nextLine();
                    Task toUpdate = repo.GetById(updateId);
                    if (toUpdate != null) {
                        System.out.print("Title חדש: ");
                        toUpdate.setTitle(sc.nextLine());
                        System.out.print("Description חדש: ");
                        toUpdate.setDescription(sc.nextLine());
                        repo.Update(toUpdate);
                        System.out.println("משימה עודכנה!");
                    } else {
                        System.out.println("לא נמצאה משימה עם ID זה.");
                    }
                    break;

                case 3:
                    System.out.print("ID של המשימה למחיקה: ");
                    String deleteId = sc.nextLine();
                    Task toDelete = repo.GetById(deleteId);
                    if (toDelete != null) {
                        repo.Delete(toDelete);
                        System.out.println("משימה נמחקה!");
                    } else {
                        System.out.println("לא נמצאה משימה עם ID זה.");
                    }
                    break;

                case 4:
                    System.out.print("ID של משימה לסימון כ-DONE: ");
                    String doneId = sc.nextLine();
                    Task toDone = repo.GetById(doneId);
                    if (toDone != null) {
                        toDone.setStatus(Status.DONE);
                        repo.Update(toDone);
                        System.out.println("סומנה כ-DONE!");
                    } else {
                        System.out.println("לא נמצאה משימה עם ID זה.");
                    }
                    break;

                case 5:
                    System.out.print("ID לחיפוש: ");
                    String searchId = sc.nextLine();
                    Task found = repo.GetById(searchId);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("לא נמצאה משימה עם ID זה.");
                    }
                    break;

                case 6:
                    System.out.println("כל המשימות:");
                    for (Task task : repo.ListAll()) {
                        System.out.println(task);
                    }
                    break;

                case 0:
                    System.out.println("Exit. ביי!");
                    sc.close();
                    return;

                default:
                    System.out.println("בחירה לא חוקית.");
            }
        }
    }
}

