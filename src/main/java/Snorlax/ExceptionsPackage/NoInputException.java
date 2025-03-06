package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

//when user enters a blank input
public class NoInputException extends SnorlaxException {

    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Huh? Please type something.....");
        UI.printBorder();
    }
}
