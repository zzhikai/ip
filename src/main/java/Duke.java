import java.io.File;
import java.io.FileNotFoundException;
import java.time.DateTimeException;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    static String path = "src/main/java/duke.txt";

    private static void printFileContents(String filePath) throws FileNotFoundException {
        File f = new File(filePath);
        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            System.out.println(s.nextLine());
        }

    }
    public static void main(String[] args) throws DukeException {
        // Array of Task instead, each task has its state and behaviour
        ArrayList<Task> inputStore = new ArrayList<Task>();
        String input;
        int index = 0;

        /* try {
            printFileContents(path);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }*/

        hello();

        Scanner chatInput = new Scanner( System.in );

        input = chatInput.nextLine();

        while (!input.equals("bye")) {
            String[] inputStrings = input.trim().split(" ",2);
            String inputCommand = inputStrings[0];
            // has command and body
            String inputBody = inputStrings.length == 2 ? inputStrings[1] : "";
            Task task;
            int taskNumber;
            int taskIndex;
            try {
                switch (inputCommand) {

                    case "list":
                        // need to handle when list is empty
                        if (inputStore.size() == 0) {
                            throw new EmptyListException("List is empty, please add task");
                        }
                        for (int i = 0; i < inputStore.size(); i++) {
                            System.out.println((i + 1) + "." + inputStore.get(i).toString());
                        }
                        break;

                    case "deadline":
                        if (endIndexOfTask(input) == -1) {
                            throw new EmptyByException("Please remember to include deadline time with /by");
                        }
                        boolean inputIsValid = true;
                        // description , by
                        String[] deadlineInfo = inputBody.split("/by ");
                        try {
                            task = new Deadline(deadlineInfo[0], deadlineInfo[1]);
                            inputStore.add(task);
                            addTaskMessage(task);
                            printListLengthMessage(inputStore.size());
                        } catch (DateTimeException d) {
                            throw new DukeException("invalid date input");
                        } catch (Exception e) {
                            inputIsValid = false;
                            throw new DukeException("Please include correct deadline time");
                            // DateTimeFormatter ddMmYyyyformat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                            // date = LocalDate.parse(by, ddMmYyyyformat);
                        }
                        // when date numbers exceed will have null pointer here, do a check for null pointer?
                        break;
                    case "event":
                        if (endIndexOfTask(input) == -1) {
                            throw new EmptyEventAtException("Please remember to include event time and date with /at");
                        }
                        task = new Event(input.substring(indexOfTask("event"), endIndexOfTask(input)), input.substring(endIndexOfTask(input) + 4));
                        inputStore.add(task);
                        addTaskMessage(task);
                        printListLengthMessage(inputStore.size());
                        break;

                    case "todo":
                        if (input.length() != "todo".length() && inputBody != "") {
                            task = new Todo(input.substring(indexOfTask("todo")));
                            // inputStore[index++] = task;
                            inputStore.add(task);
                            addTaskMessage(task);
                            printListLengthMessage(inputStore.size());
                        } else {
                            throw new EmptyDescriptionException("OOPS!!! The description of a todo cannot be empty.");
                        }
                        break;
                    case "mark":
                        taskNumber = Integer.valueOf(input.substring(input.length() - 1));
                        taskIndex = taskNumber - 1;
                        inputStore.get(taskIndex).markAsDone();
                        markMessage();
                        System.out.println(inputStore.get(taskIndex).toString());
                        break;
                    case "unmark":
                        taskNumber = Integer.valueOf(input.substring(input.length() - 1));
                        taskIndex = taskNumber - 1;
                        inputStore.get(taskIndex).unMark();
                        unmarkMessage();
                        System.out.println(inputStore.get(taskIndex).toString());
                        break;
                    case "delete":
                        taskNumber = Integer.valueOf(input.substring(input.length() - 1));
                        taskIndex = taskNumber - 1;
                        deleteTaskMessage();
                        System.out.println(inputStore.get(taskIndex).toString());
                        inputStore.remove(taskIndex);
                        printListLengthMessage(inputStore.size());
                        break;
                    default:
                        throw new InvalidCommandException("OOPS!!! I'm sorry, but i don't know what that means :-(");
                }
            }
            catch (DukeException e) {
                System.out.println(e.getMessage());
            }
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

    public static void addTaskMessage(Task task) {
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task.toString());
    }

    public static void deleteTaskMessage() {
        System.out.println("Noted. I've removed this task:");
    }
    public static void printListLengthMessage(int runningIndex) {
        System.out.println(String.format("Now you have %d tasks in the list", runningIndex));
    }
}
