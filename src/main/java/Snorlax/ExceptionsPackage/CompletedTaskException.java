package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

//when user tries to mark an already completed task as done
public class CompletedTaskException extends SnorlaxException {

    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Task is already done.....");
        UI.printBorder();
    }
}
