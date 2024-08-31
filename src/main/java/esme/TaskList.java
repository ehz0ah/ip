package esme;

import esme.task.Deadline;
import esme.task.Event;
import esme.task.Task;
import esme.task.Todo;

import java.util.ArrayList;

/**
 * Represents a list that stores the current tasks added by the user
 */
public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<Task>();
    }

    public int numberOfTasks() {
        return tasks.size();
    }

    /**
     * Prints out the task list. The output will be in the format:
     * By the light of the moon, these are the tasks that guide your path:
     * <index>. [X] <task name>
     * <index>. [ ] <task name>
     * ...
     */
    public void printTaskList() {
        System.out.println("\tBy the light of the moon, these are the tasks that guide your path:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println("\t" + (i + 1) + "." + task);
        }
    }

    public String addTodoTask(String input) {
        String[] parts = input.split(" ", 2);
        tasks.add(new Todo(parts[1]));
        return parts[1];
    }

    public String addDeadlineTask(String input) {
        String[] parts = input.split(" /by ");
        String description = parts[0].replace("deadline ", "").trim();
        String by = parts[1].trim();
        tasks.add(new Deadline(description, by));
        return description;
    }

    public String addEventTask(String input) {
        String[] parts = input.split(" /from | /to ");
        String description = parts[0].replace("event ", "").trim();
        String from = parts[1].trim();
        String to = parts[2].trim();
        tasks.add(new Event(description, from, to));
        return description;
    }

    public void markTask(int taskIndex) {
        tasks.get(taskIndex).setCompleted(true);
    }

    public void unmarkTask(int taskIndex) {
        tasks.get(taskIndex).setCompleted(false);
    }

    public Task getTask(int taskIndex) {
        return tasks.get(taskIndex);
    }
}
