package Duke.Exception;

/**
 * Represents an exception thrown when command given is not recognised.
 */
public class InvalidCommandException extends DukeException{
    public InvalidCommandException(String errorMessage) {

        super(errorMessage);
    }
}
