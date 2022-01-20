import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) throws DukeException {
        // Array of Task instead, each task has its state and behaviour
        ArrayList<Task> inputStore = new ArrayList<Task>();
        String input;
        int index = 0;

        hello();

        Scanner chatInput = new Scanner( System.in );

        // commands: todo, deadline, event

        input = chatInput.nextLine();

        while (!input.equals("bye")) {
            try {
                if (input.equals("list")) {
                    for (int i = 0; i < inputStore.size(); i++) {
                        // System.out.println((i + 1) + ". "+ "[" + inputStore[i].getStatusIcon() + "] "  + inputStore[i].description);
                        System.out.println((i + 1) + "." + inputStore.get(i).toString());
                    }
                    input = chatInput.nextLine();
                    // move to next iteration
                    continue;
                }
                try {
                    if (input.contains("deadline")) {
                        if (endIndexOfTask(input) == -1) {
                            throw new EmptyByException("Please remember to include deadline time with /at");
                        }
                        Deadline task = new Deadline(input.substring(indexOfTask("deadline"), endIndexOfTask(input)), input.substring(endIndexOfTask(input) + 4));
                        inputStore.add(task);
                        addTaskMessage();
                        System.out.println("  " + task.toString());
                        printListLengthMessage(inputStore.size());
                        input = chatInput.nextLine();
                        continue;
                    }
                } catch (EmptyByException e){
                    System.out.println(e.getMessage());
                    input = chatInput.nextLine();
                    continue;
                }
                try {
                    if (input.contains("todo")) {
                        if (input.length() != "todo".length()) {
                            Todo task = new Todo(input.substring(indexOfTask("todo")));
                            // inputStore[index++] = task;
                            inputStore.add(task);
                            addTaskMessage();
                            System.out.println("  " + task.toString());
                            printListLengthMessage(inputStore.size());
                            input = chatInput.nextLine();
                            continue;
                        } else {
                            throw new EmptyDescriptionException("OOPS!!! The description of a todo cannot be empty.");
                        }
                    }
                } catch (EmptyDescriptionException e) {
                    System.out.println(e.getMessage());
                    input = chatInput.nextLine();
                    continue;
                }
                try {
                    if (input.contains("event")) {

                        // "/" not found in line
                        if (endIndexOfTask(input) == -1) {
                            throw new EmptyEventAtException("Please remember to include event time and date with /at");
                        }
                        Event task = new Event(input.substring(indexOfTask("event"), endIndexOfTask(input)), input.substring(endIndexOfTask(input) + 4));
                        inputStore.add(task);
                        addTaskMessage();
                        System.out.println("  " + task.toString());
                        printListLengthMessage(inputStore.size());
                        input = chatInput.nextLine();
                        continue;
                    }
                } catch (EmptyEventAtException e) {
                    System.out.println(e.getMessage());
                    input = chatInput.nextLine();
                    continue;
                }
                if (input.contains("unmark")) {
                    // last index
                    int taskNumber = Integer.valueOf(input.substring(input.length() - 1));
                    int taskIndex = taskNumber - 1;
                    inputStore.get(taskIndex).unMark();
                    unmarkMessage();
                    System.out.println(inputStore.get(taskIndex).toString());
                    input = chatInput.nextLine();
                    continue;
                }
                if (input.contains("mark")) {
                    // last index
                    int taskNumber = Integer.valueOf(input.substring(input.length() - 1));
                    int taskIndex = taskNumber - 1;
                    inputStore.get(taskIndex).markAsDone();
                    markMessage();
                    System.out.println(inputStore.get(taskIndex).toString());
                    input = chatInput.nextLine();
                    continue;
                }
                if (input.contains("delete")) {
                    int taskNumber = Integer.valueOf(input.substring(input.length() - 1));
                    int taskIndex = taskNumber - 1;
                    deleteTaskMessage();
                    System.out.println(inputStore.get(taskIndex).toString());
                    inputStore.remove(taskIndex);
                    printListLengthMessage(inputStore.size());
                    input = chatInput.nextLine();
                    continue;
                }
                throw new InvalidCommandException("OOPS!!! I'm sorry, but i don't know what that means :-(");
            }
            catch (InvalidCommandException e){
                System.out.println(e.getMessage());
                input = chatInput.nextLine();
                continue;
            }
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

    public static void deleteTaskMessage() {
        System.out.println("Noted. I've removed this task:");
    }
    public static void printListLengthMessage(int runningIndex) {
        System.out.println(String.format("Now you have %d tasks in the list", runningIndex));
    }
}
