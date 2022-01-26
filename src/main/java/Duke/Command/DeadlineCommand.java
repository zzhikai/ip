package Duke.Command;

import Duke.Exception.DukeException;
import Duke.Exception.EmptyByException;
import Duke.Task.Deadline;
import Duke.Task.Task;
import Duke.TaskList.TaskList;

import java.time.DateTimeException;

public class DeadlineCommand extends Command {
    private Task task;
    // private TaskList taskDataList;

    public DeadlineCommand(String inputBody) throws DukeException {
        super(inputBody);
        int deadlineMarker = inputBody.indexOf("/by");
        String[] deadlineInfo = inputBody.split("/by ");
        if (deadlineInfo[0].trim().length() == 0 ) {
            throw new DukeException("Please enter Task Description");
        }
        if (deadlineMarker == -1) {
            throw new EmptyByException("Please remember to include deadline time with /by");
        }
        try {
            this.task = new Deadline(deadlineInfo[0], deadlineInfo[1]);
        } catch (DateTimeException d) {
            throw new DukeException("invalid date input, use yyyy-MM-dd or dd-MM-yyyy or dd/MM/yyyy or dd:MM:yyyy");
        } catch (Exception e) {
            throw new DukeException("Please include correct deadline time");
        }
    }

    @Override
    public void callCommand(TaskList taskList) {
        taskList.addTask(this.task);
        // fileStore.saveToFile(taskList.getTaskStore());
    }
}
