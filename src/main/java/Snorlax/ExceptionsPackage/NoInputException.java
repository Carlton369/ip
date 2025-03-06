package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

/**
 * Exception thrown when the user provides an empty input
 * This class extends {@code SnorlaxException} and provides a custom handler for the exception.
 *
 */
public class NoInputException extends SnorlaxException {

    /**
     * Handles the exception by printing a message indicating there is no input.
     * The message is with borders
     *
     */
    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Huh? Please type something.....");
        UI.printBorder();
    }
}
