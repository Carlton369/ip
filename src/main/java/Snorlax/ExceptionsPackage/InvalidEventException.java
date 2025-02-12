package Snorlax.ExceptionsPackage;

import Snorlax.UtilityPackage.Utilities;

//when user tries to make a new event but does not give a description, start time, or end time
public class InvalidEventException extends SnorlaxException {

    @Override
    public void handle() {
        Utilities.printBorder();
        System.out.println("     Invalid event.....");
        Utilities.printBorder();
    }
}
