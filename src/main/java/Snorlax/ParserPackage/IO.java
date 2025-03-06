package Snorlax.ParserPackage;

import Snorlax.CommandPackage.Commands;
import Snorlax.ExceptionsPackage.*;
import Snorlax.StoragePackage.FileIO;
import Snorlax.TaskListPackage.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The IO class handles user input and command parsing for the Snorlax task manager.
 */
public class IO {

    /**
     * Boolean flag to indicate if the program is running.
     */
    public static boolean isRunning = true;

    /**
     * Reads a command from the user.
     *
     * @return The trimmed user input as a string.
     */
    public static String readCommand() {
        String userInput;
        Scanner in = new Scanner(System.in);
        userInput = in.nextLine().trim();
        return userInput;
    }

    /**
     * Parses the user input into command and arguments.
     *
     * @param userInput The full user input string.
     * @return An array where the first element is the command and the second element (if any) is the argument.
     */
    public static String[] parseUserInput(String userInput) {
        return userInput.split(" ", 2);
    }

    /**
     * Handles the parsed user input and executes the corresponding command.
     *
     * @param list      The list of tasks.
     * @param splitLine The parsed user input.
     * @throws InvalidTaskException    If the task number is missing or invalid.
     * @throws FullListException       If the task list is full (100 tasks limit).
     * @throws NoInputException        If no input is provided.
     * @throws InvalidCommandException If an unrecognized command is entered.
     */
    public static void handleInput(ArrayList<Task> list, String[] splitLine) {
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
                Commands.Delete(list, taskNumber);
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
