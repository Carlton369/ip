package Snorlax.TaskListPackage;

/**
 * Represents a Todo task with a description.
 */
public class Todo extends Task {

    /**
     * Constructs a Todo task with a given description.
     *
     * @param description The description of the task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the Todo task.
     *
     * @return A formatted string indicating the task type and status.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Formats the Todo task for file storage.
     *
     * @return A string representation suitable for saving to a file.
     */
    public String toFileFormat() {
        return super.toFileFormat() + "todo " + description;
    }
}
