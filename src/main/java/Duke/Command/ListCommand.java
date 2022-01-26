package Duke.Command;

import Duke.Exception.DukeException;
import Duke.Task.Task;
import Duke.TaskList.TaskList;

public class ListCommand extends Command {
    private Task task;
    private int taskIndex;
    // private TaskList taskDataList;

    public ListCommand(String inputBody) throws DukeException {
        super(inputBody);
    }

    @Override
    public void callCommand(TaskList taskList) throws DukeException {
        taskList.printOutTaskList();
    }
}
