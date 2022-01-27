package Duke.Task;

import java.io.Serializable;

/**
 * Represents a task with description and if the task is done.
 */
public class Task implements Serializable {
    protected String description;
    protected boolean isDone;

    /**
     *
     *
     * @param description
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public void unMark() {
        this.isDone = false;
    }

    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}
