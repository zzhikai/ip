package Duke.Command;

import Duke.Exception.DukeException;
import Duke.Exception.EmptyDescriptionException;
import Duke.TaskList.TaskList;

/**
 * Represents a command to mark task as not done.
 */
public class UnmarkCommand extends Command {
    private int taskIndex;


    /**
     * Creates a UnmarkCommand.
     *
     * @param taskPosition Position of task in the list of task.
     * @throws DukeException If taskPosition is empty or of invalid format.
     */
    public UnmarkCommand(String taskPosition) throws DukeException {
        super(taskPosition);

        if (taskPosition == "") {
            throw new EmptyDescriptionException("OOPS!!! The description cannot be empty.");
        }
        try {
            int taskNumber = Integer.valueOf(taskPosition);
            taskIndex = taskNumber - 1;
        } catch (NumberFormatException e) {
            throw new DukeException("Please input number after unmark");
        }
    }


    /**
     * Execute UnmarkCommand to mark task as done in a TaskList.
     *
     * @param taskList The TaskList for command act on.
     * @throws DukeException If taskList does not contain the task.
     */
    @Override
    public void callCommand(TaskList taskList) throws DukeException {
        taskList.unMark(this.taskIndex);
    }
}
