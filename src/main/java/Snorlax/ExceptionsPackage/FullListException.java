package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

//when list is already full and a new task tries to get added in
public class FullListException extends SnorlaxException {

    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Sorry.... list is full.....");
        UI.printBorder();
    }
}
