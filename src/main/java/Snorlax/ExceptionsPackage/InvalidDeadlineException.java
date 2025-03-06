package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

/**
 * Exception thrown when an attempt is made create a new Deadline Task without a deadline
 * This class extends {@code SnorlaxException} and provides a custom handler for the exception.
 *
 */
public class InvalidDeadlineException extends SnorlaxException {

    /**
     * Handles the exception by printing a message indicating the input deadline is invalid.
     * The message is with borders
     *
     */
    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Invalid deadline.....");
        UI.printBorder();
    }
}

