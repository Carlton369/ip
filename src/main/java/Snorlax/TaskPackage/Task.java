package Snorlax.TaskPackage;

import Snorlax.IOPackage.IO;

public class Task {
    public String description;
    public boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
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