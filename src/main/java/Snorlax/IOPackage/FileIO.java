package Snorlax.IOPackage;

import java.io.*;
import Snorlax.TaskPackage.*;
import java.util.ArrayList;

public class FileIO {
    private static final String FILE_PATH = "./data/SnorlaxData.txt";

    public static void saveTasks(ArrayList<Task> tasks) {
        File file = new File(FILE_PATH);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Task task : tasks) {
                writer.write(task.toFileFormat());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    public static ArrayList<Task> loadTasks() {
        ArrayList<Task> list = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return list; // Return empty list if file doesn't exist
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String taskDescription = parts[1];
                boolean isDone = parts[0].equals("1");
                String[] splitTaskDescription = taskDescription.split(" ", 2);

                switch (splitTaskDescription[0]){
                case "todo" -> {
                    list.add(new Todo(splitTaskDescription[1]));
                    if (isDone) {list.get(list.size() - 1).markAsDone();}
                }
                case "deadline" -> {
                    String[] splitDeadlineDescription = taskDescription.split("/by");
                    list.add(new Deadline(splitDeadlineDescription[0], splitDeadlineDescription[1]));
                    if (isDone) {list.get(list.size() - 1).markAsDone();}
                }
                case "event" -> {
                    String[] splitEventDescription = taskDescription.split("/from");
                    String[] eventToFrom = splitEventDescription[1].split("/to");
                    list.add(new Event(splitEventDescription[0], eventToFrom[0], eventToFrom[1]));
                    if (isDone) {list.get(list.size() - 1).markAsDone();}
                }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return list;
    }
}
