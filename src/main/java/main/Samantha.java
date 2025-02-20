package main;
import storage.Storage;
import task.TaskList;
import ui.Ui;
import command.Parser;
import exception.SamanthaException;

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Main class for running the Samantha task management system.
 */
public class Samantha {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Initializes the Samantha system.
     *
     * @param filePath The path of the file used for task storage.
     */
    public Samantha(String filePath) {
        ui = new Ui();
        storage = new Storage();
        try {
            tasks = new TaskList(storage.loadTasks(filePath));
        } catch (Exception e) {
            ui.showError("Error when loading tasks.");
            tasks = new TaskList(new ArrayList<>());
        }
    }

    /**
     * Runs the main event loop for the Samantha system.
     */
    public void run() {
        ui.showWelcome();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String userCommand = ui.readCommand(scanner);
            if (userCommand.equals("bye")) {
                break;
            }
            try {
                System.out.println(Parser.parseCommand(userCommand, tasks, ui));
                storage.saveTasks("./data/samantha.txt", tasks.getTasks());
            } catch (SamanthaException e) {
                ui.showError(e.getMessage());
            }
        }

        ui.showGoodbye();
        scanner.close();
    }

    /**
     * The entry point of the Samantha application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        new Samantha("./data/samantha.txt").run();
    }

    /**
     * Generates a response for the user's chat message.
     */
    public String getResponse(String input){
        try {
            storage.saveTasks("./data/samantha.txt", tasks.getTasks());
            return Parser.parseCommand(input, tasks, ui);
        } catch (SamanthaException e) {
            return "[ERROR] " + e.getMessage();
        }
    }
}

