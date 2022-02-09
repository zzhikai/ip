package duke.exception;

/**
 * Represents an exception thrown when command given is not recognised.
 */
public class InvalidCommandException extends DukeException {
    /**
     * @param errorMessage
     */
    public InvalidCommandException(String errorMessage) {

        super(errorMessage);
    }
}
