package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

//default error
public class UnknownErrorException extends SnorlaxException {

    public void handle() {
        UI.printBorder();
        System.out.println("     Snorlax.Snorlax doesn't know what to do.......");
        UI.printBorder();
    }

}
