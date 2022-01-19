import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        // Array of Task instead, each task has its state and behaviour
        Task[] inputStore = new Task[100];
        String input;
        int index = 0;

        hello();

        Scanner chatInput = new Scanner( System.in );

        input = chatInput.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                for (int i = 0; i < index; i++ ) {
                    System.out.println((i + 1) + ". "+ "[" + inputStore[i].getStatusIcon() + "] "  + inputStore[i].description);
                }
                input = chatInput.nextLine();
                // move to next iteration
                continue;
            }
            if (input.contains("unmark")) {
                // last index
                int taskNumber = Integer.valueOf(input.substring(input.length() - 1));
                int taskIndex = taskNumber - 1;
                inputStore[taskIndex].unMark();
                unmarkMessage();
                System.out.println("[" + inputStore[taskIndex].getStatusIcon() + "] "  + inputStore[taskIndex].description);
                input = chatInput.nextLine();
                continue;
            }
            if (input.contains("mark")) {
                // last index
                int taskNumber = Integer.valueOf(input.substring(input.length() - 1));
                int taskIndex = taskNumber - 1;
                inputStore[taskIndex].markAsDone();
                markMessage();
                System.out.println("[" + inputStore[taskIndex].getStatusIcon() + "] "  + inputStore[taskIndex].description);
                input = chatInput.nextLine();
                continue;
            }
            inputStore[index++] = new Task(input);
            System.out.println("added: " + input);
            input = chatInput.nextLine();
        }

        System.out.print("Bye. Hope to see you again soon!");
        chatInput.close();
    }

    public static void hello() {
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
    }

    public static void markMessage() {
        System.out.println("Nice! I've marked this task as done:");
    }

    public static void unmarkMessage() {
        System.out.println("OK, I've marked this task as not done yet:");
    }
}
