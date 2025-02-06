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
                        + list[i].getStatusIcon() + "] " + list[i].description);
            }
        }
        Snorlax.printBorder();
    }

    public static void Mark(Task[] list, int taskNumber, int count){
        if (taskNumber < 0 || taskNumber >= count) {
            Snorlax.printErrorMsg("invalid task");
        } else if (list[taskNumber].isDone) {
            Snorlax.printErrorMsg("completed task");
        } else {
            Snorlax.printBorder();
            System.out.println("     Ok..... I will mark this task as done.....");
            System.out.println("     [X] " + list[taskNumber].description);
            Snorlax.printBorder();
            list[taskNumber].markAsDone();
        }
    }

    public static void Unmark(Task[] list, int taskNumber, int count){
        if (taskNumber < 0 || taskNumber >= count) {
            Snorlax.printErrorMsg("invalid task");
        } else if (!list[taskNumber].isDone) {
            Snorlax.printErrorMsg("incomplete task");
        } else {
            Snorlax.printBorder();
            System.out.println("     Ok..... I will mark this task as not done yet.....");
            System.out.println("     [ ] " + list[taskNumber].description);
            Snorlax.printBorder();
            list[taskNumber].unmarkAsDone();
        }
    }

    public static void Todo(Task[]list, int taskNumber, int count){
        if (taskNumber < 0 || taskNumber >= count) {
            Snorlax.printErrorMsg("invalid task");
        } else if (!list[taskNumber].isDone) {
            Snorlax.printErrorMsg("incomplete task");
        } else {
            Snorlax.printBorder();
            System.out.println("     Ok..... I have added this task.....");
            System.out.println("     [T][ ]" + list[taskNumber].description);
            Snorlax.printBorder();
            list[taskNumber].unmarkAsDone();
        }
    }

}
