package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

public class InvalidDeadlineException extends SnorlaxException {

    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Invalid deadline.....");
        UI.printBorder();
    }
}

