package duke.command;

import duke.exception.DukeException;
import duke.exception.EmptyByException;
import duke.task.Event;
import duke.task.Task;
import duke.tasklist.TaskList;

/**
 * Represents a command to add event task.
 */
public class EventCommand extends Command {
    private Task task;
    // private TaskList taskDataList;

    /**
     * Creates a EventCommand with event task.
     *
     * @param description Description of event task.
     * @throws DukeException If description is empty or is of an invalid format.
     */
    public EventCommand(String description) throws DukeException {
        super(description);
        int eventMarker = description.indexOf("/at");
        String[] eventInfo = description.split("/at ");
        if (eventInfo[0].trim().length() == 0) {
            throw new DukeException("Please enter Task Description");
        }
        if (eventMarker == -1) {
            throw new EmptyByException("Please remember to include event date with /at");
        }
        this.task = new Event(eventInfo[0], eventInfo[1]);
    }

    /**
     * Executes EventCommand to add event task to a TaskList.
     *
     * @param taskList TaskList for command to add Task to.
     * @return
     */
    @Override
    public String callCommand(TaskList taskList) {
        return taskList.addTask(this.task);
    }
}
