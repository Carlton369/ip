package Snorlax.CommandsPackage;

import Snorlax.ExceptionsPackage.*;
import Snorlax.TaskPackage.*;
import Snorlax.UtilityPackage.Utilities;


public class Commands {
    public static void List(Task[] list, int count){
        Utilities.printBorder();
        if (count == 0) {
            System.out.println("     No tasks yet.....");
        } else {
            System.out.println("     Here are the tasks in the list:");
            for (int i = 0; i < count; i++) {
                System.out.println("     " + (i + 1) + ". " + list[i].toString());
            }
        }
        Utilities.printBorder();
    }

    public static void Mark(Task[] list, int taskNumber, int count){
        if (taskNumber < 0 || taskNumber >= count) {
            throw new NonexistentTaskException();
        } else if (list[taskNumber].isDone) {
            throw new CompletedTaskException();
        } else {
            Utilities.printBorder();
            System.out.println("     Ok..... I will mark this task as done.....");
            System.out.println("     [X] " + list[taskNumber].description);
            Utilities.printBorder();
            list[taskNumber].markAsDone();
        }
    }

    public static void Unmark(Task[] list, int taskNumber, int count){
        if (taskNumber < 0 || taskNumber >= count) {
            throw new NonexistentTaskException();
        } else if (!list[taskNumber].isDone) {
            throw new IncompleteTaskException();
        } else {
            Utilities.printBorder();
            System.out.println("     Ok..... I will mark this task as not done yet.....");
            System.out.println("     [ ] " + list[taskNumber].description);
            Utilities.printBorder();
            list[taskNumber].unmarkAsDone();
        }
    }

    public static void Deadline(Task[]list, String taskDescription , int count){

        String[] splitTaskDescription = taskDescription.split("/by");

        if (splitTaskDescription.length != 2) {
            throw new InvalidDeadlineException();
        }

        String taskAction = splitTaskDescription[0].trim();
        String deadlineBy = splitTaskDescription[1].trim();


        list[count] = new Deadline(taskAction,deadlineBy);
        //index 0 refers to the task, index 1 refers to the due date

        Utilities.printBorder();
        System.out.println("     Ok..... I have added this \"deadline\" task.....");
        System.out.println("     " + list[count].toString());
        System.out.println("     You now have " + (count + 1) + " tasks in the list...");
        Utilities.printBorder();
    }

    public static void Todo(Task[]list, String taskDescription, int count){
        list[count] = new Todo(taskDescription);

        Utilities.printBorder();
        System.out.println("     Ok..... I have added this \"todo\" task.....");
        System.out.println("     " + list[count].toString());
        System.out.println("     You now have " + (count + 1) + " tasks in the list...");
        Utilities.printBorder();
    }

    public static void Event(Task[]list, String taskDescription, int count){
        try {
            String[] splitDescription = taskDescription.split("/from",2);
            String eventDescription = splitDescription[0].trim();
            String[] eventTimeline = splitDescription[1].split("/to", 2);

            String eventStart = eventTimeline[0].trim();
            String eventEnd = eventTimeline[1].trim();

            if (eventDescription.isEmpty()) {
                throw new InvalidEventException();
            }
            list[count] = new Event(eventDescription,eventStart, eventEnd);

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidEventException();
        }

        Utilities.printBorder();
        System.out.println("     Ok..... I have added this \"event\" task.....");
        System.out.println("     " + list[count].toString());
        System.out.println("     You now have " + (count + 1) + " tasks in the list...");
        Utilities.printBorder();
    }
}
