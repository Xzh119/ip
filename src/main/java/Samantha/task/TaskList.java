package samantha.task;


import samantha.task.Task;
import samantha.exception.SamanthaException;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a list of tasks that can be modified by the user.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Creates a TaskList with an initial set of tasks.
     *
     * @param tasks The list of tasks.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Adds a task to the list.
     *
     * @param task The task to be added.
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Removes a task from the list by its index.
     *
     * @param index The index of the task to be removed.
     * @return The removed task.
     * @throws SamanthaException If the index is out of bounds.
     */
    public Task removeTask(int index) throws SamanthaException {
        if (index < 0 || index >= tasks.size()) {
            throw new SamanthaException("Invalid task number.");
        }
        return tasks.remove(index);
    }

    /**
     * Marks a task as done or undone.
     *
     * @param index The index of the task.
     * @param isDone True to mark as done, false to mark as undone.
     * @throws SamanthaException If the index is out of bounds.
     */
    public void markTask(int index, boolean isDone) throws SamanthaException {
        if (index < 0 || index >= tasks.size()) {
            throw new SamanthaException("Invalid task number.");
        }
        if (isDone) {
            tasks.get(index).markAsDone();
        } else {
            tasks.get(index).markAsUndone();
        }
    }

    /**
     * Returns the list of tasks as a formatted string.
     *
     * @return A string representation of the tasks.
     */
    public String listTasks() {
        if (tasks.isEmpty()) {
            return "List is empty.";
        }
        StringBuilder sb = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 0; i < tasks.size(); i++) {
            sb.append("    ").append(i + 1).append(". ").append(tasks.get(i)).append("\n");
        }
        return sb.toString();
    }

    /**
     * Retrieves a task by its index.
     *
     * @param index The index of the task.
     * @return The corresponding task.
     */
    public Task getTask(int index) {
        return tasks.get(index);
    }

    /**
     * Retrieves the last task in the list.
     *
     * @return The last task added.
     */
    public Task getLastTask() {
        return tasks.get(tasks.size() - 1);
    }

    /**
     * Returns the number of tasks in the list.
     *
     * @return The size of the task list.
     */
    public int getSize() {
        return tasks.size();
    }

    /**
     * Returns the full list of tasks.
     *
     * @return An ArrayList of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}