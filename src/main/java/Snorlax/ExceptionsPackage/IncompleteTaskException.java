package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

/**
 * Exception thrown when an attempt is made to unmark a Task that is not yet marked
 * This class extends {@code SnorlaxException} and provides a custom handler for the exception.
 *
 */
public class IncompleteTaskException extends SnorlaxException {

    /**
     * Handles the exception by printing a message indicating the task is has not been completed.
     * The message is with borders
     *
     */
    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Task is not done.....");
        UI.printBorder();
    }
}
