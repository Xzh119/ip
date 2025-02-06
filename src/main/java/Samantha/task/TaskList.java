package samantha.task;


import samantha.task.Task;
import samantha.exception.SamanthaException;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task removeTask(int index) throws SamanthaException {
        if (index < 0 || index >= tasks.size()) {
            throw new SamanthaException("Invalid task number.");
        }
        return tasks.remove(index);
    }

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

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public Task getLastTask() {
        return tasks.get(tasks.size() - 1);
    }

    public int getSize() {
        return tasks.size();
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }
}