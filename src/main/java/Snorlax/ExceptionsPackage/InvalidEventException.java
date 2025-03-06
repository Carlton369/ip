package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

//when user tries to make a new event but does not give a description, start time, or end time
public class InvalidEventException extends SnorlaxException {

    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Invalid event.....");
        UI.printBorder();
    }
}
