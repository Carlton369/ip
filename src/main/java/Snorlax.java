import java.util.Scanner;

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

        while (!line.equals("bye")){
            System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            System.out.println("    " + line + ".....");
            System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            line = in.nextLine();
        }
        System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
        System.out.println("    Bye..... see you soon....");
        System.out.println("    zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
    }
}
