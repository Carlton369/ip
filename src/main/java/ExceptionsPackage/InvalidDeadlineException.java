package ExceptionsPackage;

import UtilityPackage.Utilities;

public class InvalidDeadlineException extends SnorlaxException {

    @Override
    public void handle() {
        Utilities.printBorder();
        System.out.println("     Invalid deadline.....");
        Utilities.printBorder();
    }
}

