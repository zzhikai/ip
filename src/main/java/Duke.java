import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        // Array of Task instead, each task has its state and behaviour
        Task[] inputStore = new Task[100];
        String input;
        int index = 0;

        hello();

        Scanner chatInput = new Scanner( System.in );

        // commands: todo, deadline, event

        input = chatInput.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("list")) {
                for (int i = 0; i < index; i++ ) {
                    // System.out.println((i + 1) + ". "+ "[" + inputStore[i].getStatusIcon() + "] "  + inputStore[i].description);
                    System.out.println((i + 1) + "."+ inputStore[i].toString());
                }
                input = chatInput.nextLine();
                // move to next iteration
                continue;
            }
            if (input.contains("deadline")) {
                Deadline task = new Deadline(input.substring(indexOfTask("deadline"), endIndexOfTask(input)), input.substring(endIndexOfTask(input) + 4));
                inputStore[index++] = task;
                addTaskMessage();
                System.out.println("  " + task.toString());
                printListLengthMessage(index);
                input = chatInput.nextLine();
                continue;
            }
            if (input.contains("todo")) {
                Todo task = new Todo(input.substring(indexOfTask("todo")));
                inputStore[index++] = task;
                addTaskMessage();
                System.out.println("  " + task.toString());
                printListLengthMessage(index);
                input = chatInput.nextLine();
                continue;
            }
            if (input.contains("event")) {
                Event task = new Event(input.substring(indexOfTask("event"), endIndexOfTask(input)), input.substring(endIndexOfTask(input) + 4));
                inputStore[index++] = task;
                addTaskMessage();
                System.out.println("  " + task.toString());
                printListLengthMessage(index);
                input = chatInput.nextLine();
                continue;
            }
            if (input.contains("unmark")) {
                // last index
                int taskNumber = Integer.valueOf(input.substring(input.length() - 1));
                int taskIndex = taskNumber - 1;
                inputStore[taskIndex].unMark();
                unmarkMessage();
                System.out.println(inputStore[taskIndex].toString());
                input = chatInput.nextLine();
                continue;
            }
            if (input.contains("mark")) {
                // last index
                int taskNumber = Integer.valueOf(input.substring(input.length() - 1));
                int taskIndex = taskNumber - 1;
                inputStore[taskIndex].markAsDone();
                markMessage();
                System.out.println(inputStore[taskIndex].toString());
                input = chatInput.nextLine();
                continue;
            }
            // inputStore[index++] = new Task(input);
            // System.out.println("added: " + input);
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

    public static int indexOfTask(String command) {
        int index = command.length() + 1;
        return index;
    }

    public static int endIndexOfTask(String input) {
        int index = input.indexOf("/");
        return index;
    }

    public static void addTaskMessage() {
        System.out.println("Got it. I've added this task:");
    }

    public static void printListLengthMessage(int runningIndex) {
        System.out.println(String.format("Now you have %d tasks in the list", runningIndex));
    }
}
