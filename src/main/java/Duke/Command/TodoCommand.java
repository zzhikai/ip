package Duke.Command;

import Duke.Exception.DukeException;
import Duke.Exception.EmptyDescriptionException;
import Duke.Task.Task;
import Duke.Task.Todo;
import Duke.TaskList.TaskList;

public class TodoCommand extends Command {
    private Task task;
    private TaskList taskListCopy;
    // private TaskList taskDataList;

    public TodoCommand(String inputBody) throws DukeException {
        super(inputBody);
        if (inputBody == "") {
            throw new EmptyDescriptionException("OOPS!!! The description of a todo cannot be empty.");
        } else {
            task = new Todo(inputBody);
        }
    }

    @Override
    public void callCommand(TaskList taskList) {
        this.taskListCopy = taskList;
        this.taskListCopy.addTask(this.task);
        // taskList.addTask(this.task);
        // fileStore.saveToFile(this.taskListCopy.getTaskStore());
    }
}
