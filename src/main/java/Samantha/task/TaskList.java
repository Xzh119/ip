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

    /**
     * Finds tasks that contain the specified keyword.
     *
     * @param keyword The keyword to search for.
     * @return A string containing matching tasks.
     */
    public String findTasks(String keyword) {
        ArrayList<String> matchingTasks = new ArrayList<>();
        matchingTasks.add("Here are the matching tasks in your list:");

        int count = 0;
        for (Task task : tasks) {
            if (task.toString().contains(keyword)) {
                count++;
                matchingTasks.add("    " + count + ". " + task);
            }
        }

        return count == 0 ? "Fail to find matching tasks." : String.join("\n", matchingTasks);
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