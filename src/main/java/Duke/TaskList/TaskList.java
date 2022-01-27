package Duke.TaskList;

import Duke.Task.Task;
import Duke.Exception.*;
import java.util.ArrayList;


/**
 * Represents a List of Task.
 */
public class TaskList {

    private ArrayList<Task> taskStore;

    /**
     * Creates TaskList with an ArrayList of Task stored.
     *
     * @param taskDatabase ArrayList of Task stored.
     */
    // read from file first then pass to Duke.TaskList.Duke.TaskList to finalised in a sense and work with list from here
    public TaskList(ArrayList<Task> taskDatabase) {
        this.taskStore = taskDatabase;
    }

    /**
     * Returns ArrayList of Task stored.
     *
     * @return ArrayList of Task stored within TaskList.
     */
    public ArrayList<Task> getTaskStore() {
        return taskStore;
    }


    /**
     * Mark task within the TaskList as done.
     *
     * @param taskIndex Position of task on the TaskList to be marked as done.
     * @throws DukeException If no task at taskIndex.
     */
    public void mark(int taskIndex) throws DukeException {
        checkTaskIndex(taskIndex);
        this.taskStore.get(taskIndex).markAsDone();
        System.out.println("Nice! I've marked this task as done:");
        System.out.println(taskStore.get(taskIndex).toString());
    }

    /**
     * Mark task within the TaskList as not done.
     *
     * @param taskIndex Position of task on the TaskList to be marked as not done.
     * @throws DukeException If no task at taskIndex.
     */
    public void unMark(int taskIndex) throws DukeException {
        checkTaskIndex(taskIndex);
        this.taskStore.get(taskIndex).unMark();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(taskStore.get(taskIndex).toString());
        // need to catch error when taskIndex is invalid;
    }

    /**
     * Delete task within the TaskList.
     *
     * @param taskIndex Position of task on the TaskList to delete.
     * @throws DukeException If no task at taskIndex.
     */
    public void deleteTask(int taskIndex) throws DukeException {
        checkTaskIndex(taskIndex);
        System.out.println("Noted. I've removed this task:");
        System.out.println(taskStore.get(taskIndex).toString());
        taskStore.remove(taskIndex);
        System.out.println(String.format("Now you have %d tasks in the list", this.getSizeOfTaskList()));
    }


    /**
     * Checks if position of task given is valid.
     *
     * @param taskIndex Position of task on the TaskList to check.
     * @throws DukeException If no task at taskIndex.
     */
    public void checkTaskIndex(int taskIndex) throws DukeException {
        if (taskIndex >= this.getSizeOfTaskList() || taskIndex < 0) {
            throw new DukeException("No task at this number, please try again");
        }
    }


    /**
     * Return size of A ja/rrayList within the TaskList.
     *
     * @return Integer representation of size of ArrayList inside TaskList.
     */
    public int getSizeOfTaskList() {
        return taskStore.size();
    }

    /**
     * Prints out all task of the ArrayList if not empty,
     *
     * @throws DukeException If existing ArrayList in TaskList is empty.
     */
    public void printOutTaskList() throws DukeException {
        if (taskStore.size() == 0) {
            throw new EmptyListException("List is empty, please add task");
        }
        for (int i = 0; i < taskStore.size(); i++) {
            System.out.println((i + 1) + "." + taskStore.get(i).toString());
        }
    }

    /**
     * Adds new task into ArrayList inside TaskList.
     *
     * @param newTask Task that will be added to the ArrayList of tasks.
     */
    public void addTask(Task newTask) {
        this.taskStore.add(newTask);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + newTask.toString());
        System.out.println(String.format("Now you have %d tasks in the list", this.getSizeOfTaskList()));
    }
}
