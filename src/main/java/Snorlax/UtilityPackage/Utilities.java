package Snorlax.UtilityPackage;

public class Utilities {
    public static void printBorder() {
        System.out.println("     zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
    }

    /**
     * Prints the introduction message for the Snorlax.UI.Snorlax assistant.
     *
     * @param name The name of the assistant.
     */
    public static void printIntro(String name) {
        printBorder();
        System.out.println("     Hello..... I'm " + name + ".....");
        System.out.println("     What can I do for you?");
        printBorder();
    }

    public static String strikethrough(String text) {
        return text.replaceAll(".", "$0̶"); // Adds a strikethrough effect
    }
}
