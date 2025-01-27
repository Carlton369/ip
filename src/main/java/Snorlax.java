import java.util.Scanner;
import java.util.Arrays;

public class Snorlax {
    public static void intro(String name){
        System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        System.out.println("     Hello..... I'm " + name + ".....");
        System.out.println("     What can I do for you?");
        System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
    }

    public static class Task {
        protected String description;
        protected boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getStatusIcon() {
            return (isDone ? "X" : " "); // mark done task with X
        }

        public void markAsDone() {
            isDone = true;
        }

        public void unmarkAsDone() {
            isDone = false;
        }
    }

    public static void printErrorMsg(String error){
        System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
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
        System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
    }
    public static void main(String[] args) {
        String name = "Snorlax";
        intro(name);

        String line;
        Scanner in = new Scanner(System.in);

        line = in.nextLine().trim();

        Task[] list = new Task[100];

        int count = 0;

        while (!line.equals("bye")){
            String[] split_line = line.split(" ");
            if (line.equals("list")){
                System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                if (count == 0){
                    System.out.println("     No tasks yet.....");
                } else {
                    System.out.println("     Here are the tasks in the list:");
                    for (int i = 0; i < count; i++) {
                        System.out.println("     " + (i + 1) + ":[" + list[i].getStatusIcon() + "] " + list[i].description + ".....");
                    }
                }
                System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            }
            else if (split_line[0].equals("mark")){
                if (split_line.length < 2 || !split_line[1].matches("\\d+")) {
                    printErrorMsg("invalid task");
                } else {
                    int number = Integer.parseInt(split_line[1]) - 1;
                    if (number < 0 || number >= count) {
                        printErrorMsg("invalid task");
                    } else if (list[number].isDone) {
                        printErrorMsg("completed task");
                    } else {
                        System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                        System.out.println("     Ok..... I will mark this task as done.....");
                        System.out.println("     [X] " + list[number].description + ".....");
                        System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                        list[number].markAsDone();
                    }
                }
            }
            else if (split_line[0].equals("unmark")){
                if (split_line.length < 2 || !split_line[1].matches("\\d+")) {
                    printErrorMsg("invalid task");
                } else {
                    int number = Integer.parseInt(split_line[1]) - 1;
                    if (number < 0 || number >= count) {
                        printErrorMsg("invalid task");
                    } else if (!list[number].isDone) {
                        printErrorMsg("incomplete task");
                    } else {
                        System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                        System.out.println("     Ok..... I will mark this task as not done yet.....");
                        System.out.println("     [ ] " + list[number].description + ".....");
                        System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                        list[number].unmarkAsDone();
                    }
                }
            }
            else {
                if (line.isEmpty()) {
                    printErrorMsg("no input");
                }
                 else if (count < 100) {
                    System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                    System.out.println("     added: " + line + ".....");
                    System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                    list[count] = new Task(line);
                    count += 1;
                } else {
                    printErrorMsg("full list");
                }
            }
            line = in.nextLine().trim();
        }
        System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        System.out.println("     Bye..... see you soon....");
        System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
    }
}
