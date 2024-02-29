package exceptions.descriptions;

import exceptions.WallybotException;

/**
 * Thrown when the description for a task to add is empty.
 */
public class EmptyDescriptionException extends WallybotException {
    /**
     * Constructor for EmptyDescriptionException.
     */
    public EmptyDescriptionException() {
        message = "Whoopsies, the description for a task cannot be empty :|";
    }
}
