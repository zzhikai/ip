package Duke.Command;

import Duke.Exception.DukeException;
import Duke.Exception.EmptyDescriptionException;
import Duke.Task.Task;
import Duke.TaskList.TaskList;

public class DeleteCommand extends Command {
    private Task task;
    private int taskIndex;
    // private TaskList taskDataList;

    public DeleteCommand(String inputBody) throws DukeException {
        super(inputBody);

        if (inputBody == "") {
            throw new EmptyDescriptionException("OOPS!!! The description cannot be empty.");
        }
        try {
            int taskNumber = Integer.valueOf(inputBody);
            taskIndex = taskNumber - 1;
        } catch (NumberFormatException e) {
            throw new DukeException("Please input number after unmark");
        }
    }

    @Override
    public void callCommand(TaskList taskList) throws DukeException {
        taskList.deleteTask(this.taskIndex);
        // fileStore.saveToFile(taskList.getTaskStore());
    }
}
