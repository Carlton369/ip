package Snorlax;

import java.util.ArrayList;
import Snorlax.ParserPackage.IO;
import Snorlax.StoragePackage.FileIO;
import Snorlax.ExceptionsPackage.SnorlaxException;
import Snorlax.TaskListPackage.Task;
import Snorlax.UIPackage.UI;

/**
 * The main class for the Snorlax task manager.
 */
public class Snorlax {

    /**
     * List of tasks managed by Snorlax.
     */
    private ArrayList<Task> list;

    /**
     * The file path where tasks are stored.
     */
    public static final String FILE_PATH = "./data/SnorlaxData.txt";

    /**
     * Constructs a Snorlax instance and loads tasks from storage.
     */
    public Snorlax() {
        list = FileIO.loadTasks();
    }

    /**
     * Runs the Snorlax assistant, handling user input and task management.
     */
    public void run() {
        String name = "Snorlax";
        UI.printIntro(name);

        while (IO.isRunning) {
            try {
                String userInput = IO.readCommand();
                String[] parsedInput = IO.parseUserInput(userInput);
                IO.handleInput(list, parsedInput);
            } catch (SnorlaxException e) {
                e.handle();
            }
        }
        UI.printOutro();
    }

    /**
     * The main entry point for running the Snorlax assistant.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        new Snorlax().run();
    }
}
