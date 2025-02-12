package Snorlax.ExceptionsPackage;

import Snorlax.UtilityPackage.Utilities;

//when user enters a blank input
public class NoInputException extends SnorlaxException {

    @Override
    public void handle() {
        Utilities.printBorder();
        System.out.println("     Huh? Please type something.....");
        Utilities.printBorder();
    }
}
