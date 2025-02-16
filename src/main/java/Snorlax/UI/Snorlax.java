package Snorlax.UI;

import java.util.Scanner;
import java.util.ArrayList;

import Snorlax.IOPackage.*;
import Snorlax.CommandsPackage.*;
import Snorlax.ExceptionsPackage.*;
import Snorlax.TaskPackage.*;
import Snorlax.UtilityPackage.*;

public class Snorlax {

    public static void main(String[] args) {
        String name = "Snorlax";
        Utilities.printIntro(name);

        String userInput;
        Scanner in = new Scanner(System.in);

        userInput = in.nextLine().trim();

        ArrayList<Task> list = FileIO.loadTasks();

        while (!userInput.equals("bye")) {
            try {
                String[] splitLine = userInput.split(" ", 2);
                //splits the userInput into the first word (command type) and the arguments
                IO.handleInput(list, splitLine);
            }
            catch (SnorlaxException e) {
                e.handle();
            }
            userInput = in.nextLine().trim();
        }
        Utilities.printBorder();
        System.out.println("     Bye..... see you soon....");
        Utilities.printBorder();
    }
}
