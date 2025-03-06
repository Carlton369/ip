package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

//when user tries to unmark an uncompleted task
public class IncompleteTaskException extends SnorlaxException {

    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Task is not done.....");
        UI.printBorder();
    }
}
