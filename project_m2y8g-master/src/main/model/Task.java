package model;

//Task class for a new task with taskName
public class Task {
    private String taskName;

    // REQUIRES: String name
    // MODIFIES: this
    // EFFECTS: creates new task with taskName
    public Task(String name) {
        this.taskName = name;
    }

    // REQUIRES: String taskName
    // EFFECTS: returns taskName
    public String getTaskName() {
        return taskName;
    }


}
