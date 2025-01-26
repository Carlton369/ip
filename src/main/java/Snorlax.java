import java.util.Scanner;
import java.util.Arrays;

public class Snorlax {
    public static void intro(String name){
        System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        System.out.println("    Hello..... I'm " + name + ".....");
        System.out.println("    What can I do for you?");
        System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
    }

    public static void main(String[] args) {
        String name = "Snorlax";
        intro(name);

        String line;
        Scanner in = new Scanner(System.in);

        line = in.nextLine();

        String[] list =new String[100];
        int count = 0;

        while (!line.equals("bye")){
            if (line.equals("list")){
                System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                for (int i = 0; i < count; i++) {
                    System.out.println("    " + (i + 1) + ":" + list[i] + ".....");
                }
                System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            } else {
                if (line.trim().isEmpty()) {
                    System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                    System.out.println("    Huh? Please type something.....");
                    System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                }
                 else if (count < 100) {
                    System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                    System.out.println("    added: " + line + ".....");
                    System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                    list[count] = line;
                    count += 1;
                } else {
                    System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                    System.out.println("    Sorry.... list is full.....");
                    System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
                }
            }
            line = in.nextLine();
        }
        System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        System.out.println("    Bye..... see you soon....");
        System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
    }
}
