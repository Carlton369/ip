package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

/**
 * Exception thrown when an attempt is made to modify a Task that does not exist
 * This class extends {@code SnorlaxException} and provides a custom handler for the exception.
 *
 */
public class NonexistentTaskException extends SnorlaxException {

    /**
     * Handles the exception by printing a message indicating the task does not exist.
     * The message is with borders
     *
     */
    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Task does not exist.....");
        UI.printBorder();
    }
}
