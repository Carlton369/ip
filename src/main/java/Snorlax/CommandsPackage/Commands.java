package Snorlax.CommandsPackage;

import Snorlax.ExceptionsPackage.*;
import Snorlax.TaskPackage.*;
import Snorlax.UtilityPackage.Utilities;
import java.util.ArrayList;

public class Commands {
    public static void List(ArrayList<Task> list) {
        Utilities.printBorder();
        if (list.isEmpty()) {
            System.out.println("     No tasks yet.....");
        } else {
            System.out.println("     Here are the tasks in the list:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println("     " + (i + 1) + ". " + list.get(i).toString());
            }
        }
        Utilities.printBorder();
    }

    public static void Mark(ArrayList<Task> list, int taskNumber) {
        if (taskNumber < 0 || taskNumber >= list.size()) {
            throw new NonexistentTaskException();
        } else if (list.get(taskNumber).isDone) {
            throw new CompletedTaskException();
        } else {
            list.get(taskNumber).markAsDone();

            Utilities.printBorder();
            System.out.println("     Ok..... I will mark this task as done.....");
            System.out.println("     " + list.get(taskNumber).toString());
            Utilities.printBorder();
        }
    }

    public static void Unmark(ArrayList<Task> list, int taskNumber) {
        if (taskNumber < 0 || taskNumber >= list.size()) {
            throw new NonexistentTaskException();
        } else if (!list.get(taskNumber).isDone) {
            throw new IncompleteTaskException();
        } else {
            list.get(taskNumber).unmarkAsDone();

            Utilities.printBorder();
            System.out.println("     Ok..... I will mark this task as not done yet.....");
            System.out.println("     " + list.get(taskNumber).toString());
            Utilities.printBorder();
        }
    }

    public static void Delete(ArrayList<Task> list, int taskNumber) {
        if (taskNumber < 0 || taskNumber >= list.size()) {
            throw new NonexistentTaskException();
        } else {
            Utilities.printBorder();
            System.out.println("     Ok..... I will delete this task.....");
            String taskDescription = list.get(taskNumber).toString();
            System.out.println("     " + Utilities.strikethrough(taskDescription));
            Utilities.printBorder();

            list.remove(taskNumber);
        }
    }

    public static void Deadline(ArrayList<Task> list, String taskDescription) {
        String[] splitTaskDescription = taskDescription.split("/by");

        if (splitTaskDescription.length != 2) {
            throw new InvalidDeadlineException();
        }

        String taskAction = splitTaskDescription[0].trim();
        String deadlineBy = splitTaskDescription[1].trim();

        list.add(new Deadline(taskAction, deadlineBy));

        Utilities.printBorder();
        System.out.println("     Ok..... I have added this \"deadline\" task.....");
        System.out.println("     " + list.get(list.size() - 1).toString());
        System.out.println("     You now have " + list.size() + " tasks in the list...");
        Utilities.printBorder();
    }

    public static void Todo(ArrayList<Task> list, String taskDescription) {
        list.add(new Todo(taskDescription));

        Utilities.printBorder();
        System.out.println("     Ok..... I have added this \"todo\" task.....");
        System.out.println("     " + list.get(list.size() - 1).toString());
        System.out.println("     You now have " + list.size() + " tasks in the list...");
        Utilities.printBorder();
    }

    public static void Event(ArrayList<Task> list, String taskDescription) {
        try {
            String[] splitDescription = taskDescription.split("/from", 2);
            String eventDescription = splitDescription[0].trim();
            String[] eventTimeline = splitDescription[1].split("/to", 2);

            String eventStart = eventTimeline[0].trim();
            String eventEnd = eventTimeline[1].trim();

            if (eventDescription.isEmpty()) {
                throw new InvalidEventException();
            }
            list.add(new Event(eventDescription, eventStart, eventEnd));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new InvalidEventException();
        }

        Utilities.printBorder();
        System.out.println("     Ok..... I have added this \"event\" task.....");
        System.out.println("     " + list.get(list.size() - 1).toString());
        System.out.println("     You now have " + list.size() + " tasks in the list...");
        Utilities.printBorder();
    }

}
