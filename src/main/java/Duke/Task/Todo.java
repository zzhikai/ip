package Duke.Task;

/**
 * Represents a Todo Task.
 */
public class Todo extends Task {

    /**
     * Create a Todo Task.
     *
     * @param description Description of the Todo task.
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Returns formatted string representation of Todo task.
     *
     * @return String representation of Todo task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
