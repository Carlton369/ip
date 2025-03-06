package Snorlax.TaskListPackage;

import java.time.LocalDate;
public class Deadline extends Task {

    protected LocalDate by;

    public Deadline(String description, String by) {
        super(description);
        this.by = LocalDate.parse(by);
    }

    public LocalDate getBy(){
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + formatDate(by) + ")";
    }

    public String toFileFormat() {
        return super.toFileFormat() + "deadline " + description + "/by" + by;
    }
}