package Snorlax.IOPackage;

import Snorlax.CommandsPackage.*;
import Snorlax.ExceptionsPackage.*;
import Snorlax.TaskPackage.*;

import java.util.ArrayList;


public class IO {
    public static void handleInput (ArrayList<Task> list, String[] splitLine) {
        switch (splitLine[0].toLowerCase()) {
        case "list" -> {
            Commands.List(list);
        }
        case "mark" -> {
            if (splitLine.length < 2 || !splitLine[1].matches("\\d+")) {
                throw new InvalidTaskException();
            } else {
                int taskNumber = Integer.parseInt(splitLine[1]) - 1;
                Commands.Mark(list, taskNumber);
                FileIO.saveTasks(list);
            }
        }
        case "unmark" -> {
            if (splitLine.length < 2 || !splitLine[1].matches("\\d+")) {
                throw new InvalidTaskException();
            } else {
                int taskNumber = Integer.parseInt(splitLine[1]) - 1;
                Commands.Unmark(list, taskNumber);
                FileIO.saveTasks(list);
            }
        }
        case "delete" -> {
            if (splitLine.length < 2 || !splitLine[1].matches("\\d+")) {
                throw new InvalidTaskException();
            } else {
                int taskNumber = Integer.parseInt(splitLine[1]) - 1;
                Commands.Delete(list,taskNumber);
                FileIO.saveTasks(list);
            }
        }
        case "deadline" -> {
            if (splitLine.length < 2) {
                throw new InvalidTaskException();
            } else if (list.size() >= 100) {
                throw new FullListException();
            } else {
                Commands.Deadline(list, splitLine[1]);
                FileIO.saveTasks(list);
            }
        }
        case "todo" -> {
            if (splitLine.length != 2) {
                throw new InvalidTaskException();
            } else if (list.size() >= 100) {
                throw new FullListException();
            } else {
                Commands.Todo(list, splitLine[1]);
                FileIO.saveTasks(list);
            }
        }
        case "event" -> {
            if (splitLine.length != 2) {
                throw new InvalidTaskException();
            } else if (list.size() >= 100) {
                throw new FullListException();
            } else {
                Commands.Event(list, splitLine[1]);
                FileIO.saveTasks(list);
            }
        }
        default -> {
            if (splitLine[0].isEmpty()) {
                throw new NoInputException();
            } else {
                throw new InvalidCommandException();
            }
        }
        }
    }
}
