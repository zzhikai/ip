package Duke.Command;

import Duke.Exception.DukeException;
import Duke.TaskList.TaskList;

public class FindCommand extends Command {

    public FindCommand(String searchWord) throws DukeException {
        super(searchWord);
    }

    @Override
    public void callCommand(TaskList taskList) throws DukeException {
        taskList.findTask(this.input);
    }
}
