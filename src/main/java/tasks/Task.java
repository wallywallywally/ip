package tasks;

/**
 * Stores general information on a task.
 */
public abstract class Task {
    // ATTRIBUTES
    protected String description;
    protected boolean isDone;

    // METHODS
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
     * Get isDone.
     */
    public int getIsDoneInt() {
        return isDone ? 1 : 0;
    }

    /**
     * Return status and description of task.
     */
    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}
