package ExceptionsPackage;

import UtilityPackage.Utilities;

//default error
public class UnknownErrorException extends SnorlaxException {

    public void handle() {
        Utilities.printBorder();
        System.out.println("     Snorlax doesn't know what to do.......");
        Utilities.printBorder();
    }

}
