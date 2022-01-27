package Duke.Command;
import Duke.Exception.DukeException;
import Duke.TaskList.TaskList;

/**
 * Represents a command.
 */
public abstract class Command {
    private String input;

    /**
     * Create a command.
     *
     * @param input Input from user.
     */
    public Command(String input) {
        this.input = input;
    }

    /**
     * Execute command on a TaskList.
     *
     * @param taskList The TaskList for command act on.
     * @throws DukeException If command not recognized.
     */
    public void callCommand(TaskList taskList) throws DukeException {
        throw new DukeException("Command not supported");
    };
}
