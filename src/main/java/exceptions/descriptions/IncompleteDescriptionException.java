package exceptions.descriptions;

import exceptions.WallybotException;

/**
 * Thrown when the description for a task to add is incomplete.
 */
public class IncompleteDescriptionException extends WallybotException {
    public IncompleteDescriptionException() {
        message = "Oops, the description is incomplete :O";
    }
}
