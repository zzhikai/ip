package Duke.Command;

import Duke.Exception.DukeException;
import Duke.Exception.EmptyByException;
import Duke.Task.Deadline;
import Duke.Task.Task;
import Duke.TaskList.TaskList;

import java.time.DateTimeException;

/**
 * Represents a command to add deadline task.
 */
public class DeadlineCommand extends Command {
    private Task task;

    /**
     * Creates a DeadlineCommand with deadline task.
     *
     * @param description Description of deadline task.
     * @throws DukeException If description is empty or is of an invalid format.
     */
    public DeadlineCommand(String description) throws DukeException {
        super(description);
        int deadlineMarker = description.indexOf("/by");
        String[] deadlineInfo = description.split("/by ");
        if (deadlineInfo[0].trim().length() == 0 ) {
            throw new DukeException("Please enter Task Description");
        }
        if (deadlineMarker == -1) {
            throw new EmptyByException("Please remember to include deadline time with /by");
        }
        try {
            this.task = new Deadline(deadlineInfo[0], deadlineInfo[1]);
        } catch (DateTimeException d) {
            throw new DukeException("invalid date input, use yyyy-MM-dd or dd-MM-yyyy or dd/MM/yyyy or dd:MM:yyyy");
        } catch (Exception e) {
            throw new DukeException("Please include correct deadline time");
        }
    }

    /**
     * Executes DeadlineCommand to add deadline task to a TaskList.
     *
     * @param taskList TaskList for command to add task to.
     */
    @Override
    public void callCommand(TaskList taskList) {
        taskList.addTask(this.task);
    }
}
