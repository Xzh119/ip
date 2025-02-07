package samantha.command;

import samantha.task.TaskList;
import samantha.task.Todo;
import samantha.task.Deadline;
import samantha.task.Event;
import samantha.task.Task;
import samantha.ui.Ui;
//import samantha.exception.SamanthaException;

public class Parser {
    public static void parseCommand(String command, TaskList tasks, Ui ui) throws SamanthaException {
        if (command.equals("list")) {
            ui.showMessage(tasks.listTasks());
        } else if (command.startsWith("mark ")) {
            int taskIndex = Integer.parseInt(command.substring(5)) - 1;
            tasks.markTask(taskIndex, true);
            ui.showMessage("Nice! I've marked this task as done:\n    " + tasks.getTask(taskIndex));
        } else if (command.startsWith("unmark ")) {
            int taskIndex = Integer.parseInt(command.substring(7)) - 1;
            tasks.markTask(taskIndex, false);
            ui.showMessage("OK, I've marked this task as not done yet:\n    " + tasks.getTask(taskIndex));
        } else if (command.startsWith("delete ")) {
            int taskIndex = Integer.parseInt(command.substring(7)) - 1;
            Task removedTask = tasks.removeTask(taskIndex);
            ui.showMessage("OK. I've removed this task:\n    " + removedTask + "\nNow you have " + tasks.getSize() + " tasks in the list.");
        } else if (command.startsWith("todo ")) {
            tasks.addTask(new Todo(command.substring(5)));
            ui.showMessage("Got it. I've added this task:\n    " + tasks.getLastTask() + "\nNow you have " + tasks.getSize() + " tasks in the list.");
        } else if (command.startsWith("deadline ")) {
            String[] parts = command.substring(9).split(" /by ");
            tasks.addTask(new Deadline(parts[0], parts[1]));
            ui.showMessage("Got it. I've added this task:\n    " + tasks.getLastTask() + "\nNow you have " + tasks.getSize() + " tasks in the list.");
        } else if (command.startsWith("event ")) {
            String[] parts = command.substring(6).split(" /from | /to ");
            tasks.addTask(new Event(parts[0], parts[1], parts[2]));
            ui.showMessage("Got it. I've added this task:\n    " + tasks.getLastTask() + "\nNow you have " + tasks.getSize() + " tasks in the list.");
        } else {
            throw new SamanthaException("I don't know what that means.");
        }
    }
}