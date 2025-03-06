package Snorlax.TaskListPackage;

import java.time.LocalDate;

/**
 * Represents a task with a deadline.
 */
public class Deadline extends Task {

    /**
     * The deadline of the task.
     */
    protected LocalDate by;

    /**
     * Constructs a Deadline task with a description and deadline.
     *
     * @param description The description of the task.
     * @param by The deadline of the task.
     */
    public Deadline(String description, String by) {
        super(description);
        this.by = LocalDate.parse(by);
    }

    public LocalDate getBy(){
        return by;
    }

    /**
     * Returns a string representation of the deadline task.
     *
     * @return A formatted string indicating the task type, status, description, and deadline.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + formatDate(by) + ")";
    }

    /**
     * Formats the deadline task for file storage.
     *
     * @return A string representation suitable for saving to a file.
     */
    public String toFileFormat() {
        return super.toFileFormat() + "deadline " + description + "/by" + by;
    }
}
