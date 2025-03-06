package Snorlax.TaskListPackage;
import java.time.LocalDate;

public class Event extends Task {

    protected LocalDate from;
    protected LocalDate to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = LocalDate.parse(from);
        this.to = LocalDate.parse(to);
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + formatDate(from) + " to: " + formatDate(to) + ")";
    }

    public String toFileFormat() {
        return super.toFileFormat() + "event " + description + "/from" + from + "/to" + to;
    }
}