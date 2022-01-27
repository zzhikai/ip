package Duke.Command;

import Duke.Exception.DukeException;
import Duke.Exception.EmptyDescriptionException;
import Duke.TaskList.TaskList;

/**
 * Represents a command to delete task.
 */
public class DeleteCommand extends Command {
    private int taskIndex;

    /**
     * Creates a DeleteCommand.
     *
     * @param description Task to be deleted.
     * @throws DukeException If description is empty or is of an invalid format.
     */
    public DeleteCommand(String description) throws DukeException {
        super(description);

        if (description == "") {
            throw new EmptyDescriptionException("OOPS!!! The description cannot be empty.");
        }
        try {
            int taskNumber = Integer.valueOf(description);
            taskIndex = taskNumber - 1;
        } catch (NumberFormatException e) {
            throw new DukeException("Please input number after unmark");
        }
    }

    /**
     * Executes DeleteCommand to delete task from a TaskList.
     *
     * @param taskList TaskList for command to delete task from.
     * @throws DukeException If taskList does not contain task to be deleted.
     */
    @Override
    public void callCommand(TaskList taskList) throws DukeException {
        taskList.deleteTask(this.taskIndex);
    }
}
