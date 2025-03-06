package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

/**
 * Exception thrown when an attempt is made to add more Tasks than the list can hold
 * This class extends {@code SnorlaxException} and provides a custom handler for the exception.
 *
 */
public class FullListException extends SnorlaxException {

    /**
     * Handles the exception by printing a message indicating the list is full.
     * The message is with borders
     *
     */
    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Sorry.... list is full.....");
        UI.printBorder();
    }
}
