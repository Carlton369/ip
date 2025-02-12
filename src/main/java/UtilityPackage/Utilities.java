package UtilityPackage;

public class Utilities {
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

}
