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

    @Override
    public String toString() {
        return
            "[E]" + super.toString()
            + " (from: " + from
            + " to: " + to + ")";
    }
}
