package Snorlax.TaskListPackage;

/**
 * Represents a general task with a description and completion status.
 */
public class Task {

    /**
     * The description of the task.
     */
    public String description;

    /**
     * The completion status of the task.
     */
    public boolean isDone;

    /**
     * Constructs a new Task with a given description.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the status icon of the task.
     * "X" for completed tasks, " " for incomplete tasks.
     *
     * @return The status icon of the task.
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Unmarks the task as done (sets it to incomplete).
     */
    public void unmarkAsDone() {
        isDone = false;
    }

    /**
     * Formats the task for file storage.
     *
     * @return A string representation suitable for saving to a file.
     */
    public String toFileFormat() {
        return (isDone ? "1" : "0") + "|";
    }

    /**
     * Returns a string representation of the task.
     *
     * @return A formatted string indicating the status and description of the task.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
