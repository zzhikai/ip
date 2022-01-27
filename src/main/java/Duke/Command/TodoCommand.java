package Duke.Command;

import Duke.Exception.DukeException;
import Duke.Exception.EmptyDescriptionException;
import Duke.Task.Task;
import Duke.Task.Todo;
import Duke.TaskList.TaskList;

/**
 * Represents a command to add todo task.
 */
public class TodoCommand extends Command {
    private Task task;
    private TaskList taskListCopy;

    /**
     * Creates a TodoCommand with todo task.
     *
     * @param description Description of todo task.
     * @throws DukeException If description is empty.
     */
    public TodoCommand(String description) throws DukeException {
        super(description);
        if (description == "") {
            throw new EmptyDescriptionException("OOPS!!! The description of a todo cannot be empty.");
        } else {
            task = new Todo(description);
        }
    }

    /**
     * Executes TodoCommand to add todo task to a TaskList.
     *
     * @param taskList TaskList for command to add Task to.
     */
    @Override
    public void callCommand(TaskList taskList) {
        this.taskListCopy = taskList;
        this.taskListCopy.addTask(this.task);
    }
}
