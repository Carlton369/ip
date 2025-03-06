package Snorlax.UIPackage;

/**
 * Handles user interface functionalities for the Snorlax assistant.
 */
public class UI {

    /**
     * Prints a border line to separate messages.
     */
    public static void printBorder() {
        System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
    }

    /**
     * Prints the introduction message for the Snorlax assistant.
     *
     * @param name The name of the assistant.
     */
    public static void printIntro(String name) {
        printBorder();
        System.out.println("     Hello..... I'm " + name + ".....");
        System.out.println("     What can I do for you?");
        printBorder();
    }

    /**
     * Prints the outro message when exiting the Snorlax assistant.
     */
    public static void printOutro() {
        UI.printBorder();
        System.out.println("     Bye..... see you soon....");
        UI.printBorder();
    }
}