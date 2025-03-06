package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

/**
 * Exception thrown when an attempt is made to parse a date in the wrong format
 * This class extends {@code SnorlaxException} and provides a custom handler for the exception.
 *
 */
public class SnorlaxDateException extends SnorlaxException {

    /**
     * Handles the exception by printing a message indicating the correct date input format.
     * The message is with borders
     *
     */
    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Please input date as yyyy-MM-dd.....");
        UI.printBorder();
    }
}
