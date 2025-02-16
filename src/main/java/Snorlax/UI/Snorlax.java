package Snorlax.UI;

import java.util.Scanner;
import java.util.ArrayList;
import Snorlax.CommandsPackage.*;
import Snorlax.ExceptionsPackage.*;
import Snorlax.TaskPackage.*;
import Snorlax.UtilityPackage.*;

public class Snorlax {

    public static void main(String[] args) {
        String name = "Snorlax";
        Utilities.printIntro(name);

        String userInput;
        Scanner in = new Scanner(System.in);

        userInput = in.nextLine().trim();

        ArrayList<Task> list = new ArrayList<>();

        while (!userInput.equals("bye")) {
            try {
                String[] splitLine = userInput.split(" ", 2);
                //splits the userInput into the first word (command type) and the arguments
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
                    }
                }
                case "unmark" -> {
                    if (splitLine.length < 2 || !splitLine[1].matches("\\d+")) {
                        throw new InvalidTaskException();
                    } else {
                        int taskNumber = Integer.parseInt(splitLine[1]) - 1;
                        Commands.Unmark(list, taskNumber);
                    }
                }
                case "delete" -> {
                    if (splitLine.length < 2 || !splitLine[1].matches("\\d+")) {
                        throw new InvalidTaskException();
                    } else {
                        int taskNumber = Integer.parseInt(splitLine[1]) - 1;
                        Commands.Delete(list,taskNumber);
                    }
                }
                case "deadline" -> {
                    if (splitLine.length < 2) {
                        throw new InvalidTaskException();
                    } else if (list.size() >= 100) {
                        throw new FullListException();
                    } else {
                        Commands.Deadline(list, splitLine[1]);
                    }
                }
                case "todo" -> {
                    if (splitLine.length != 2) {
                        throw new InvalidTaskException();
                    } else if (list.size() >= 100) {
                        throw new FullListException();
                    } else {
                        Commands.Todo(list, splitLine[1]);
                    }
                }
                case "event" -> {
                    if (splitLine.length != 2) {
                        throw new InvalidTaskException();
                    } else if (list.size() >= 100) {
                        throw new FullListException();
                    } else {
                        Commands.Event(list, splitLine[1]);
                    }
                }
                default -> {
                    if (userInput.isEmpty()) {
                        throw new NoInputException();
                    } else {
                        throw new InvalidCommandException();
                    }
                }
                }
            }
            catch (SnorlaxException e) {
                e.handle();
            }
            userInput = in.nextLine().trim();
        }
        Utilities.printBorder();
        System.out.println("     Bye..... see you soon....");
        Utilities.printBorder();
    }
}
