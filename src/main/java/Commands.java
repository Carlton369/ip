import Task.Task;
import Task.Deadline;
import Task.Event;
import Task.Todo;


public class Commands {
    public static void List(Task[] list, int count){
        Snorlax.printBorder();
        if (count == 0) {
            System.out.println("     No tasks yet.....");
        } else {
            System.out.println("     Here are the tasks in the list:");
            for (int i = 0; i < count; i++) {
                System.out.println("     " + (i + 1) + ". " + list[i].toString());
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

    public static void Deadline(Task[]list, String taskDescription , int count){

        String[] splitTaskDescription = taskDescription.split("/by");

        String taskAction = splitTaskDescription[0].trim();
        String deadlineBy = splitTaskDescription[1].trim();

        if (splitTaskDescription.length != 2) {
            Snorlax.printErrorMsg("invalid task");
            return;
        }

        list[count] = new Deadline(taskAction,deadlineBy);
        //index 0 refers to the task, index 1 refers to the due date

        Snorlax.printBorder();
        System.out.println("     Ok..... I have added this \"deadline\" task.....");
        System.out.println("     " + list[count + 1].toString());
        System.out.println("     You now have " + count + " tasks in the list...");
        Snorlax.printBorder();
    }

    public static void Todo(Task[]list, String taskDescription, int count){
        list[count] = new Todo(taskDescription);

        Snorlax.printBorder();
        System.out.println("     Ok..... I have added this \"todo\" task.....");
        System.out.println("     " + list[count + 1].toString());
        System.out.println("     You now have " + count + " tasks in the list...");
        Snorlax.printBorder();
    }

    public static void Event(Task[]list, String taskDescription, int count){
        String[] splitDescription = taskDescription.split("/from",2);

        String eventDescription = splitDescription[0].trim();
        String[] eventTimeline = splitDescription[1].split("/to",2);
        String eventStart = eventTimeline[0].trim();
        String eventEnd = eventTimeline[1].trim();

        list[count] = new Event(eventDescription,eventStart, eventEnd);

        Snorlax.printBorder();
        System.out.println("     Ok..... I have added this \"event\" task.....");
        System.out.println("     " + list[count + 1].toString());
        System.out.println("     You now have " + count + " tasks in the list...");
        Snorlax.printBorder();
    }
}
