package ExceptionsPackage;

import UtilityPackage.Utilities;

//when user gives a proper command but does not give give a description
public class InvalidTaskException extends SnorlaxException {

    @Override
    public void handle() {
        Utilities.printBorder();
        System.out.println("     Invalid task.....");
        Utilities.printBorder();
    }
}
