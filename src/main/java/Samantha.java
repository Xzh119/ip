import java.util.Scanner;

public class Samantha {
    public static void main(String[] args) {
        System.out.println("____________________________________________________________");
        System.out.println("    Hello! I'm Samantha");
        System.out.println("    What can I do for you?");
        System.out.println("____________________________________________________________");
        String[] tasks = new String[100];
        int taskSum = 0;
        Scanner scanner = new Scanner(System.in);
        String userCommand = scanner.nextLine();
        while (!userCommand.equals("bye")) {
            /*System.out.println("____________________________________________________________");
            System.out.println("    " + userCommand);
            System.out.println("____________________________________________________________");*/
            if (!userCommand.equals("list")) {
                if (taskSum > 99) {
                    System.out.println("    List is full.");
                }else {
                    tasks[taskSum] = userCommand;
                    taskSum++;
                    System.out.println("____________________________________________________________");
                    System.out.println("    added: " + userCommand);
                    System.out.println("____________________________________________________________");
                }
            } else {
                System.out.println("____________________________________________________________");
                if (taskSum == 0) {
                    System.out.println("    List is empty.");
                }
                for (int i = 1; i <= taskSum; i++) {
                    System.out.println("    " + i + ". " + tasks[i-1]);
                }
                System.out.println("____________________________________________________________");
            }
            userCommand = scanner.nextLine();
        }
        scanner.close();
        System.out.println("____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
