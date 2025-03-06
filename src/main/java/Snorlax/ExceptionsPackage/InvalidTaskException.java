package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

//when user gives a proper command but does not give give a description
public class InvalidTaskException extends SnorlaxException {

    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Invalid task.....");
        UI.printBorder();
    }
}
