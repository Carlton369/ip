import java.util.Scanner;

import ExceptionsPackage.*;
import TaskPackage.*;
import UtilityPackage.Utilities;

public class Snorlax {

    /**
     * Prints the corresponding error message with message borders
     *
     * @param error The type of error.
     */
//    public static void printErrorMsg(String error) {
//        Utilities.printBorder();
//        switch (error) {
//        case "invalid task":
//            System.out.println("     Invalid task number.....");
//            break;
//        case "no input":
//            System.out.println("     Huh? Please type something.....");
//            break;
//        case "full list":
//            System.out.println("     Sorry.... list is full.....");
//            break;
//        case "incomplete task":
//            System.out.println("     Task is not done.....");
//            break;
//        case "completed task":
//            System.out.println("     Task is already done.....");
//            break;
//        case "invalid event":
//            System.out.println("     Invalid event.....");
//            break;
//        default:
//            System.out.println("     Snorlax doesn't know what to do.......");
//        }
//        Utilities.printBorder();
//    }

    public static void main(String[] args) {
        String name = "Snorlax";
        Utilities.printIntro(name);

        String userInput;
        Scanner in = new Scanner(System.in);

        userInput = in.nextLine().trim();

        Task[] list = new Task[100];

        int count = 0;

        while (!userInput.equals("bye")) {
            try {
                String[] splitLine = userInput.split(" ", 2);
                //splits the userInput into the first word (command type) and the arguments
                switch (splitLine[0].toLowerCase()) {
                case "list" -> {
                    Commands.List(list, count);
                }
                case "mark" -> {
                    if (splitLine.length < 2 || !splitLine[1].matches("\\d+")) {
                        throw new InvalidTaskException();
                    } else {
                        int taskNumber = Integer.parseInt(splitLine[1]) - 1;
                        Commands.Mark(list, taskNumber, count);
                    }
                }
                case "unmark" -> {
                    if (splitLine.length < 2 || !splitLine[1].matches("\\d+")) {
                        throw new InvalidTaskException();
                    } else {
                        int taskNumber = Integer.parseInt(splitLine[1]) - 1;
                        Commands.Unmark(list, taskNumber, count);
                    }
                }
                case "deadline" -> {
                    if (splitLine.length < 2) {
                        throw new InvalidTaskException();
                    } else if (count >= 100) {
                        throw new FullListException();
                    } else {
                        Commands.Deadline(list, splitLine[1], count);
                        count += 1;
                    }
                }
                case "todo" -> {
                    if (splitLine.length != 2) {
                        throw new InvalidTaskException();
                    } else if (count >= 100) {
                        throw new FullListException();
                    } else {
                        Commands.Todo(list, splitLine[1], count);
                        count += 1;
                    }
                }
                case "event" -> {
                    if (splitLine.length != 2) {
                        throw new InvalidTaskException();
                    } else if (count >= 100) {
                        throw new FullListException();
                    } else {
                        Commands.Event(list, splitLine[1], count);
                        count += 1;
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
