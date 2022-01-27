package Duke.Task;

/**
 * Represents an Event Task.
 */
public class Event extends Task{
    protected String at;

    /**
     * Create a Event Task .
     *
     * @param description Description of the Todo task.
     */
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}
