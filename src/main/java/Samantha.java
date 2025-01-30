import java.util.Scanner;
import java.util.ArrayList;
public class Samantha {
    public static void main(String[] args) throws SamanthaException {
        System.out.println("____________________________________________________________");
        System.out.println("    Hello! I'm Samantha");
        System.out.println("    What can I do for you?");
        System.out.println("____________________________________________________________");
        ArrayList<Task> tasks = new ArrayList<>();
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
                    System.out.println("    " + i + ". " + tasks.get(i-1));
                }
                System.out.println("____________________________________________________________");
            } else if (userCommand.startsWith("mark ")) {
                try {
                    int taskIndex = Integer.parseInt(userCommand.substring(5));
                    if (taskIndex - 1 < 0 || taskIndex - 1 >= taskSum) {
                        throw new SamanthaException("Invalid task number.");
                    }
                    tasks.get(taskIndex - 1).markAsDone();
                    System.out.println("____________________________________________________________");
                    System.out.println("    Nice! I've marked this task as done:");
                    System.out.println("       " + tasks.get(taskIndex - 1).toString());
                    System.out.println("____________________________________________________________");
                } catch (Exception e) {
                    throw new SamanthaException("Please enter a valid task number. Example: `mark 2`");
                }

            } else if (userCommand.startsWith("unmark ")) {
                try {
                    int taskIndex = Integer.parseInt(userCommand.substring(7));
                    if (taskIndex - 1 < 0 || taskIndex - 1 >= taskSum) {
                        throw new SamanthaException("Invalid task number.");
                    }
                    tasks.get(taskIndex - 1).markAsUndone();
                    System.out.println("____________________________________________________________");
                    System.out.println("    OK, I've marked this task as not done yet:");
                    System.out.println("       " + tasks.get(taskIndex - 1).toString());
                    System.out.println("____________________________________________________________" );
                } catch (Exception e) {
                    throw new SamanthaException("Please enter a valid task number. Example: `unmark 2`");
                }
            } else if (userCommand.startsWith("delete ")) {
                try {
                    int taskIndex = Integer.parseInt(userCommand.substring(7)) ;
                    if (taskIndex - 1 < 0 || taskIndex - 1 >= taskSum) {
                        throw new SamanthaException("Invalid task number.");
                    }

                    Task removedTask = tasks.remove(taskIndex - 1);
                    taskSum--;

                    System.out.println("____________________________________________________________");
                    System.out.println("    Noted. I've removed this task:");
                    System.out.println("      " + removedTask);
                    System.out.println("    Now you have " + taskSum + " tasks in the list.");
                    System.out.println("____________________________________________________________");
                } catch (NumberFormatException e) {
                    throw new SamanthaException("Please provide a valid task number. Example: `delete 2`");
                }
            } else if (userCommand.startsWith("todo ")) {
                if (userCommand.length() <= 5) {
                    throw new SamanthaException("Invalid Todo.");
                }
                if (taskSum >= 100) {
                    throw new SamanthaException("Task list is full.");
                }

                String description = userCommand.substring(5);
                tasks.add(taskSum, new Todo(description));
                taskSum++;

                System.out.println("____________________________________________________________");
                System.out.println("    Got it. I've added this task:");
                System.out.println("      " + tasks.get(taskSum - 1));
                System.out.println("    Now you have " + taskSum + " tasks in the list.");
                System.out.println("____________________________________________________________");
            } else if (userCommand.startsWith("deadline ")) {
                if (!userCommand.contains(" /by ")) {
                    throw new SamanthaException("Invalid deadline.");
                }
                if (taskSum >= 100) {
                    throw new SamanthaException("Task list is full.");
                }

                String[] parts = userCommand.substring(9).split(" /by ");
                tasks.add(taskSum, new Deadline(parts[0], parts[1]));
                taskSum++;

                System.out.println("____________________________________________________________");
                System.out.println("    Got it. I've added this task:");
                System.out.println("      " + tasks.get(taskSum - 1));
                System.out.println("    Now you have " + taskSum + " tasks in the list.");
                System.out.println("____________________________________________________________");
            } else if (userCommand.startsWith("event ")) {
                if (!userCommand.contains(" /from ") || !userCommand.contains(" /to ")) {
                    throw new SamanthaException("Invalid event.");
                }
                if (taskSum >= 100) {
                    throw new SamanthaException("Task list is full.");
                }

                String[] parts = userCommand.substring(6).split(" /from | /to ");
                tasks.add(taskSum, new Event(parts[0], parts[1], parts[2]));
                taskSum++;

                System.out.println("____________________________________________________________");
                System.out.println("    Got it. I've added this task:");
                System.out.println("      " + tasks.get(taskSum - 1));
                System.out.println("    Now you have " + taskSum + " tasks in the list.");
                System.out.println("____________________________________________________________");
            } else {
                if (taskSum > 99) {
                    System.out.println("    List is full.");
                }else {
                    tasks.add(taskSum , new Task(userCommand));
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
