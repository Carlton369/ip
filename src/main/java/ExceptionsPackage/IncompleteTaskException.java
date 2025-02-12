package ExceptionsPackage;

import UtilityPackage.Utilities;

//when user tries to unmark an uncompleted task
public class IncompleteTaskException extends SnorlaxException {

    @Override
    public void handle() {
        Utilities.printBorder();
        System.out.println("     Task is not done.....");
        Utilities.printBorder();
    }
}
