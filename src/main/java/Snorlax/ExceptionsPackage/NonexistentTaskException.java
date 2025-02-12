package Snorlax.ExceptionsPackage;

import Snorlax.UtilityPackage.Utilities;


//when user tries to mark or unmark a nonexistent task
public class NonexistentTaskException extends SnorlaxException {

    @Override
    public void handle() {
        Utilities.printBorder();
        System.out.println("     Task does not exist.....");
        Utilities.printBorder();
    }
}
