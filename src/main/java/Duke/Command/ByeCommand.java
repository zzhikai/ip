package Duke.Command;

import Duke.Exception.DukeException;
import Duke.TaskList.TaskList;

public class ByeCommand extends Command {

    public ByeCommand(String inputBody) throws DukeException {
        super(inputBody);
    }

    @Override
    public void callCommand(TaskList taskList) throws DukeException {
    }
}
