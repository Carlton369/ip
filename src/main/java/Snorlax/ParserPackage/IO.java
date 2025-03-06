package Snorlax.ParserPackage;

import Snorlax.CommandPackage.Commands;
import Snorlax.ExceptionsPackage.*;
import Snorlax.StoragePackage.FileIO;
import Snorlax.TaskListPackage.*;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Scanner;


public class IO {

    public static boolean isRunning = true;

    public static String readCommand (){
        String userInput;
        Scanner in = new Scanner(System.in);
        userInput = in.nextLine().trim();
        return userInput;
    }

    public static String[] parseUserInput (String userInput){
        return userInput.split(" ", 2);
    }

    public static void handleInput (ArrayList<Task> list, String[] splitLine)  {
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
        case "bye" -> {
            Commands.Exit();
        }

        case "find" -> {
            if (splitLine.length != 2) {
                throw new InvalidTaskException();
            } else {
                Commands.Find(list, splitLine[1]);

        case "on" -> {
            if (splitLine.length != 2) {
                throw new InvalidTaskException();
            } else if (list.size() >= 100) {
                throw new FullListException();
            } else {
                Commands.CheckOnDate(list, splitLine[1]);;
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
