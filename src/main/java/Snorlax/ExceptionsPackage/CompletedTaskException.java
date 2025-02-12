package Snorlax.ExceptionsPackage;

import Snorlax.UtilityPackage.Utilities;

//when user tries to mark an already completed task as done
public class CompletedTaskException extends SnorlaxException {

    @Override
    public void handle() {
        Utilities.printBorder();
        System.out.println("     Task is already done.....");
        Utilities.printBorder();
    }
}
