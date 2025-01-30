import java.util.Scanner;

public class Samantha {
    public static void main(String[] args) {
        System.out.println("____________________________________________________________");
        System.out.println("    Hello! I'm Samantha");
        System.out.println("    What can I do for you?");
        System.out.println("____________________________________________________________");
        Task[] tasks = new Task[100];
        int taskSum = 0;
        Scanner scanner = new Scanner(System.in);
        String userCommand = scanner.nextLine();
        while (!userCommand.equals("bye")) {
            if (userCommand.equals("list")) {
                System.out.println("____________________________________________________________");
                if (taskSum == 0) {
                    System.out.println("    List is empty.");
                }
                System.out.println("    Here are the tasks in your list:");
                for (int i = 1; i <= taskSum; i++) {
                    System.out.println("    " + i + ". " + tasks[i-1]);
                }
                System.out.println("____________________________________________________________");
            } else if (userCommand.startsWith("mark ")) {
                int taskIndex = Integer.parseInt(userCommand.substring(5));
                tasks[taskIndex - 1].markAsDone();

                System.out.println("____________________________________________________________");
                System.out.println("    Nice! I've marked this task as done:");
                System.out.println("       " + tasks[taskIndex - 1].toString());
                System.out.println("____________________________________________________________");
            } else if (userCommand.startsWith("unmark ")) {
                int taskIndex = Integer.parseInt(userCommand.substring(7));
                tasks[taskIndex - 1].markAsUndone();

                System.out.println("____________________________________________________________");
                System.out.println("    OK, I've marked this task as not done yet:");
                System.out.println("       " + tasks[taskIndex - 1].toString());
                System.out.println("____________________________________________________________");
            } else if (userCommand.startsWith("todo ")) {
                String description = userCommand.substring(5);
                tasks[taskSum] = new Todo(description);
                taskSum++;
                System.out.println("    Got it. I've added this task:");
                System.out.println("      " + tasks[taskSum - 1]);
                System.out.println("    Now you have " + taskSum + " tasks in the list.");
            } else if (userCommand.startsWith("deadline ")) {
                String[] parts = userCommand.substring(9).split(" /by ");
                tasks[taskSum] = new Deadline(parts[0], parts[1]);
                taskSum++;
                System.out.println("    Got it. I've added this task:");
                System.out.println("      " + tasks[taskSum - 1]);
                System.out.println("    Now you have " + taskSum + " tasks in the list.");
            } else if (userCommand.startsWith("event ")) {
                String[] parts = userCommand.substring(6).split(" /from | /to ");
                tasks[taskSum] = new Event(parts[0], parts[1], parts[2]);
                taskSum++;
                System.out.println("    Got it. I've added this task:");
                System.out.println("      " + tasks[taskSum - 1]);
                System.out.println("    Now you have " + taskSum + " tasks in the list.");
            } else {
                if (taskSum > 99) {
                    System.out.println("    List is full.");
                }else {
                    tasks[taskSum] = new Task(userCommand);
                    taskSum++;
                    System.out.println("____________________________________________________________");
                    System.out.println("    added: " + userCommand);
                    System.out.println("____________________________________________________________");
                }
            }
            userCommand = scanner.nextLine();
        }
        scanner.close();
        System.out.println("____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
