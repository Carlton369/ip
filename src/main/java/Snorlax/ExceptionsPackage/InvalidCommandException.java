package Snorlax.ExceptionsPackage;

import Snorlax.UIPackage.UI;

//when user does not give a valid command
//valid commands: list, bye, mark, unmark, event, deadline, todo
public class InvalidCommandException extends SnorlaxException {

    @Override
    public void handle() {
        UI.printBorder();
        System.out.println("     Please give a valid command.....");
        UI.printBorder();
    }
}
