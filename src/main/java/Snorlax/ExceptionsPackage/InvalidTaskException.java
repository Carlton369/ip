package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

/**
 * Exception thrown when the taskDescription is not valid
 * This class extends {@code SnorlaxException} and provides a custom handler for the exception.
 *
 */
public class InvalidTaskException extends SnorlaxException {

    /**
     * Handles the exception by printing a message indicating the task is not valid.
     * The message is with borders
     *
     */
    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Invalid task.....");
        UI.printBorder();
    }
}
