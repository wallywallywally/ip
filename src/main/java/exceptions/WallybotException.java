package exceptions;

/**
 * Abstract superclass for Wallybot exceptions.
 */
public abstract class WallybotException extends Exception {
    protected String message;

    /**
     * Constructor for WallybotException.
     */
    public WallybotException() {}

    /**
     * Return error message.
     */
    public String getMessage() {
        return message;
    }
}
