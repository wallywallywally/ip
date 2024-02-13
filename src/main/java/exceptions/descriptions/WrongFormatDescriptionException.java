package exceptions.descriptions;

/**
 * Wrong Format Description Exception
 * Thrown when the description does not follow the proper format.
 */
public class WrongFormatDescriptionException extends Exception {
    private String task;

    public WrongFormatDescriptionException(String task) {
        this.task = task;
    }

    public String getType() {
        return task;
    }
}
