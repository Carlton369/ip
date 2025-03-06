package Snorlax.CommandPackage;

import Snorlax.ParserPackage.IO;
import Snorlax.ExceptionsPackage.*;
import Snorlax.Snorlax;
import Snorlax.TaskListPackage.*;
import Snorlax.UIPackage.UI;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * This class represents the commands and handles the execution
 *
 * @author Yee Zhan Xian Carlton
 */
public class Commands {
    /**
     * Prints out all items in the list
     * If empty list, prints error message indicating empty list
     *
     * @param list list to be printed out
     */
    public static void List(ArrayList<Task> list) {
        UI.printBorder();
        if (list.isEmpty()) {
            System.out.println("     No tasks yet.....");
        } else {
            System.out.println("     Here are the tasks in the list:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println("     " + (i + 1) + ". " + list.get(i).toString());
            }
        }
        UI.printBorder();
    }
    /**
     * Marks a specified unmarked Task as done
     * Prints a message with borders to indicate the task has been marked
     * @param list list storing all tasks
     * @param taskNumber index of task to be marked
     * @throws NonexistentTaskException if taskNumber does not exist in list
     * @throws CompletedTaskException if specified task is already marked as done
     */
    public static void Mark(ArrayList<Task> list, int taskNumber) {
        if (taskNumber < 0 || taskNumber >= list.size()) {
            throw new NonexistentTaskException();
        } else if (list.get(taskNumber).isDone) {
            throw new CompletedTaskException();
        } else {
            list.get(taskNumber).markAsDone();

            UI.printBorder();
            System.out.println("     Ok..... I will mark this task as done.....");
            System.out.println("     " + list.get(taskNumber).toString());
            UI.printBorder();
        }
    }
    /**
     * Unmarks a specified already marked Task as not done
     * Prints a message with borders to indicate the task has been unmarked
     *
     * @param list list storing all tasks
     * @param taskNumber index of task to be unmarked
     * @throws NonexistentTaskException if taskNumber does not exist in list
     * @throws IncompleteTaskException if specified task is not marked as done
     */
    public static void Unmark(ArrayList<Task> list, int taskNumber) {
        if (taskNumber < 0 || taskNumber >= list.size()) {
            throw new NonexistentTaskException();
        } else if (!list.get(taskNumber).isDone) {
            throw new IncompleteTaskException();
        } else {
            list.get(taskNumber).unmarkAsDone();

            UI.printBorder();
            System.out.println("     Ok..... I will mark this task as not done yet.....");
            System.out.println("     " + list.get(taskNumber).toString());
            UI.printBorder();
        }
    }
    /**
     * Deletes a specified task in the list
     * Prints a message with borders to indicate the deleted task
     *
     * @param list  list storing all tasks
     * @param taskNumber index of task to be deleted
     * @throws NonexistentTaskException if taskNumber does not exist in list
     */
    public static void Delete(ArrayList<Task> list, int taskNumber) {
        if (taskNumber < 0 || taskNumber >= list.size()) {
            throw new NonexistentTaskException();
        } else {
            UI.printBorder();
            System.out.println("     Ok..... I will delete this task.....");
            String taskDescription = list.get(taskNumber).toString();
            System.out.println("     " + UI.strikethrough(taskDescription));
            UI.printBorder();

            list.remove(taskNumber);
        }
    }
    /**
     * Creates a new Deadline task in the list
     * Prints a message with borders to indicate the new Deadline task
     *
     * @param list list to store all tasks
     * @param taskDescription description of the task to be created
     * @throws InvalidDeadlineException if there is no deadline indicated
     */
    public static void Deadline(ArrayList<Task> list, String taskDescription) {

        try {
            String[] splitTaskDescription = taskDescription.split("/by");

            if (splitTaskDescription.length != 2) {
                throw new InvalidDeadlineException();
            }
            String taskAction = splitTaskDescription[0].trim();
            String deadlineBy = splitTaskDescription[1].trim();
            list.add(new Deadline(taskAction, deadlineBy));

        } catch (DateTimeParseException e) {
            throw new SnorlaxDateException();
        }

        UI.printBorder();
        System.out.println("     Ok..... I have added this \"deadline\" task.....");
        System.out.println("     " + list.get(list.size() - 1).toString());
        System.out.println("     You now have " + list.size() + " tasks in the list...");
        UI.printBorder();
    }
    /**
     * Creates a new Todo task in the list
     * Prints a message with borders to indicated the new Todo task
     *
     * @param list list to store all tasks
     * @param taskDescription description of the task to be created
     */
    public static void Todo(ArrayList<Task> list, String taskDescription) {
        list.add(new Todo(taskDescription));

        UI.printBorder();
        System.out.println("     Ok..... I have added this \"todo\" task.....");
        System.out.println("     " + list.get(list.size() - 1).toString());
        System.out.println("     You now have " + list.size() + " tasks in the list...");
        UI.printBorder();
    }
    /**
     * Creates a new Event task in the list
     * Prints a message with borders to indicated the new Event task
     *
     * @param list list to store all tasks
     * @param taskDescription description of the task to be created
     * @throws InvalidEventException if no description was given
     * @throws IndexOutOfBoundsException if description is missing a start or end date
     */
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
        } catch (DateTimeParseException e) {
            throw new SnorlaxDateException();
        }

        UI.printBorder();
        System.out.println("     Ok..... I have added this \"event\" task.....");
        System.out.println("     " + list.get(list.size() - 1).toString());
        System.out.println("     You now have " + list.size() + " tasks in the list...");
        UI.printBorder();
    }
    /**
     * Sets the isRunning boolean to false, causing program to exit
     *
     */
    public static void Exit(){
        IO.isRunning = false;
    }

    public static void CheckOnDate(ArrayList<Task> list, String inputDate) {
        try {
            UI.printBorder();
            System.out.println("     Here's what's going on.....");
            LocalDate date = LocalDate.parse(inputDate);
            for (Task task : list) {
                if (task instanceof Deadline) {
                    Deadline deadline = (Deadline) task;
                    if (deadline.getBy().isEqual(date)) {
                        System.out.println("     " + deadline);
                    }
                } else if (task instanceof Event) {
                    Event event = (Event) task;
                    LocalDate from = event.getFrom();
                    LocalDate to = event.getTo();
                    boolean isAfter = date.isAfter(from) || date.isEqual(from);
                    boolean isBefore = date.isBefore(to) || date.isEqual(to);
                    if (isAfter && isBefore) {
                        System.out.println("     " + event);
                    }
                }
            }
        } catch (DateTimeParseException e) {
            throw new SnorlaxDateException();
        } finally {
            UI.printBorder();
        }
    }

    public static void Find(ArrayList<Task> list, String toFindKey) {
        UI.printBorder();
        System.out.println("     Here are the related tasks:.....");
        for (Task task : list) {
            if (task.description.contains(toFindKey)) {
                System.out.println("     "  + task.toString());
            }
        }
    }
}
