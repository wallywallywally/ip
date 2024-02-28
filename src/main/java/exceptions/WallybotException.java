package exceptions;

/**
 * Superclass for Wallybot exceptions.
 */
public abstract class WallybotException extends Exception {
    protected String message;

    public String getMessage() {
        return message;
    }
}
