package Snorlax;

import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

import Snorlax.ParserPackage.IO;
import Snorlax.StoragePackage.*;
import Snorlax.ExceptionsPackage.*;
import Snorlax.TaskListPackage.*;
import Snorlax.UIPackage.*;

public class Snorlax {

    private ArrayList<Task> list;
    public static final String FILE_PATH = "./data/SnorlaxData.txt";

    public Snorlax() {
         list = FileIO.loadTasks();
    }

    public void run(){
        String name = "Snorlax";
        UI.printIntro(name);

        while (IO.isRunning) {
            try {
                String userInput = IO.readCommand();
                String[] parsedInput = IO.parseUserInput(userInput);
                IO.handleInput(list, parsedInput);
            }
            catch (SnorlaxException e) {
                e.handle();
            }
        }
        UI.printOutro();
    }
    public static void main(String[] args) {
        new Snorlax().run();
    }
}
