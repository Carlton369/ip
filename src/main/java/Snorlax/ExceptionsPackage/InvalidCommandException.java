package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

/**
 * Exception thrown when the user inputs an invalid command
 * This class extends {@code SnorlaxException} and provides a custom handler for the exception.
 *
 */
public class InvalidCommandException extends SnorlaxException {

    /**
     * Handles the exception by printing a message indicating the command is not valid.
     * The message is with borders
     *
     */
    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Please give a valid command.....");
        UI.printBorder();
    }
}
