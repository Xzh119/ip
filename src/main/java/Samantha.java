import java.util.Scanner;

public class Samantha {
    public static void main(String[] args) {
        System.out.println("____________________________________________________________");
        System.out.println("    Hello! I'm Samantha");
        System.out.println("    What can I do for you?");
        System.out.println("____________________________________________________________");

        Scanner scanner = new Scanner(System.in);
        String userCommand = scanner.nextLine();
        while (!userCommand.equals("bye")) {
            System.out.println("____________________________________________________________");
            System.out.println("    " + userCommand);
            System.out.println("____________________________________________________________");
            userCommand = scanner.nextLine();
        }
        scanner.close();
        System.out.println("____________________________________________________________");
        System.out.println("    Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
