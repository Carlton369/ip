package Snorlax.TaskListPackage;

import java.time.LocalDate;
public class Task {
    public String description;
    public boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String formatDate(LocalDate date) {
        String day = String.valueOf(date.getDayOfMonth());
        String month = date.getMonth().toString();
        String year = String.valueOf(date.getYear());
        return day + "-" + month + "-" + year;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        isDone = true;
    }

    public void unmarkAsDone() {
        isDone = false;
    }

    public String toFileFormat() {
        return (isDone ? "1" : "0") + "|";
    }

    public String toString(){
        return "[" + getStatusIcon() + "] " + description;
    }
}