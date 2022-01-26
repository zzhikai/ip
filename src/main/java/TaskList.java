import java.io.*;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Scanner;


public class TaskList {

    static String path = "src/main/java/duke.txt";
    private ArrayList<Task> taskStore;

    // read from file first then pass to TaskList to finalised in a sense and work with list from here
    public TaskList(ArrayList<Task> taskDatabase) {
        this.taskStore = taskDatabase;
    }

    public ArrayList<Task> getTaskStore() {
        return taskStore;
    }

    public void mark(int taskIndex) throws DukeException {
        checkTaskIndex(taskIndex);
        this.taskStore.get(taskIndex).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskStore.get(taskIndex).toString());
    }

    public void unMark(int taskIndex) throws DukeException {
        checkTaskIndex(taskIndex);
        this.taskStore.get(taskIndex).unMark();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(taskStore.get(taskIndex).toString());
        // need to catch error when taskIndex is invalid;
    }

    public void deleteTask(int taskIndex) throws DukeException {
        checkTaskIndex(taskIndex);
        System.out.println("Noted. I've removed this task:");
        System.out.println(taskStore.get(taskIndex).toString());
        taskStore.remove(taskIndex);
        System.out.println(String.format("Now you have %d tasks in the list", this.getSizeOfTaskList()));
    }

    public void checkTaskIndex(int taskIndex) throws DukeException {
        if (taskIndex >= this.getSizeOfTaskList() || taskIndex < 0) {
            throw new DukeException("No task at this number, please try again");
        }
    }
    public int getSizeOfTaskList() {
        return taskStore.size();
    }
    public void printOutTaskList() throws DukeException {
        if (taskStore.size() == 0) {
            throw new EmptyListException("List is empty, please add task");
        }
        for (int i = 0; i < taskStore.size(); i++) {
            System.out.println((i + 1) + "." + taskStore.get(i).toString());
        }
    }

    public void addTask(Task newTask) {
        this.taskStore.add(newTask);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask.toString());
        System.out.println(String.format("Now you have %d tasks in the list", this.getSizeOfTaskList()));
    }

    public static void main(String[] args) throws DukeException {
        // Array of Task instead, each task has its state and behaviour
        ArrayList<Task> inputStore = new ArrayList<Task>();
        String input;
        int index = 0;
    }

}
