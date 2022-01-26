package Duke.Command;
import Duke.Exception.DukeException;
import Duke.TaskList.TaskList;

public abstract class Command {
    private String input;

    public Command(String input) {
        this.input = input;
    }

    public void callCommand(TaskList taskList) throws DukeException {
        throw new DukeException("Command not supported");
    };
}
