package Snorlax.ExceptionsPackage;

import Snorlax.UtilityPackage.Utilities;

//default error
public class UnknownErrorException extends SnorlaxException {

    public void handle() {
        Utilities.printBorder();
        System.out.println("     Snorlax.UI.Snorlax doesn't know what to do.......");
        Utilities.printBorder();
    }

}
