package Duke.Task;

/**
 * Represents an event task.
 */
public class Event extends Task{
    protected String at;

    /**
     * Create a event task.
     *
     * @param description Description of the event task.
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
