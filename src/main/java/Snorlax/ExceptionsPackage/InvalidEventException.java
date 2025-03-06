package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

/**
 * Exception thrown when an attempt is made to add an Event Task without a valid description, start, or end date
 * This class extends {@code SnorlaxException} and provides a custom handler for the exception.
 *
 */
public class InvalidEventException extends SnorlaxException {

    /**
     * Handles the exception by printing a message indicating the input description is invalid.
     * The message is with borders
     *
     */
    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Invalid event.....");
        UI.printBorder();
    }
}
