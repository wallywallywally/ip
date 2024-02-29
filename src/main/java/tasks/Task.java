package tasks;


/**
 * Stores general information on a task.
 */
public abstract class Task {
    // ATTRIBUTES
    protected String description;
    protected boolean isDone;

    // METHODS
    /**
     * Constructor for Task abstract class. Initialise as not done.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Set isDone.
     */
    public void setDone(boolean state) {
        isDone = state;
    }

    /**
     * Turn isDone into a status icon.
     */
    protected String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    /**
     * Get description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get isDone as an Integer.
     */
    public int getIsDoneInt() {
        return isDone ? 1 : 0;
    }

    /**
     * Return a String representation of the Task.
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
