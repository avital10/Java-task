import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Creates an instance of TaskRepository to store and manage tasks
        TaskRepository repo = new TaskRepository();
        //   Starts an infinite loop to repeatedly display the menu until the user exits.
        while (true) {
            //Menu for selecting actions

            System.out.println("choose task");
            System.out.println("1 add task");
            System.out.println("2 update task");
            System.out.println("3 delete task");
            System.out.println("4  mark as DONE");
            System.out.println("5 search by id");
            System.out.println("6  all tasks");
            System.out.println("0 exit ");
            System.out.print("select option: ");

            int choice = scan.nextInt();
            scan.nextLine();
            //Prints the task menu options to the console.

            switch (choice) {
                //Handles the user’s choice and executes the corresponding action
                case 1:
                    //prompts for ID, title, and description, then creates and adds a new task with status new
                    System.out.print("ID: ");
                    String id = scan.nextLine();
                    System.out.print("Title: ");
                    String title = scan.nextLine();
                    System.out.print("Description: ");
                    String desc = scan.nextLine();
                    Task t = new Task(id, title, desc, Status.NEW);
                    repo.Add(t);
                    System.out.println("Task added successfully");
                    break;

                case 2:
                    //prompts for task ID and allows updating its title and description if it exists
                    String updateId = scan.nextLine();
                    Task toUpdate = repo.GetById(updateId);
                    if (toUpdate != null) {
                        System.out.print("new title : ");
                        toUpdate.setTitle(scan.nextLine());
                        System.out.print(" new description : ");
                        toUpdate.setDescription(scan.nextLine());
                        repo.Update(toUpdate);
                        System.out.println("task update");
                    } else {
                        System.out.println("no task found with this id.");
                    }
                    break;

                case 3:
                    //prompts for task ID and removes the task from the repository if found
                    System.out.print("id of the task to delete: ");
                    String deleteId = scan.nextLine();
                    Task toDelete = repo.GetById(deleteId);
                    if (toDelete != null) {
                        repo.Delete(toDelete);
                        System.out.println("task delete");
                    } else {
                        System.out.println("no task found with this id");
                    }
                    break;

                case 4:
                    //prompts for task ID and sets its status to DONE if it exists
                    System.out.print("task id to mark as DONE: ");
                    String doneId = scan.nextLine();
                    Task toDone = repo.GetById(doneId);
                    if (toDone != null) {
                        toDone.setStatus(Status.DONE);
                        repo.Update(toDone);
                        System.out.println("marked as done");
                    } else {
                        System.out.println("no task with such id found.");
                    }
                    break;

                case 5:
                    //prompts for task ID and displays the task details if found
                    System.out.print("search id ");
                    String searchId = scan.nextLine();
                    Task found = repo.GetById(searchId);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("no task with such id found.");
                    }
                    break;

                case 6:
                    //prints all tasks currently in the repository
                    System.out.println("all tasks:");
                    for (Task task : repo.ListAll()) {
                        System.out.println(task);
                    }
                    break;

                case 0:
                    //exits the program
                    System.out.println("exit");
                    scan.close();
                    return;

                default:
                    //handles invalid menu choices by showing an error message
                    System.out.println("wrong choose.");
            }
        }
    }
}

