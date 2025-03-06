package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

/**
 * Exception thrown when an attempt is made to mark an already completed task as done.
 * This class extends {@code SnorlaxException} and provides a custom handler for the exception.
 *
 */
public class CompletedTaskException extends SnorlaxException {

    /**
     * Handles the exception by printing a message indicating the task is already completed.
     * The message is with borders
     *
     */
    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Task is already done.....");
        UI.printBorder();
    }
}
