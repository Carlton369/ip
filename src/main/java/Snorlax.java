import java.util.Scanner;
import Task.Task;
import Task.Deadline;

public class Snorlax {
    public static void printBorder(){
        System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
    }

    /**
     * Prints the introduction message for the Snorlax assistant.
     *
     * @param name The name of the assistant.
     */
    public static void printIntro(String name){
        printBorder();
        System.out.println("     Hello..... I'm " + name + ".....");
        System.out.println("     What can I do for you?");
        printBorder();
    }

    /**
     * Prints the corresponding error message with message borders
     *
     * @param error The type of error.
     */
    public static void printErrorMsg(String error){
        printBorder();
        switch(error){
        case "invalid task":
            System.out.println("     Invalid task number.....");
            break;
        case "no input":
            System.out.println("     Huh? Please type something.....");
            break;
        case "full list":
            System.out.println("     Sorry.... list is full.....");
            break;
        case "incomplete task":
            System.out.println("     Task is not done.....");
            break;
        case "completed task":
            System.out.println("     Task is already done.....");
            break;
        }
        printBorder();
    }

    public static void main(String[] args) {
        String name = "Snorlax";
        printIntro(name);

        String line;
        Scanner in = new Scanner(System.in);

        line = in.nextLine().trim();

        Task[] list = new Task[100];

        int count = 0;

        while (!line.equals("bye")){
            String[] splitLine = line.split(" ");
            switch (splitLine[0]) {
                case "list" -> {
                    Commands.List(list,count);
                }
                case "mark" -> {
                    if (splitLine.length < 2 || !splitLine[1].matches("\\d+")) {
                        printErrorMsg("invalid task");
                    } else {
                        int number = Integer.parseInt(splitLine[1]) - 1;
                        Commands.Mark(list, number, count);
                    }
                }
                case "unmark" -> {
                    if (splitLine.length < 2 || !splitLine[1].matches("\\d+")) {
                        printErrorMsg("invalid task");
                    } else {
                        int number = Integer.parseInt(splitLine[1]) - 1;
                        Commands.Unmark(list, number, count);
                    }
                }

                default -> {
                    if (line.isEmpty()) {
                        printErrorMsg("no input");
                    } else if (count < 100) {
                        printBorder();
                        System.out.println("     added: " + line + ".....");
                        printBorder();
                        list[count] = new Task(line);
                        count += 1;
                    } else {
                        printErrorMsg("full list");
                    }
                }
            }
            line = in.nextLine().trim();
        }
        printBorder();
        System.out.println("     Bye..... see you soon....");
        printBorder();
    }
}
