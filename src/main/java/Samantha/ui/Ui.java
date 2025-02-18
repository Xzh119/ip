package samantha.ui;
import java.util.Scanner;

/**
 * Handles user interactions.
 */
public class Ui {
    /** Displays a welcome message. */
    public void showWelcome() {
        System.out.println("____________________________________________________________");
        System.out.println("    Hello! I'm Samantha");
        System.out.println("    What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    /** Displays a goodbye message. */
    public void showGoodbye() {
        System.out.println("____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

    /** Displays a given message. */
    public void showMessage(String message) {
        System.out.println("____________________________________________________________");
        System.out.println(message);
        System.out.println("____________________________________________________________");
    }

    /** Reads user input from the given scanner. */
    public String readCommand(Scanner scanner) {
        return scanner.nextLine();
    }

    /** Displays an error message. */
    public void showError(String errorMessage) {
        System.out.println("[ERROR] " + errorMessage);
    }
}
