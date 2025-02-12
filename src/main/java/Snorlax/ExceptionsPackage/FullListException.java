package Snorlax.ExceptionsPackage;

import Snorlax.UtilityPackage.Utilities;

//when list is already full and a new task tries to get added in
public class FullListException extends SnorlaxException {

    @Override
    public void handle() {
        Utilities.printBorder();
        System.out.println("     Sorry.... list is full.....");
        Utilities.printBorder();
    }
}
