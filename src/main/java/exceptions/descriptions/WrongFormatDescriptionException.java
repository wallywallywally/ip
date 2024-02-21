package exceptions.descriptions;

/**
 * Thrown when the description does not follow the proper format.
 */
public class WrongFormatDescriptionException extends Exception {
    private String type;

    public WrongFormatDescriptionException(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
