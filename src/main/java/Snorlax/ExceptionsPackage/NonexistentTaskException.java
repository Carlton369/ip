package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;


//when user tries to mark or unmark a nonexistent task
public class NonexistentTaskException extends SnorlaxException {

    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Task does not exist.....");
        UI.printBorder();
    }
}
