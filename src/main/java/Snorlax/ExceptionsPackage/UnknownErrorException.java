package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

/**
 * Default Exception thrown when there is an exception that was unanticipated
 * This class extends {@code SnorlaxException} and provides a custom handler for the exception.
 *
 */
public class UnknownErrorException extends SnorlaxException {

    /**
     * Handles the exception by printing a message indicating the error was not expected
     * The message is with borders
     *
     */
    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Snorlax.Snorlax doesn't know what to do.......");
        UI.printBorder();
    }

}
