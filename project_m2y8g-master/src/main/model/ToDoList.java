package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

// A ToDoList program
// Keeps track of userTasks and completedTasks
public class ToDoList {
    private static ArrayList<Task> completedTasks = new ArrayList<>();
    private static ArrayList<Task> userTasks = new ArrayList<>();

    // REQUIRES: Integer num
    // EFFECTS: returns the task in the num position in userTasks
    public static String getTask(Integer num) {
        return userTasks.get(num).getTaskName();
    }

    // REQUIRES: Integer num
    // EFFECTS: returns the completed task in the num position in completedTasks
    public static String getCompletedTask(Integer num) {
        return completedTasks.get(num).getTaskName();
    }

    // REQUIRES: String task
    // MODIFIES: this
    // EFFECTS: adds String/Task to userTasks
    public static void addTask(Task task) {
        userTasks.add(task);
    }

    // REQUIRES: Integer taskNumber
    // MODIFIES: this
    // EFFECTS: adds the task that is in position taskNumber in userTasks array to completedTasks
    //          removes the task from the userTasks array
    public static void markCompleted(Integer taskNumber) throws Exception {
        if (userTasks.size() == 0) {
            throw new Exception("CANNOT MARK AS COMPLETE EMPTY LIST");
        } else {
            completedTasks.add(userTasks.get((taskNumber)));
            userTasks.remove(userTasks.get((taskNumber)));
        }
    }

    // REQUIRES: String task
    // EFFECTS: returns true if completedTasks array contains the task
    //          - returns false if completedTasks array does not contain the task
    public static boolean containsCompleted(Task task) {
        return completedTasks.contains(task);
    }

    // REQUIRES: String task
    // EFFECTS: returns true if userTasks array contains the task
    //          - returns false if userTasks array does not contain the task
    public static boolean containsTask(Task task) {
        return userTasks.contains(task);
    }

    // EFFECTS: returns the userTasks array
    public static ArrayList<Task> returnUserTasks() {
        return userTasks;
    }

    // EFFECTS: returns the completedTasks array
    public static ArrayList<Task> returnCompletedTasks() {
        return completedTasks;
    }


}


