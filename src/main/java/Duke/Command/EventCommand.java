package Duke.Command;

import Duke.Exception.DukeException;
import Duke.Exception.EmptyByException;
import Duke.Task.Event;
import Duke.Task.Task;
import Duke.TaskList.TaskList;

public class EventCommand extends Command {
    private Task task;
    // private TaskList taskDataList;

    public EventCommand(String inputBody) throws DukeException {
        super(inputBody);
        int eventMarker = inputBody.indexOf("/at");
        String[] eventInfo = inputBody.split("/at ");
        if (eventInfo[0].trim().length() == 0 ) {
            throw new DukeException("Please enter Task Description");
        }
        if (eventMarker == -1) {
            throw new EmptyByException("Please remember to include event date with /at");
        }
        this.task = new Event(eventInfo[0], eventInfo[1]);
    }

    @Override
    public void callCommand(TaskList taskList) {
        taskList.addTask(this.task);
        // fileStore.saveToFile(taskList.getTaskStore());
    }
}
