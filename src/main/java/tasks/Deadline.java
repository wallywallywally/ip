package tasks;

/**
 * Task that has a do-by time.
 */
public class Deadline extends Task {
    // ATTRIBUTES
    protected String by;

    // METHODS
    public Deadline (String description, String by) {
        super(description);
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString()
            + " (by: " + by + ")";
    }
}
