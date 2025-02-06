import Task.Task;

public class Commands {
    public static void List(Task[] list, int count){
        Snorlax.printBorder();
        if (count == 0) {
            System.out.println("     No tasks yet.....");
        } else {
            System.out.println("     Here are the tasks in the list:");
            for (int i = 0; i < count; i++) {
                System.out.println("     " + (i + 1) + ":["
                        + list[i].getStatusIcon() + "] " + list[i].description + ".....");
            }
        }
        Snorlax.printBorder();
    }

    public static void Mark(Task[] list, int number, int count){
        if (number < 0 || number >= count) {
            Snorlax.printErrorMsg("invalid task");
        } else if (list[number].isDone) {
            Snorlax.printErrorMsg("completed task");
        } else {
            Snorlax.printBorder();
            System.out.println("     Ok..... I will mark this task as done.....");
            System.out.println("     [X] " + list[number].description + ".....");
            Snorlax.printBorder();
            list[number].markAsDone();
        }
    }

    public static void Unmark(Task[] list, int number, int count){
        if (number < 0 || number >= count) {
            Snorlax.printErrorMsg("invalid task");
        } else if (!list[number].isDone) {
            Snorlax.printErrorMsg("incomplete task");
        } else {
            Snorlax.printBorder();
            System.out.println("     Ok..... I will mark this task as not done yet.....");
            System.out.println("     [ ] " + list[number].description + ".....");
            Snorlax.printBorder();
            list[number].unmarkAsDone();
        }
    }

}
