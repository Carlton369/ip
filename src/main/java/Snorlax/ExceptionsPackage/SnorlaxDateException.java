package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

public class SnorlaxDateException extends SnorlaxException {

    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Please input date as yyyy-MM-dd.....");
        UI.printBorder();
    }
}
