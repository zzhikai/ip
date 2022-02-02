package duke.command;

import duke.exception.DukeException;
import duke.tasklist.TaskList;

public class FindCommand extends Command {

    public FindCommand(String searchWord) throws DukeException {
        super(searchWord);
    }

    @Override
    public void callCommand(TaskList taskList) throws DukeException {
        taskList.findTask(this.input);
    }
}
