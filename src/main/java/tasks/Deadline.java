package tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 * Task that has a do-by time.
 */
public class Deadline extends Task {
    // ATTRIBUTES
    protected String by;
    protected LocalDate byDate;

    // METHODS
    public Deadline (String description, String by) {
        super(description);
        this.by = by;
        try {
            byDate = LocalDate.parse(by);
        } catch (DateTimeParseException ignored) {}
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        String byString;
        try {
            byString = byDate.format(DateTimeFormatter.ofPattern("MMM dd yyy"));
        } catch (NullPointerException e) {
            byString = by;
        }

        return "[D]" + super.toString()
            + " (by: " + byString + ")";
    }
}
