package tasks;

/**
 * Event class
 * Task that has start and end times.
 */
public class Event extends Task {
    // ATTRIBUTES
    protected String from;
    protected String to;

    // METHODS
    public Event (String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    /**
     * Get from
     */
    public String getFrom() {
        return from;
    }

    /**
     * Get to
     */
    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString()
            + " (from: " + from
            + " to: " + to + ")";
    }
}
