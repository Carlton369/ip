package Snorlax.TaskListPackage;

/**
 * Represents an event task with a start and end time.
 */
public class Event extends Task {

    /**
     * The start time of the event.
     */
    protected String from;

    /**
     * The end time of the event.
     */
    protected String to;

    /**
     * Constructs an Event task with a description, start time, and end time.
     *
     * @param description The description of the event.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Returns a string representation of the event task.
     *
     * @return A formatted string indicating the task type, status, description, start time, and end time.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    /**
     * Formats the event task for file storage.
     *
     * @return A string representation suitable for saving to a file.
     */
    public String toFileFormat() {
        return super.toFileFormat() + "event " + description + "/from" + from + "/to" + to;
    }
}